package com.atguigu.springboot.common.thread.param;

import java.util.Date;
import java.util.List;

import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoryDataSyncParam {
    private String groupCode;
    private List<String> sensors;
    private Date beginTime;
    private Date endTime;
}