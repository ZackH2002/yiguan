package com.yiguan.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepositoryRecord {

    private Long id;

    private String materialName;

    private String depositoryName;

    private int type;

    private int quantity;

    private Long applicantId;

    private String applyRemark;

    private Date applyTime;

    private Double price;
}
