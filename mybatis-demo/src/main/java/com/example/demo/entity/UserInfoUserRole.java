package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description: TODO
 * @author: zgf
 * @time: 2020/8/19 15:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoUserRole {

    /**
     * 序号
     */
    private Integer id;
    /**
     * 工卡号
     */
    private String userNum;
    /**
     * 姓名
     */
    private String fullName;
    /**
     * 性别
     */
    private String gender;
    /**
     * 民族
     */
    private String nationality;
    /**
     * 身份证
     */
    private String idCard;
    /**
     * 出生年月
     */
    private String birthday;
    /**
     * 政治面貌
     */
    private String politicalStatus;
    /**
     * 入党时间
     */
    private String inPartyTime;
    /**
     * 手机电话
     */
    private String telephone;
    /**
     * 入职公司时间
     */
    private String employTimeCop;
    /**
     * 入职部室时间
     */
    private String employTimeDept;
    /**
     * 专业
     */
    private String major;
    /**
     * 班组
     */
    private String team;
    /**
     * 职称
     */
    private String professioanlTitle;
    /**
     * 职称评聘时间
     */
    private String titleTime;
    /**
     * 设计资格
     */
    private String designQualification;
    /**
     * 在岗信息
     */
    private String positionStatus;
    /**
     * 岗位开始时间
     */
    private String positionStartTime;
    /**
     * 岗位截止时间
     */
    private String positionEndTime;
    /**
     * 职务
     */
    private String postTitle;
    /**
     * 指导老师
     */
    private String tutor;
    /**
     * 排序号
     */
    private String orderNum;

    private String status;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 更新人
     */
    private String updateUser;
    private List<UserRole> userRoles;

    /**
     * 人员ID
     *//*
    private String userId;
    *//**
     * 角色ID
     *//*
    private String roleId;
    *//**
     * 项目ID
     *//*
    private Integer projectId;*/
}
