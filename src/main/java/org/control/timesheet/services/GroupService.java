package org.control.timesheet.services;

import org.control.timesheet.models.core.Group;
import org.control.timesheet.models.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GroupService {
    @Autowired
    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Group create(Group group) {
        this.groupRepository.save(group);

        return group;
    }

    public Group update(Integer id, Group group) {
        Group storedGroup = this.findById(id);

        storedGroup.setName(group.getName());
        storedGroup.setIsActive(group.getIsActive());

        groupRepository.save(storedGroup);

        return storedGroup;
    }

    public Iterable<Group> findAll() {
        return this.groupRepository.findAll();
    }

    public Group findById(Integer id) {
        return this.groupRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found group by id = " + id));
    }
}
