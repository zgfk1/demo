package com.example.demo.controller;

import com.example.demo.entity.UserRole;
import com.example.demo.service.UserRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 人员角色关联表(UserRole)表控制层
 *
 * @author zgf
 * @since 2020-08-18 17:21:39
 */
@RestController
@RequestMapping("userRole")
public class UserRoleController {
    /**
     * 服务对象
     */
    @Resource
    private UserRoleService userRoleService;

    @PostMapping("updateUserRole")
    public int updateUserRole(@RequestBody Map<String,String> userId) {
        String userId1 = userId.get("userId");
        String[] split = userId1.split(",");
        return this.userRoleService.updateUserRole(Arrays.asList(split));
    }


    @PostMapping("findManyToOne")
    public List<UserRole> findManyToOne(@RequestBody Map<String,String> userId) {
        String userId1 = userId.get("userId");
        UserRole userRole = new UserRole();
        userRole.setUserId(userId1);
        return this.userRoleService.findManyToOne(userRole);
    }

    @PostMapping("findOneToOne")
    public List<UserRole> findOneToOne(@RequestBody Map<String,String> userId) {
        String userId1 = userId.get("userId");
        UserRole userRole = new UserRole();
        userRole.setUserId(userId1);
        return this.userRoleService.findOneToOne(userRole);
    }
}
