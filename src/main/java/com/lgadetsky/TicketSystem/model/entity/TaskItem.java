package com.lgadetsky.TicketSystem.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaskItem {
    private Integer id;
    private Integer developerId;
    private Integer taskId;
    private String itemName;
}
