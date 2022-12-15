package com.study;

import com.yiguan.dao.DepositoryDAO;
import com.yiguan.dao.impl.DepositoryDAOImpl;
import com.yiguan.model.entity.DepositoryRecord;
import org.junit.Test;

public class InsertDemo {

    private DepositoryDAO dao = new DepositoryDAOImpl();

    @Test
    public void testInsert() {
        DepositoryRecord record = new DepositoryRecord();
        record.setApplicantId(1L);
        record.setPrice(200.5);
        record.setApplyRemark("操作备注");
        record.setType(0);
        record.setDepositoryName("童装仓库");
        record.setMaterialName("上衣");
        record.setQuantity(100);

        dao.saveDispatchRecord(record);
    }

}
