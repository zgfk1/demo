package com.mybatisplus.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author zgf
 * @description TODO
 * @time 2020/10/27 15:41
 */
@Slf4j
public class ExceptionLogUtils {


    public static void log(Throwable e, Logger c) {

        //        logger.error("错误堆栈", e);

        StackTraceElement s = e.getStackTrace()[0];//数组长度为 1
        c.error("\n\n-----------------" +
                "\n报错文件名:" + s.getFileName() +
                "\n报错的类：" + s.getClassName() +
                "\n报错方法：：" + s.getMethodName() +
                "\n报错的行：" + s.getLineNumber() +
                "\n报错的message：" + e.getMessage() +
                "\n错误堆栈：\n" + getStackTrace(e) +
                "\n------------------\n\n");
    }

    /**
     * 获取堆栈信息
     *
     * @param throwable
     * @return
     */
    public static String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        try {
            throwable.printStackTrace(pw);
            return sw.toString();
        } finally {
            pw.close();
        }
    }


    public static void logInfo(String msg, Logger c) {

        StackTraceElement[] stacks = Thread.currentThread().getStackTrace();//数组长度为 3
        c.info("\n\n**************" +
                "\n打印文件名：" + stacks[2].getFileName() +
                "\n打印类名：" + stacks[2].getClassName() +
                "\n方法名：" + stacks[2].getMethodName() +
                "\n行号：" + stacks[2].getLineNumber() +
                "\n打印内容:" + msg +
                "\n**************\n\n");
    }
}
