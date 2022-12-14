package com.yiguan.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialDTO {

    private Long depositoryId;

    private String name;

    private Integer quantity;

    private Double price;

}
