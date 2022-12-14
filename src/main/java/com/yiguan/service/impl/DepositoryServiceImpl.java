package com.yiguan.service.impl;

import com.yiguan.common.BaseResponse;
import com.yiguan.common.Result;
import com.yiguan.dao.DepositoryDAO;
import com.yiguan.dao.impl.DepositoryDAOImpl;
import com.yiguan.model.dto.MaterialDTO;
import com.yiguan.service.DepositoryService;

public class DepositoryServiceImpl implements DepositoryService {

    private DepositoryDAO depositoryDAO = new DepositoryDAOImpl();

    @Override
    public BaseResponse<Boolean> materialStorage(MaterialDTO material) {
        if (material == null) {
            return null;
        }
        try {
            depositoryDAO.saveMaterial(material);
            return Result.success(Boolean.TRUE);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
