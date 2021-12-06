package org.timesheet.humanresourcesdepartment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.timesheet.humanresourcesdepartment.models.core.Group;
import org.timesheet.humanresourcesdepartment.models.repositories.GroupRepository;

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

    @PostMapping("/add")
    public Group add(@ModelAttribute Group group) {
        groupRepository.save(group);
        return group;
    }

    @PostMapping("/update/{id}")
    public Group update(@PathVariable Integer id, @ModelAttribute Group group) {
        Optional<Group> optionalGroup = groupRepository.findById(id);

        if (optionalGroup.isPresent()) {
            Group storedGroup = optionalGroup.get();
            storedGroup.setName(group.getName());
            storedGroup.setIsActive(group.getIsActive());

            groupRepository.save(storedGroup);
            return storedGroup;
        }

        return null;
    }

    @GetMapping("/view/{id}")
    public Optional<Group> view(@PathVariable Integer id) {
        return groupRepository.findById(id);
    }
}
