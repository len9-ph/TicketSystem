package com.lgadetsky.TicketSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgadetsky.TicketSystem.model.entity.Task;
import com.lgadetsky.TicketSystem.model.entity.TaskItem;
import com.lgadetsky.TicketSystem.repository.mapper.TaskMapper;

@Service
public class TaskService implements GeneralService<Task>{
    
    @Autowired
    private TaskMapper taskMapper;
    
    @Override
    public Task create(Task obj) {
        if (validateTask(obj)) {
            taskMapper.insertTask(obj);
            return obj;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Task findById(Integer id) {
        return taskMapper.selectTask(id);
//        if (taskMapper.selectTask(id) == null) {
//            throw new RuntimeException();
//        } else {
//            return taskMapper.selectTask(id);
//        }
    }

    @Override
    public Task update(Task obj) {
        if (validateTask(obj)) {
            throw new IllegalArgumentException();
        }
        
        if (taskMapper.selectTask(obj.getId()) == null) {
            throw new RuntimeException();
        } else {
            taskMapper.updateTask(obj);
        }
        return obj;
    }

    @Override
    public void deleteById(Integer id) {
        taskMapper.deleteTask(id);
    }
    
    public TaskItem createTaskItem(TaskItem obj) {
        if (validateTaskItem(obj)) {
            taskMapper.insertTaskItem(obj);
            return obj;
        } else {
            throw new IllegalArgumentException();
        }
    }
    
    public TaskItem findTaskItemById(int id) {
        if (taskMapper.selectTaskItem(id) != null) {
            return taskMapper.selectTaskItem(id);
        } else {
            throw new IllegalArgumentException();
        }
    }
    
    public List<TaskItem> findAllTaskItemsByDevId(int id) {
        return taskMapper.selectTaskItemByDeveloperId(id);
//        if (taskMapper.selectTaskItemByDeveloperId(id) != null) {
//            return taskMapper.selectTaskItemByDeveloperId(id);
//        } else {
//            throw new IllegalArgumentException();
//        }
    }
    
    public TaskItem update(TaskItem obj) {
        if (validateTaskItem(obj)) {
            throw new IllegalArgumentException();
        }
        
        if (taskMapper.selectTask(obj.getId()) == null) {
            throw new RuntimeException();
        } else {
            taskMapper.updateTaskItem(obj);
        }
        return obj;
    }
    
    public void deleteTaskItem(int id) {
        taskMapper.deleteTaskItem(id);
    }
    
    public void deleteTaskItemsByTaskId(int id) {
        taskMapper.deleteTaskItemsByTaskId(id);
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
