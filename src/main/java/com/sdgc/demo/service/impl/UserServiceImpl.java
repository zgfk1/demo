package com.sdgc.demo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sdgc.demo.entity.User;
import com.sdgc.demo.mapper.UserDao;
import com.sdgc.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2020-04-10 10:24:52
 */
@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(int id) {
        return this.userDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userDao.queryAllByLimit(offset, limit);
    }


    /**
     * @param offset: 开始值
     * @param limit:  每页显示多少个
     * @return java.util.List<com.sdgc.demo.entity.User>
     * @description 测试分页
     * @author zgf
     * @date 2020/4/10 14:24
     */
    @Override
    public List<User> findAll(int offset, int limit) {
        log.debug(offset + "++++++++++++" + limit);
        PageHelper.startPage(offset, limit);
        List<User> all = this.userDao.findAll();
        System.out.println(all);
        System.out.println("获取页码" + ((Page) all).getPageNum());
        System.out.println("获取计数列" + ((Page) all).getCountColumn());
        System.out.println("获取订单依据" + ((Page) all).getOrderBy());
        System.out.println("获取页面大小" + ((Page) all).getPageSize());
        System.out.println("获取页面" + ((Page) all).getPages());
        System.out.println("获取结束行" + ((Page) all).getEndRow());
        System.out.println("开始行" + ((Page) all).getStartRow());
        System.out.println("总计" + ((Page) all).getTotal());


        return all;
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(int id) {
        return this.userDao.deleteById(id) > 0;
    }

    @Override
    public Page<User> find(int offset, int limit) {
        log.debug(offset + "++++++++++++" + limit);
        Page<User> page = PageHelper.startPage(offset, limit).doSelectPage(() -> this.userDao.find());
        System.err.println(page);
        log.debug("获取计数列:{}", page.getCountColumn());
        log.debug("得到结果:{}", page.getResult());
        log.debug("获取页码:{}", page.getPageNum());
        log.error("总计:{}", page.getTotal());
        PageInfo<User> userPageInfo = new PageInfo<>(page);
        log.debug(userPageInfo.toString());
        return page;
    }

}