package com.example.shiro_test.Controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther Zoom
 * @Date 2020/7/6 at 10:50
 */
@Controller
public class testController {
    @RequestMapping({"/", "/index"})
    public String test(Model model) {
        model.addAttribute("msg", "Hello！");
        return "index";
    }

    @RequestMapping("/user/add")
    public String add() {
        return "user/add";
    }

    @RequestMapping("/user/update")
    public String update() {
        return "user/update";
    }

    @RequestMapping("/tologin")
    public String tologin() {
        return "tologin";
    }

    @RequestMapping("/login")
    public String login(String username, String password, Model model) {
//     获取当前用户
        Subject subject = SecurityUtils.getSubject();
//      封装用户的登陆数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);//执行登录方法，没有异常就登陆ok跳转首页
            return "index";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "用户名错误！");
            return "tologin";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误！");
            return "tologin";
        }
    }
}
