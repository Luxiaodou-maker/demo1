package com.example.demo1;
import com.example.demo1.Dao.IUserDao;
import com.example.demo1.Entity.User;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserDaoTest {
 @Autowired
    private IUserDao userDao;

 @Test
    public void CreatUser(){
     User user1=new User();
     user1.setId("20201120506");
     user1.setName("小陆");
     user1.setPassword("1234");
     user1.setAge(19);
     user1.setSex(true);
     userDao.save(user1);
 }
 @Test
    public void Update(){
     User user1=new User();
     user1.setId("20201120506");
     user1.setName("小陆");
     user1.setPassword("12345");
     user1.setAge(19);
     user1.setSex(true);
     userDao.save(user1);
 }
 @Test
    public void InsertUser(){
     List<User> userList=new ArrayList<User>();

     User u1=new User();
     u1.setId("202011205507");
     u1.setName("小黑");
     u1.setPassword("125");
     u1.setAge(19);
     u1.setSex(true);

     User u2=new User();
     u2.setId("20201120508");
     u2.setName("小红");
     u2.setPassword("123");
     u2.setAge(19);
     u2.setSex(false);

     User u3=new User();
     u3.setId("202011205509");
     u3.setName("小bai");
     u3.setPassword("129");
     u3.setAge(19);
     u3.setSex(true);


     userList.add(u1);
     userList.add(u2);
     userList.add(u3);

     userDao.saveAll(userList);

 }
 @Test
    public void findAllUser(){
     List<User> ulist=userDao.findAll();
     System.out.println(" ");
 }
 @Test
    public void Login(){
     User u=userDao.findUserByIdAndPassword("20201120508","123");
     System.out.println(" ");
 }

 @Test
    public void findthanage(){
     List<User> ulist1=userDao.getUserslagerThanAge(19);
     System.out.println(" ");
 }

 @Test
 public void updateUserName()
 {

  int res=userDao.updateUserNameById("202011205507","马冬梅");
  System.out.println(res);
 }
}
