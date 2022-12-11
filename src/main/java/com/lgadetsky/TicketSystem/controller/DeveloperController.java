package com.lgadetsky.TicketSystem.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lgadetsky.TicketSystem.model.dto.TaskDTO;
import com.lgadetsky.TicketSystem.model.entity.Task;
import com.lgadetsky.TicketSystem.model.entity.TaskItem;
import com.lgadetsky.TicketSystem.service.TaskService;

@RestController
@RequestMapping("developer")
public class DeveloperController {

    @Autowired
    private TaskService service;

    @GetMapping("/{id}")
    List<TaskDTO> getAllTasks(@PathVariable Integer id) {
        List<TaskItem> taskItems = service.findAllTaskItemsByDevId(id);

        List<Task> tasks = new LinkedList<Task>();
        for (TaskItem item : taskItems) {
            if (!tasks.contains(service.findById(item.getTaskId()))) {
                tasks.add(service.findById(item.getTaskId()));
            }
        }
        List<TaskDTO> result = new LinkedList<TaskDTO>();
        for (Task task : tasks) {
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setId(task.getId());
            taskDTO.setDepartmentId(task.getDepartmentId());
            taskDTO.setTaskName(task.getTaskName());
            taskDTO.setTaskComment(task.getTaskComment());
            taskDTO.setStatus(task.getStatus());
            for (TaskItem item : taskItems) {
                if (task.getId().equals(item.getTaskId())) {
                    taskDTO.addItem(item);
                }
            }
            result.add(taskDTO);
        }
        return result;
    }

    //    @PutMapping("/taskItem/{id}")
    //    TaskItem update(@PathVariable Integer id) {
    //        
    //    }

}
