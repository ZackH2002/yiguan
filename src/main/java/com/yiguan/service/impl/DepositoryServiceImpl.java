package com.yiguan.service.impl;

import com.yiguan.common.BaseResponse;
import com.yiguan.common.ErrorCode;
import com.yiguan.common.Result;
import com.yiguan.dao.DepositoryDAO;
import com.yiguan.dao.impl.DepositoryDAOImpl;
import com.yiguan.model.dto.MaterialDTO;
import com.yiguan.model.entity.Material;
import com.yiguan.service.DepositoryService;

public class DepositoryServiceImpl implements DepositoryService {

    private DepositoryDAO depositoryDAO = new DepositoryDAOImpl();

    @Override
    public BaseResponse<Boolean> materialStorage(MaterialDTO material) {
        if (material == null) {
            return null;
        }
        Long depositoryId = material.getDepositoryId();
        String name = material.getName();
        // 查询该材料是否已经存在仓库中
        Material queryMaterial = depositoryDAO.queryMaterialById(depositoryId, name);
        if (queryMaterial == null) {
            depositoryDAO.saveMaterial(material);
        } else {
            Long id = queryMaterial.getId();
            depositoryDAO.updateMaterialExist(material.getQuantity(), material.getPrice(), id);
        }
        return Result.success(Boolean.TRUE);
    }


    @Override
    public BaseResponse<Boolean> materialDelivery(MaterialDTO materialDTO) {
        if (materialDTO == null) {
            return null;
        }
        Integer quantity = materialDTO.getQuantity();
        Double price = materialDTO.getPrice();
        // 查询该材料的具体信息
        Material material = depositoryDAO.queryMaterialById(materialDTO.getDepositoryId(), materialDTO.getName());
        if (material == null) {
            return Result.error(ErrorCode.PARAMS_ERROR, "该材料不存在");
        }
        if (material.getQuantity() < quantity || material.getPrice() < price) {
            return Result.error(ErrorCode.PARAMS_ERROR, "库存不足");
        }
        depositoryDAO.updateMaterial(quantity, price, material.getId());
        return Result.success(Boolean.TRUE);
    }

}
