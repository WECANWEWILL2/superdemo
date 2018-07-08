package com.wcww.superdemo.controller;

import com.wcww.superdemo.dao.UserDao;
import com.wcww.superdemo.entity.User;
import com.wcww.superdemo.service.UserService;
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
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @RequestMapping(path = "/user/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "notlogin", required = false) String notlogin,ModelMap modelMap) {
        if(notlogin!=null){
            modelMap.addAttribute("err_msg","未登录");
        }
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

    @RequestMapping(path = "/user/signup", method = RequestMethod.GET)
    public String register() {
        return "signup";
    }

    @RequestMapping(path = "/user/signup", method = RequestMethod.POST)
    public String registerAction(ModelMap modelMap,
                                 HttpSession session,
                                 @RequestParam("username") String username,
                                 @RequestParam("password") String password,
                                 @RequestParam("name") String name,
                                 @RequestParam("sex") String sex,
                                 @RequestParam("birth") String birth,
                                 @RequestParam("homeAddress") String homeAddress,
                                 @RequestParam("telephone") int telephone,
                                 @RequestParam("recommender") String recommender,
                                 @RequestParam("industryClub") int industryClub,
                                 @RequestParam("specialCommittee") int specialCommittee
    ) {
        User user = new User(username, password, name, sex, birth, homeAddress, telephone, recommender, industryClub, specialCommittee);
        String msg = userService.signUp(user);
        if (msg == null) {
            return "redirect:/index";
        } else {
            modelMap.addAttribute("err_msg", msg);
            return "username";
        }
    }
}

