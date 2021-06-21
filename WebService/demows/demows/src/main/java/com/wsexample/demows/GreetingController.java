package com.wsexample.demows;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name){
        int id = 123;
        return new Greeting(id,"Hello "+name);
    }

    @PostMapping("/sendData")
    public Greeting sendGreeting(@RequestBody String data){
        return new Greeting(123, data);
    }
}
