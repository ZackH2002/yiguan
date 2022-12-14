package com.yiguan.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long userId;

    private String userName;

    private String userPassword;

    private int userAuth;

    private Date entryDate;

}
