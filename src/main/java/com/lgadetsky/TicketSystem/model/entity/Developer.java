package com.lgadetsky.TicketSystem.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Developer {
    private Integer id;
    private Integer departmentId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
}
