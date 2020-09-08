package com.mybatisplus.demo.service;


import com.mybatisplus.demo.entity.RtxNotification;
import com.mybatisplus.demo.entity.UserInfo;
import com.mybatisplus.demo.entity.UserInfoUserRole;

import java.util.List;
import java.util.Map;

/**
 * (UserInfo)表服务接口
 *
 * @author zgf
 * @since 2020-08-18 17:21:38
 */
public interface UserInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserInfo queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param userInfo 实例对象
     * @return 实例对象
     */
    UserInfo insert(UserInfo userInfo);

    /**
     * 修改数据
     *
     * @param userInfo 实例对象
     * @return 实例对象
     */
    UserInfo update(UserInfo userInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    UserInfo updateUserInfo(Integer id);

    UserInfoUserRole selectUserInfoById(Integer id);

    Object insertUserInfo(UserInfo userInfo);

    Map<String, Object> existRtxNotification(RtxNotification rtxNotification);
}
