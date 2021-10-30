package com.example.demo1.Service;

import com.example.demo1.Dao.IUserDao;
import com.example.demo1.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/User")
public class UserApi {
    @Autowired
    private IUserDao userDao;
   @GetMapping("/login/{id}/{password}")
    public String login(@PathVariable String id,@PathVariable String password){
       User u=userDao.findUserByIdAndPassword(id,password);
       if(u==null){
           return "Please Login in first!";
       }
           return "Welcome"+u.getName()+"!";
   }
   @PostMapping("/login")
    public String loginByIdAndPassword(@RequestParam String id,@RequestParam String password){
       User u=userDao.findUserByIdAndPassword(id,password);
       if(u==null){
           return "Please Login in first!";
       }
       return "Welcome"+u.getName()+"!";
   }
   @PostMapping("/register")
    public String registerUser(@RequestParam String id,@RequestParam String name,@RequestParam String password,@RequestParam int age,@RequestParam boolean sex){
       if(id==null){
           return "Please complete the id";
       }
       User u=new User();
       u.setId(id);
       u.setName(name);
       u.setPassword(password);
       u.setSex(sex);
       u.setAge(age);
       try {
           userDao.save(u);
       }
       catch (Exception e){
           return e.getMessage();
       }

       return "创建成功";
   }

    @PostMapping("/register2")
    public String registerUser2(@RequestBody User user){

        try {
            userDao.save(user);
        }
        catch (Exception e){
            return e.getMessage();
        }

        return "创建成功";
    }

    @PutMapping("Update")
    public String Update(@RequestBody User user){

        try {
            userDao.save(user);
        }
        catch (Exception e){
            return e.getMessage();
        }

        return "修改成功";
    }

    @DeleteMapping("/delete")
    public String DeleteUser(@RequestParam String id){
       userDao.deleteById(id);
       return "删除成功";
    }

}
