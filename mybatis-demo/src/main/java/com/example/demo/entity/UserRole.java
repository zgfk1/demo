package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 人员角色关联表(UserRole)实体类
 *
 * @author zgf
 * @since 2020-08-18 17:21:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole implements Serializable {
    private static final long serialVersionUID = -53889771521319876L;
    /**
     * 人员ID
     */
    private String userId;
    /**
     * 角色ID
     */
    private String roleId;
    /**
     * 项目ID
     */
    private Integer projectId;




}
