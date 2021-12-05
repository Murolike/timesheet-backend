package org.timesheet.humanresourcesdepartment.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("site")
public class SiteController {
    @GetMapping("/index")
    public String index() {
        return "Hello world";
    }
}
