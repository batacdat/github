package com.sqc.academy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class helloConTroller {
    @RequestMapping("/academy")
    public String academy(@RequestParam (defaultValue = "") String name,@RequestParam (defaultValue = "") String address) {
        return String.format("Hello %s - %s",  name, address);
    }

}
