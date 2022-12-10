package com.lgadetsky.TicketSystem.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.lgadetsky.TicketSystem.model.entity.Session;

@Mapper
public interface SessionMapper {
    void insert(Session session);
    Session select(int id);
    void update(Session session);
    void delete(int id);
}
