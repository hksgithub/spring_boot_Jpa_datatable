package com.spring.boot.controller;

import com.alibaba.fastjson.JSONObject;
import com.spring.boot.entity.User;
import com.spring.boot.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    MyService myService;

    @RequestMapping("/")
    public String index()
    {
        return "index";
    }

    @RequestMapping("/all")
    @ResponseBody
    public JSONObject findAll()
    {
        List<User> userList = myService.findAll();
        JSONObject json = new JSONObject();
        json.put("data",userList);
        return json;
    }

    @RequestMapping("/add")
    @ResponseBody
    public JSONObject addOne(User user)
    {
        myService.addOne(user);
        JSONObject json = new JSONObject();
        json.put("data",user);
        return json;
    }

    @RequestMapping("/del")
    public void delOne(Integer id)
    {
        myService.delOne(id);
    }

    @RequestMapping("/find")
    @ResponseBody
    public JSONObject findOne(Integer id)
    {
        User user = myService.findOne(id);
        JSONObject json = new JSONObject();
        json.put("data",user);
        return json;
    }


    @RequestMapping("/modify")
    @ResponseBody
    public JSONObject modifyOne(User user)
    {
        User user1 = myService.modifyOne(user);
        JSONObject json = new JSONObject();
        json.put("data",user1);
        return json;
    }

}
