package com.study;

import com.yiguan.dao.DepositoryDAO;
import com.yiguan.dao.impl.DepositoryDAOImpl;
import com.yiguan.model.vo.DepositoryRecordVO;
import org.junit.Test;

import java.util.List;

public class ListStorageRecords {

    private DepositoryDAO dao = new DepositoryDAOImpl();

    @Test
    public void testListRecords() {
        List<DepositoryRecordVO> list = dao.listStorageRecords();
        DepositoryRecordVO vo = list.get(0);
        System.out.println(vo);

    }

}
