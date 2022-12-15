package com.yiguan.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Depository {

    private Long id;

    private String depositoryName;

    private String address;

    private String introduction;

}
