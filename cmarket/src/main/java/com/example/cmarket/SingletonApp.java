package com.example.cmarket;

import com.example.cmarket.user.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonApp {

//    static AppConfig appConfig = new AppConfig();
//
//    static UserService userService1 = appConfig.userService();
//    static UserService userService2 = appConfig.userService();
//
//    public static void main(String[] args) {
//        System.out.println("userService1 : " + userService1);
//        System.out.println("userService1 : " + userService);
//    }

    /**
     * 싱글톤 패턴을 적용한 코드
     */
//    static SingletonService singletonService1 = SingletonService.getInstance();
//    static SingletonService singletonService2 = SingletonService.getInstance();
//
//    public static void main(String[] args) {
//        System.out.println("singletonService1 = " + singletonService1);
//        System.out.println("singletonService2 = " + singletonService2);
//    }

    /**
     * 싱글톤 컨테이너 코드
     */

    static AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    static UserService userService1 = ac.getBean("userService", UserService.class);
    static UserService userService2 = ac.getBean("userService", UserService.class);

    public static void main(String[] args) {
        System.out.println("userService1 = " + userService1);
        System.out.println("userService1 = " + userService2);
    }

}
