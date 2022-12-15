package com.yiguan.dao;

import com.yiguan.model.dto.MaterialDTO;
import com.yiguan.model.entity.Depository;
import com.yiguan.model.entity.DepositoryRecord;
import com.yiguan.model.entity.Material;
import com.yiguan.model.vo.DepositoryRecordVO;

import java.util.List;

public interface DepositoryDAO {

    /**
     * 新增材料
     * @param material 材料实体
     */
    void saveMaterial(MaterialDTO material);

    /**
     * 通过材料名和仓库id查询材料
     * @param id 仓库id
     * @param name 材料名
     * @return
     */
    Material queryMaterialById(Long id, String name);

    /**
     * 保存已经存在的材料
     * @param count
     * @param price
     * @param id
     */
    void updateMaterialExist(int count, double price, Long id);

    /**
     * 删减已经存在的材料
     * @param count
     * @param price
     * @param id
     */
    void updateMaterial(int count, double price, Long id);

    /**
     * 保存调度记录
     * @param record
     */
    void saveDispatchRecord(DepositoryRecord record);

    /**
     * 通过id查询仓库
     * @param id
     * @return
     */
    Depository queryDepositoryById(Long id);

    /**
     * 查询入库记录
     * @return
     */
    List<DepositoryRecordVO> listStorageRecords();

    /**
     * 查询出库记录
     * @return
     */
    List<DepositoryRecordVO> listExitRecords();


}
