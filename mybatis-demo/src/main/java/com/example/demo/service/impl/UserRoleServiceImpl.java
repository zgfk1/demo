package com.example.demo.service.impl;

import com.example.demo.dao.UserRoleDao;
import com.example.demo.entity.UserRole;
import com.example.demo.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 人员角色关联表(UserRole)表服务实现类
 *
 * @author zgf
 * @since 2020-08-18 17:21:39
 */
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {
    @Resource
    private UserRoleDao userRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param 主键
     * @return 实例对象
     */
    @Override
    public UserRole queryById() {
        return this.userRoleDao.queryById();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<UserRole> queryAllByLimit(int offset, int limit) {
        return this.userRoleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    @Override
    public UserRole insert(UserRole userRole) {
        this.userRoleDao.insert(userRole);
        return userRole;
    }

    /**
     * 修改数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    @Override
    public UserRole update(UserRole userRole) {
        this.userRoleDao.update(userRole);
        return this.queryById();
    }

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 是否成功
     */
    @Override
    public boolean deleteById() {
        return this.userRoleDao.deleteById() > 0;
    }

    @Override
    public int updateUserRole(List<String> userId) {
        List<UserRole> userRoles = new ArrayList<>();
        for (String s : userId) {
            UserRole userRole = new UserRole();
            userRole.setUserId(s);
            userRole.setRoleId("aaaaaaaaaa");
            userRoles.add(userRole);

        }

        return this.userRoleDao.updateUserRole(userRoles);

    }
}
