package com.lgadetsky.TicketSystem.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.lgadetsky.TicketSystem.model.entity.Session;

@Mapper
public interface SessionMapper {
    void insert(Session session);
    Session select(int id);
    Session selectByLogin(String login);
    void update(Session session);
    void delete(int id);
}
