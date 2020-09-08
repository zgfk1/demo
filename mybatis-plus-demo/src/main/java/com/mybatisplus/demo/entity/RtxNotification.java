package com.mybatisplus.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (RtxNotification)实体类
 *
 * @author zgf
 * @since 2020-08-21 11:31:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RtxNotification implements Serializable {
    private static final long serialVersionUID = -42798609974532563L;
    /**
     * 唯一主键
     */
    private Integer id;
    /**
     * 工卡号
     */
    private String name;
    /**
     * 内容
     */
    private String text;
    /**
     * 标题
     */
    private String title;
    /**
     * 发送消息的不通类型
     */
    private String type;
    /**
     * 是否成功
     */
    private String success;
    /**
     * 返回消息
     */
    private String returnMessage;
    private String projectId;

    private String createBy;

    private String createTime;

    private String updateBy;

    private String updateTime;

}
