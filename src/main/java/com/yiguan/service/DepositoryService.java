package com.yiguan.service;

import com.yiguan.common.BaseResponse;
import com.yiguan.model.dto.MaterialDTO;

public interface DepositoryService {

    /**
     * 材料入库
     * @param materialDTO
     * @return
     */
    BaseResponse<Boolean> materialStorage(MaterialDTO materialDTO);

    /**
     * 材料出库
     * @param materialDTO
     * @return
     */
    BaseResponse<Boolean> materialDelivery(MaterialDTO materialDTO);

}
