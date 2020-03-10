//package com.atguigu.springboot.common.timertask;
//
//import com.atguigu.springboot.common.thread.TestThread;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Component
//public class TestThreadTask {
//
//    @Autowired
//    private ThreadPoolTaskExecutor executor;
//
////    boolean startJob() {
////        String switchFlag = SysConfig.getValue(SysConfigKey.Test_Thread_SWITCH);
////        if (!Const.SWITCH_ON.equalsIgnoreCase(switchFlag)) {
////            // 定时任务开关没开
////            log.warn("测试未启用");
////            return false;
////        }
////
////        int interval = Integer.valueOf(SysConfig.getValue(SysConfigKey.Test_Thread, "1"));
////
////        executor.execute(new TestThread(interval));
////        log.info("测试已启用");
////        return true;
////    }
//
//}
