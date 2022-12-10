package com.lgadetsky.TicketSystem.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.lgadetsky.TicketSystem.model.entity.Developer;

@Mapper
public interface DeveloperMapper {
    void insert(Developer developer);
    Developer select(int id);
    void delete(int id);
}
