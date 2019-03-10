package com.me.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.me.beans.ManageReturn;
import com.me.beans.ReturnMessage;
import com.me.beans.User;
import com.me.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description -> pageManager
 * @Author -> xufeng
 * @Data ->
 * @about ->
 **/

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private UserService userService;

    @DeleteMapping("/deleteUser")
    @ResponseBody
    public ReturnMessage deleteUser(@RequestParam("userId")Integer userId,@RequestHeader("Authorization")String token){
        userService.deleteById(userId);
        return new ReturnMessage(true);
    }

    @GetMapping("/selectPage")
    @ResponseBody
    public ManageReturn findPages(@RequestParam("current")Integer current,@RequestParam(value = "email")String email,@RequestParam("identify")Integer identify,@RequestParam("id")Integer id,@RequestParam("name")String name,@RequestHeader("Authorization")String token){
        EntityWrapper<User> entityWrapper = new EntityWrapper();
        if (id!=null){
            entityWrapper.eq("id",id);
        }
        if (email!=null||!email.equals("")){
            entityWrapper.like("email",email);
        }
        if (identify!=null){
            entityWrapper.eq("identify",identify);
        }
        if (name!=null||!name.equals("")) {
            entityWrapper.like("name",name);
        }
        Page page = userService.selectPage(new Page<>(current,6),entityWrapper);
        return new ManageReturn(true,page);
    }

}
