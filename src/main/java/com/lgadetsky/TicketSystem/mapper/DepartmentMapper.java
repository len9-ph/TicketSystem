package com.lgadetsky.TicketSystem.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.lgadetsky.TicketSystem.model.entity.Department;

@Mapper
public interface DepartmentMapper {
    void insert(Department department);
    Department select(int id);
    void update(Department department);
    void delete(int id);
}
