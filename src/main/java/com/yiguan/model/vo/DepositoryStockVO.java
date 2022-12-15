package com.yiguan.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DepositoryStockVO {

    private Long id;

    private Integer stock;

    private String name;

    private Double price;

    private String materialName;

}
