package com.codestates.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController // 해당 클래스가 REST API의 리소스를 처리하기 위한 API 엔드포인트로 동작함을 표시 & 스프링 빈 등록
@RequestMapping(value = "/v1/members") // 클라이언트 요청을 처리하는 핸들러 메서드를 매핑, 공통 URL 설정 & produces -> JSON 형식으로 데이터 전송하겠다는 뜻
public class MemberController {

    @PostMapping
    public ResponseEntity postMember(@RequestParam("email") String email,
                             @RequestParam("name") String name,
                             @RequestParam("phone") String phone) {
//        System.out.println("# email: " + email);
//        System.out.println("# name: " + name);
//        System.out.println("# phone: " + phone);

//        String response =
//                "{\"" +
//                        "email\":\""+email+"\"," +
//                        "\"name\":\""+name+"\",\"" +
//                        "phone\":\"" + phone+
//                        "\"}";

        //JSON 문자열 수작업을 Map 객체로 대체
        Map<String, String> map = new HashMap<>();
        map.put("email", email);
        map.put("name", name);
        map.put("phone", phone);


        return new ResponseEntity<>(map, HttpStatus.CREATED); // 응답 상태도 함께 리턴, 클라이언트의 요청을 서버가 어떻게 처리했는지 알기 용이함
    }


    @GetMapping("/{member-id}") // 특정 회원 정보 제공
    public ResponseEntity getMember(@PathVariable("member-id")long memberId) {

        System.out.println("memberId = " + memberId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers() {
        System.out.println("MemberController.getMembers");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

