package com.yiguan.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 仓库材料实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Material {

    private Long id;

    private Long depositoryId;

    private String materialName;

    private int quantity;

    private Double price;

}
