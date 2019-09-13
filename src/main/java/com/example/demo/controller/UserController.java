package com.example.demo.controller;

import com.example.demo.dao.UserRepository;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/save")
    public String save(){
        for(int i=0;i<10;i++){
            User user=new User();
            user.setId(i+1);
            user.setName("瓜田李下"+i);
            user.setAge(i);

            userRepository.save(user);
        }

        return "success";
    }

    @RequestMapping("/update")
    public User update(){
        User user=userRepository.getOne(1);
        user.setName("海贼王"+6);

        userRepository.save(user);

        return user;
    }
}
