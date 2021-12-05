package org.timesheet.humanresourcesdepartment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.timesheet.humanresourcesdepartment.models.core.Group;
import org.timesheet.humanresourcesdepartment.models.repositories.GroupRepository;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    @GetMapping("/index")
    public Iterable<Group> index() {
        return groupRepository.findAll();
    }

    /**
     * TODO: setCreated + setIsActive не должны быть обязательными для записи
     */
    @PostMapping("/add")
    public Group add(@RequestParam String name) {
        Group group = new Group();
        group.setName(name);
        group.setCreatedAt(new Date());
        group.setIsActive(1);
        groupRepository.save(group);
        return group;
    }

    @PostMapping("/update/{id}")
    public Group update(@PathVariable Integer id, @RequestParam String name) {
        Optional<Group> optionalGroup = groupRepository.findById(id);
        if (optionalGroup.isPresent()) {
            Group group = optionalGroup.get();
            group.setName(name);
            groupRepository.save(group);
        }
        return null;
    }

    @GetMapping("/view/{id}")
    public Optional<Group> view(@PathVariable Integer id) {
        return groupRepository.findById(id);
    }
}
