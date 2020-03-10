package com.atguigu.springboot.mapper.primary;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SysConfigMapper {

    @Select("SELECT `value` FROM sys_config WHERE `key` = #{key}")
    String selectValue(@Param("key") String key);
}