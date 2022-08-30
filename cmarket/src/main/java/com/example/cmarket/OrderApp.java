package com.example.cmarket;

import com.example.cmarket.order.Order;
import com.example.cmarket.order.OrderService;
import com.example.cmarket.user.User;
import com.example.cmarket.user.UserGrade;
import com.example.cmarket.user.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

//        RateDiscountInfo discountInfo = new RateDiscountInfo();
//
//        User user = new User(0L, "kimcoding", UserGrade.GRADE_1);
//        int discountedPrice = discountInfo.discount(user, 5000);
//
//        if(discountedPrice == 250) {
//            System.out.println("회원 등급에 알맞는 할인이 적용되었습니다.");
//            System.out.println("1등급 회원으로 5000 -> " + discountedPrice);
//        }
//
//        user = new User(0L, "leejava", UserGrade.GRADE_2);
//        discountedPrice = discountInfo.discount(user, 5000);
//
//        if(discountedPrice == 500) {
//            System.out.println("회원 등급에 알맞는 할인이 적용되었습니다.");
//            System.out.println("2등급 회원으로 5000 -> " + discountedPrice);
//        }

        /**
         * 객체 직접 생성 후 메서드 호출 방식
         */
//        AppConfig appConfig = new AppConfig();
//        UserService userService = appConfig.userService();
//        OrderService orderService = appConfig.orderService();

        /**
         * 스프링 컨테이너 DI
         */

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = ac.getBean("userService", UserService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        Long userId = 0L;
        User user = new User(userId, "kimlucky", UserGrade.GRADE_1);
        userService.signup(user);

        Order order = orderService.createOrder(userId, "coffee", 5000);

        System.out.println("order = " + order);
    }
}
