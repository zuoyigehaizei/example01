package com.example.example.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @GetMapping("login")
    public String login(Model model){
        List<User> user = new ArrayList<>();
        user.add(new User("xiaoxiaoming","1"));
        user.add(new User("xiaoli","2"));
        user.add(new User("xiaohei","3"));
        model.addAttribute("map",user);
        return "thymeleafLogin";
    }

    @Scheduled(cron = "0 0 0 1 * ?")
    public void test01(){
        System.out.println("aaaa");
    }
	
	public void test02(){
		System.out.println("w shi xiao hei");
        System.out.println("w shi xiao hua");
		System.out.println("w shi xiao hua");
	}

}
