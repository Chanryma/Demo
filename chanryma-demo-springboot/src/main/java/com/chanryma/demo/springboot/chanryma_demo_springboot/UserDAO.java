package com.chanryma.demo.springboot.chanryma_demo_springboot;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public List<User> getUserList() {
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setUserId("user_id_" + i);
            user.setUserName("user_name_" + i);
            users.add(user);
        }

        return users;
    }

}
