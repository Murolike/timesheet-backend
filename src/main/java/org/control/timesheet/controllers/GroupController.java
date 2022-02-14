package org.control.timesheet.controllers;

import org.control.timesheet.models.core.Group;
import org.control.timesheet.models.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    @GetMapping("/index")
    public Iterable<Group> index() {
        return groupRepository.findAll();
    }

    @PostMapping("/add")
    public Group add(@Valid @ModelAttribute Group group) {
        groupRepository.save(group);
        return group;
    }

    @PostMapping("/update/{id}")
    public Group update(@PathVariable Integer id, @Valid @ModelAttribute Group group) {
        Group storedGroup = groupRepository.findById(id).orElseThrow(() -> new RuntimeException("Group not found by id " + id));

        storedGroup.setName(group.getName());
        storedGroup.setIsActive(group.getIsActive());

        groupRepository.save(storedGroup);
        return storedGroup;
    }

    @GetMapping("/view/{id}")
    public Group view(@PathVariable Integer id) {
        return groupRepository.findById(id).orElseThrow(() -> new RuntimeException("Group not found by id " + id));
    }
}
