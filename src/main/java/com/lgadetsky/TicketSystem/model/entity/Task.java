package com.lgadetsky.TicketSystem.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Task {
    private Integer id;
    private Integer departmentId;
    private String taskName;
    private String taskComment;
    private Status status;
}
