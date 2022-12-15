package com.yiguan.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepositoryRecordVO {

    private Long id;

    private String materialName;

    private String depositoryName;

    private Integer quantity;

    private Double price;

    private String applicantName;

    private Date applyTime;

}
