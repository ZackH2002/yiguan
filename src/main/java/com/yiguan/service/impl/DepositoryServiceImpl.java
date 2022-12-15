package com.yiguan.service.impl;

import com.yiguan.common.BaseResponse;
import com.yiguan.common.ErrorCode;
import com.yiguan.common.Result;
import com.yiguan.dao.DepositoryDAO;
import com.yiguan.dao.impl.DepositoryDAOImpl;
import com.yiguan.model.dto.MaterialDTO;
import com.yiguan.model.entity.Depository;
import com.yiguan.model.entity.DepositoryRecord;
import com.yiguan.model.entity.Material;
import com.yiguan.model.vo.DepositoryRecordVO;
import com.yiguan.model.vo.DepositoryStockVO;
import com.yiguan.service.DepositoryService;

import java.util.List;

public class DepositoryServiceImpl implements DepositoryService {

    private DepositoryDAO depositoryDAO = new DepositoryDAOImpl();

    @Override
    public BaseResponse<Boolean> materialStorage(MaterialDTO material, Long userId) {
        if (material == null) {
            return null;
        }
        Long depositoryId = material.getDepositoryId();
        Depository depository = depositoryDAO.queryDepositoryById(depositoryId);
        String name = material.getName();
        DepositoryRecord record = new DepositoryRecord();
        record.setQuantity(material.getQuantity());
        record.setMaterialName(material.getName());
        record.setPrice(material.getPrice());
        record.setApplyRemark("入库操作");
        record.setApplicantId(userId);
        record.setType(0);
        record.setDepositoryName(depository.getDepositoryName());
        // 查询该材料是否已经存在仓库中
        Material queryMaterial = depositoryDAO.queryMaterialById(depositoryId, name);
        if (queryMaterial == null) {
            depositoryDAO.saveMaterial(material);
        } else {
            Long id = queryMaterial.getId();
            depositoryDAO.updateMaterialExist(material.getQuantity(), material.getPrice(), id);
        }
        depositoryDAO.saveDispatchRecord(record);
        return Result.success(Boolean.TRUE);
    }


    @Override
    public BaseResponse<Boolean> materialDelivery(MaterialDTO materialDTO, Long userId) {
        if (materialDTO == null) {
            return null;
        }
        Depository depository = depositoryDAO.queryDepositoryById(materialDTO.getDepositoryId());
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
        DepositoryRecord record = new DepositoryRecord();
        record.setQuantity(materialDTO.getQuantity());
        record.setMaterialName(material.getMaterialName());
        record.setPrice(materialDTO.getPrice());
        record.setApplyRemark("出库操作");
        record.setApplicantId(userId);
        record.setType(1);
        record.setDepositoryName(depository.getDepositoryName());
        // 保存调度记录
        depositoryDAO.saveDispatchRecord(record);
        return Result.success(Boolean.TRUE);
    }

    @Override
    public BaseResponse<List<DepositoryRecordVO>> listInRecords() {
        List<DepositoryRecordVO> list = depositoryDAO.listStorageRecords();
        return Result.success(list);
    }

    @Override
    public BaseResponse<List<DepositoryRecordVO>> listExitRecords() {
        List<DepositoryRecordVO> list = depositoryDAO.listExitRecords();
        return Result.success(list);
    }

    @Override
    public BaseResponse<Boolean> deleteRecord(Long id) {
        if (id == null) {
            return null;
        }
        try {
            depositoryDAO.deleteRecord(id);
            return Result.success(Boolean.TRUE);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BaseResponse<List<DepositoryStockVO>> listDepositoryStock() {
        List<DepositoryStockVO> list = depositoryDAO.listDepositoryStocks();
        return Result.success(list);
    }


    @Override
    public BaseResponse<List<DepositoryStockVO>> listStorageStock() {
        List<DepositoryStockVO> list = depositoryDAO.listTotalStorageCount();
        return Result.success(list);
    }

    @Override
    public BaseResponse<List<DepositoryStockVO>> listExitStock() {
        List<DepositoryStockVO> list = depositoryDAO.listTotalExitCount();
        return Result.success(list);
    }
}
