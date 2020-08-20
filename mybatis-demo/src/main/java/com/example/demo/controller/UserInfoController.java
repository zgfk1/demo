package com.example.demo.controller;

import com.example.demo.entity.UserInfo;
import com.example.demo.entity.UserInfoUserRole;
import com.example.demo.service.UserInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (UserInfo)表控制层
 *
 * @author zgf
 * @since 2020-08-18 17:21:39
 */
@RestController
@RequestMapping("userInfo")
public class UserInfoController {
    /**
     * 服务对象
     */
    @Resource
    private UserInfoService userInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserInfo selectOne(Integer id) {
        return this.userInfoService.queryById(id);
    }


    @PostMapping("updateUserInfo")
    public UserInfo updateUserInfo(Integer id) {
        return this.userInfoService.updateUserInfo(id);
    }

    @GetMapping("selectUserInfoById")
    public UserInfoUserRole selectUserInfoById(Integer id) {
        return this.userInfoService.selectUserInfoById(id);
    }

    /**
     * 有则更新 没有则添加
     *
     * @param userInfo 用户
     * @return 用户
     */
    @PostMapping("insertUserInfo")
    public Object insertUserInfo(@RequestBody UserInfo userInfo) {
        return this.userInfoService.insertUserInfo(userInfo);
    }
}
