package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO, Long> implements TaskService {
    @Override
    public TaskDTO save(TaskDTO object) {

        if(object.getId() == null){
            object.setId(generateRandomId());
        }

        if(object.getAssignedDate() == null){
            object.setAssignedDate(LocalDate.now());
        }

        if (object.getTaskStatus() == null) {
            object.setTaskStatus(Status.OPEN);
        }
        return super.save(object.getId(), object);
    }

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(TaskDTO object) {
        super.update(object.getId(), object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public TaskDTO findById(Long id) {
        return super.findById(id);
    }

    private Long generateRandomId() {
        return (long) (new Random().nextInt(1000) + 1);
    }
}