package com.xsh.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class LinkController {

    @GetMapping("/links")
    public String about() {
        return "links";
    }
}
