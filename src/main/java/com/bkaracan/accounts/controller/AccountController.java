package com.bkaracan.accounts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/v1/accounts")
public class AccountController {

    @GetMapping("/helloWorld")
    public String helloWorld() {

        return "Hello world, this is account controller.";
    }
}
