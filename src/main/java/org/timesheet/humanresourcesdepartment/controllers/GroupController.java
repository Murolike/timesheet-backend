package org.timesheet.humanresourcesdepartment.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group")
public class GroupController {
    @GetMapping("/index")
    public String index() {
        return "";
    }

    @PostMapping("/add")
    public String add() {
        return "";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Integer id) {
        return "";
    }

    @PostMapping("/delete")
    public String delete() {
        return "";
    }
}
