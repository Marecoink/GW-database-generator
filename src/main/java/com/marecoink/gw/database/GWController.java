package com.marecoink.gw.database;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GWController {

    @GetMapping
    public String webTest() {
        return "Hello";
    }
}
