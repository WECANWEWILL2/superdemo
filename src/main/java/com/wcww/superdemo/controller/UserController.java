package com.wcww.superdemo.controller;

import com.wcww.superdemo.dao.UserDao;
import com.wcww.superdemo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(path = "/user/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(path = "/user/login", method = RequestMethod.POST)
    public String loginAction(ModelMap modelMap,
                              HttpSession session,
                              @RequestParam("username") String username,
                              @RequestParam("password") String password) {
        User user = userDao.getUserByUsername(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                session.setAttribute("user", user);
                return "redirect:/index";
            } else {
                modelMap.addAttribute("message", "密码错误");
                return "login";
            }
        } else {
            modelMap.addAttribute("message", "用户名不存在");
            return "login";
        }

    }

    @RequestMapping(path = "/user/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(path = "/user/register", method = RequestMethod.POST)
    public String registerAction(ModelMap modelMap,
                                 HttpSession session,
                                 @RequestParam("username") String username,
                                 @RequestParam("password") String password,
                                 @RequestParam("name") String name,
                                 @RequestParam("sex") String sex,
                                 @RequestParam("birth") String birth,
                                 @RequestParam("homeAddress") String homeAdress,
                                 @RequestParam("telephone") String telephone,
                                 @RequestParam("recommender") String recommender,
                                 @RequestParam("industryClub") String industryClub,
                                 @RequestParam("specialCommittee") String specialCommittee
    ) {
        User user = userDao.getUserByUsername(username);
        if (user != null) {
            modelMap.addAttribute("message", "用户名已存在");
            return "register";
        } else {
            int uid = userDao.insert(new User());
            if (uid <= 0) {
                modelMap.addAttribute("message", "数据库错误");
                return "register";
            } else {
                session.setAttribute("user", user);
                return "redirect:/index";
            }
        }
    }
}
