package com.lgadetsky.TicketSystem.model.dto;

import java.util.LinkedList;
import java.util.List;

import com.lgadetsky.TicketSystem.model.entity.Status;
import com.lgadetsky.TicketSystem.model.entity.TaskItem;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaskDTO {
    private Integer id;
    private Integer departmentId;
    private String taskName;
    private String taskComment;
    private Integer status;
    
    private List<TaskItem> taskItems;
    
    public void addItem(TaskItem item) {
        if (taskItems == null) {
            taskItems = new LinkedList<TaskItem>();
        }
        taskItems.add(item);
    }
}
