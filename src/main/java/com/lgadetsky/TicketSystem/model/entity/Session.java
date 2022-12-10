package com.lgadetsky.TicketSystem.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Session {
    private Integer id;
    private Integer developerId;
    private String login;
    private String password;
}
