package com.example.cmarket;

import com.example.cmarket.user.User;
import com.example.cmarket.user.UserGrade;
import com.example.cmarket.user.UserService;

public class UserApp {

    public static void main(String[] args) {
//        UserServiceImpl userService = new UserServiceImpl();

        AppConfig appConfig = new AppConfig();
        UserService userService = appConfig.userService();

        User user = new User(0L, "kimcoding", UserGrade.GRADE_2);
        userService.signup(user);

        User currentUser = userService.findUser(0L);
        System.out.println("signUp user = " + user.getName());
        System.out.println("currentUser = " + currentUser.getName());

        if(user.getName().equals(currentUser.getName())) {
            System.out.println("새로 가입한 사용자와 현재 사용자가 같습니다.");
        }

    }
}
