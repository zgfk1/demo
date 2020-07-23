package com.sdgc.demo.controller;

import com.github.pagehelper.Page;
import com.sdgc.demo.entity.User;
import com.sdgc.demo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-04-10 10:24:52
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public User selectOne(int id) {
        return this.userService.queryById(id);
    }


    @PostMapping("/findAllByPage")
    public List<User> findAllByPage(@RequestParam(value = "offset") int offset,
                                    @RequestParam(value = "limit") int limit) {
        return this.userService.findAll(offset, limit);
    }

    @PostMapping("/find")
    public Page<User> find(@RequestParam(value = "offset") int offset, @RequestParam(value = "limit") int limit) {
        return this.userService.find(offset, limit);
    }

    @PostMapping("/test")
    public String test() {
        return "this.userService.findAll(offset, limit)";
    }

}