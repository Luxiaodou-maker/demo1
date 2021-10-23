package com.example.demo1.Service;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Hello")
public class HelloApi {
    @RequestMapping(value = "/say/{name}",method = RequestMethod.GET)
     public  String sayName(@PathVariable String name){
        return  name;
    }
    @GetMapping("/say2/{name}")
    public  String sayName2(@PathVariable String name){

        return  name+"这是方法二";
    }
}
