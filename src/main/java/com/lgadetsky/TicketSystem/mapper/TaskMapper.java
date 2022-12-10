package com.lgadetsky.TicketSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lgadetsky.TicketSystem.model.entity.Task;
import com.lgadetsky.TicketSystem.model.entity.TaskItem;

@Mapper
public interface TaskMapper {
    void insertTask(Task task);
    Task selectTask(int id);
    void updateTask(Task task);
    void deleteTask(int id);
    
    void insertTaskItem(TaskItem taskItem);
    TaskItem selectTaskItem(int id);
    List<TaskItem> selectTaskItemByDeveloperId(int id);
    void updateTaskItem(TaskItem taskItem);
    void deleteTaskItem(int id);
    void deleteTaskItemsByTaskId(int id);
}
