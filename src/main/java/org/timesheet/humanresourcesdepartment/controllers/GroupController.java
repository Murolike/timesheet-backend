package org.timesheet.humanresourcesdepartment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.timesheet.humanresourcesdepartment.models.core.Group;
import org.timesheet.humanresourcesdepartment.models.repositories.GroupRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
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
