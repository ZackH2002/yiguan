package com.yiguan.service;

import com.yiguan.common.BaseResponse;
import com.yiguan.model.dto.MaterialDTO;
import com.yiguan.model.vo.DepositoryRecordVO;

import java.util.List;

public interface DepositoryService {

    /**
     * 材料入库
     * @param materialDTO
     * @return
     */
    BaseResponse<Boolean> materialStorage(MaterialDTO materialDTO, Long userId);

    /**
     * 材料出库
     * @param materialDTO
     * @return
     */
    BaseResponse<Boolean> materialDelivery(MaterialDTO materialDTO, Long userId);

    /**
     * 查询入库
     * @return
     */
    BaseResponse<List<DepositoryRecordVO>> listInRecords();

    /**
     * 查询出库
     * @return
     */
    BaseResponse<List<DepositoryRecordVO>> listExitRecords();

}
