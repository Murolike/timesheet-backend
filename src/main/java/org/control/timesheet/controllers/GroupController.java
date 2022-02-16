package org.control.timesheet.controllers;

import org.control.timesheet.models.core.Group;
import org.control.timesheet.models.repositories.GroupRepository;
import org.control.timesheet.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("/index")
    public Iterable<Group> index() {
        return this.groupService.findAll();
    }

    @PostMapping("/add")
    public Group add(@Valid @ModelAttribute Group group) {
        return this.groupService.create(group);
    }

    @PostMapping("/update/{id}")
    public Group update(@PathVariable Integer id, @Valid @ModelAttribute Group group) {
        return this.groupService.update(id, group);
    }

    @GetMapping("/view/{id}")
    public Group view(@PathVariable Integer id) {
        return this.groupService.findById(id);
    }
}
