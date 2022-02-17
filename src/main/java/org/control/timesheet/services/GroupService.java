package org.control.timesheet.services;

import org.control.timesheet.models.core.Group;
import org.control.timesheet.models.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
        Group storedModel = this.findById(id);
        Calendar calendar = new GregorianCalendar();
        Timestamp updatedAt = new Timestamp(calendar.getTimeInMillis()); // can be method in this class

        storedModel.setUpdatedAt(updatedAt);
        storedModel.setName(group.getName());
        storedModel.setIsActive(group.getIsActive());

        return groupRepository.save(storedModel);
    }

    public Iterable<Group> findAll() {
        return this.groupRepository.findAll();
    }

    public Group findById(Integer id) {
        return this.groupRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found group by id = " + id));
    }
}
