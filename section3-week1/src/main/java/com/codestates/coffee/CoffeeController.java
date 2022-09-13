package com.codestates.coffee;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/coffees", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CoffeeController {

    @PostMapping
    public ResponseEntity postCoffee(@RequestParam("engName") String engName,
                             @RequestParam("korName") String korName
    ) {
//        System.out.println("engName = " + engName);
//        System.out.println("korName = " + korName);
//
//        String response =
//                "{\"" +
//                        "engName\":\""+engName+"\"," +
//                        "\"korName\":\""+korName+"\"" +
//                        "}";
//
//        return response;

        //JSON 문자열 수작업을 Map 객체로 대체
        Map<String, String> map = new HashMap<>();
        map.put("engName", engName);
        map.put("korName", korName);

        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId){
        System.out.println("coffeeId = " + coffeeId);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity getCoffees() {
        System.out.println("CoffeeController.getCoffees");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
