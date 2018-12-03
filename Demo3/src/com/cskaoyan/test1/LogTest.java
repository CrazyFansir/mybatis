package com.cskaoyan.test1;


import org.apache.log4j.Logger;
import org.junit.Test;

public class LogTest {

    @Test
    public void logTest(){
        Logger logger = Logger.getLogger(LogTest.class);
        //因为当你设置日志级别比较低的时候， 日志级别比你高的日志都会打印出来
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        logger.fatal("fatal");
        System.out.println("systemout");

    }
    //Logger.getLogger()
}
