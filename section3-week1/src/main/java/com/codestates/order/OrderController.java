package com.codestates.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

    //회원 고객이 주문한 커피 주문정보를 등록해주는 핸들러 메서드
    @PostMapping
    public ResponseEntity postOrder (@RequestParam("memberId") long memberId,
                             @RequestParam("coffeeId") long coffeeId) {
//        System.out.println("# memberId: " + memberId);
//        System.out.println("# coffeeId: " + coffeeId);
//
//        String response =
//                "{\"" +
//                        "memberId\":\""+memberId+"\"," +
//                        "\"coffeeId\":\""+coffeeId+"\"" +
//                        "}";
//
//        return response;

        Map<String, Long> map = new HashMap<>();
        map.put("memberId", memberId);
        map.put("coffeeId", coffeeId);

        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @GetMapping("/{order-id}")
    public ResponseEntity getOrder(@PathVariable("order-id") long orderId) {
        System.out.println("# orderId: " + orderId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getOrders() {
        System.out.println(" get Orders");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
