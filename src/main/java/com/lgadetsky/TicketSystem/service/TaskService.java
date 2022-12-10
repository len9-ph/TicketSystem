package com.lgadetsky.TicketSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lgadetsky.TicketSystem.mapper.TaskMapper;
import com.lgadetsky.TicketSystem.model.entity.Task;
import com.lgadetsky.TicketSystem.model.entity.TaskItem;

public class TaskService implements GeneralService<Task>{
    
    @Autowired
    private TaskMapper mapper;
    
    @Override
    public Task create(Task obj) {
        if (validateTask(obj)) {
            mapper.insertTask(obj);
            return obj;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Task findById(Integer id) {
        if (mapper.selectTask(id) == null) {
            throw new RuntimeException();
        } else {
            return mapper.selectTask(id);
        }
    }

    @Override
    public Task update(Task obj) {
        if (validateTask(obj)) {
            throw new IllegalArgumentException();
        }
        
        if (mapper.selectTask(obj.getId()) == null) {
            throw new RuntimeException();
        } else {
            mapper.updateTask(obj);
        }
        return obj;
    }

    @Override
    public void deleteById(Integer id) {
        mapper.deleteTask(id);
    }
    
    public TaskItem createTaskItem(TaskItem obj) {
        if (validateTaskItem(obj)) {
            mapper.insertTaskItem(obj);
            return obj;
        } else {
            throw new IllegalArgumentException();
        }
    }
    
    public TaskItem findTaskItemById(int id) {
        if (mapper.selectTaskItem(id) != null) {
            return mapper.selectTaskItem(id);
        } else {
            throw new IllegalArgumentException();
        }
    }
    
    public List<TaskItem> findAllTaskItemsByDevId(int id) {
        if (mapper.selectTaskItemByDeveloperId(id) != null) {
            return mapper.selectTaskItemByDeveloperId(id);
        } else {
            throw new IllegalArgumentException();
        }
    }
    
    public TaskItem update(TaskItem obj) {
        if (validateTaskItem(obj)) {
            throw new IllegalArgumentException();
        }
        
        if (mapper.selectTask(obj.getId()) == null) {
            throw new RuntimeException();
        } else {
            mapper.updateTaskItem(obj);
        }
        return obj;
    }
    
    public void deleteTaskItem(int id) {
        mapper.deleteTaskItem(id);
    }
    
    public void deleteTaskItemsByTaskId(int id) {
        mapper.deleteTaskItemsByTaskId(id);
    }
    
    private boolean validateTask(Task task) {
        if (task != null) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean validateTaskItem(TaskItem taskItem) {
        if (taskItem != null) {
            return true;
        } else {
            return false;
        }
    }
}
