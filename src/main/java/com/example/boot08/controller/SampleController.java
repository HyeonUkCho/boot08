package com.example.boot08.controller;

import com.example.boot08.controller.dto.CarDto;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log
public class SampleController {
    @GetMapping("/")
    public String index() {
        log.info("index");
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        log.info("about");
        return "about";
    }

    @GetMapping("/search")
    public String search() {
        log.info("search");
        return "search";
    }

    @GetMapping("/regist")
    public String regist() {
        log.info("regist");
        return "regist";
    }

    @GetMapping("/sale")
    public String sale() {
        log.info("sale");
        return "sale";
    }


    @RequestMapping("/guest")
    public void forGuest() {
        log.info("guest");
    }

    @RequestMapping("/manager")
    public void forManager() {
        log.info("manager");
    }

    @RequestMapping("/admin")
    public void forAdmin() {
        log.info("admin");
    }
}
