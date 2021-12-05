package org.timesheet.humanresourcesdepartment.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employee")
public class EmployeeController {
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
