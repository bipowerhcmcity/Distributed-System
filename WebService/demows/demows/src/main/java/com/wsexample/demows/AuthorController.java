package com.wsexample.demows;

import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {
    @GetMapping("/getBook")
    public Book getBook(@RequestParam(value = "title", defaultValue = "undefined") String title,
                    @RequestParam(value = "publisher", defaultValue = "undefined") String publisher){
            return new Book(title,publisher,new Author("Peter",20));

    }
}
