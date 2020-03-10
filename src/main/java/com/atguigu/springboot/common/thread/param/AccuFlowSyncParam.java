package com.atguigu.springboot.common.thread.param;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccuFlowSyncParam {
    private String groupCode;
    private List<String> sensors;
}
