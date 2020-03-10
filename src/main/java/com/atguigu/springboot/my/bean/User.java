package com.atguigu.springboot.my.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors
public class User {

    private Integer id;
    private String username;
    private String Intro_l;
    private String password;
}
