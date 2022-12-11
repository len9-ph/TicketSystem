package com.lgadetsky.TicketSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgadetsky.TicketSystem.model.entity.Department;
import com.lgadetsky.TicketSystem.repository.mapper.DepartmentMapper;

@Service
public class DepartmentService implements GeneralService<Department>{
    
    @Autowired
    private DepartmentMapper mapper;
    
    @Override
    public Department create(Department obj) {
        if (validate(obj)) {
            mapper.insert(obj);
            return obj;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Department findById(Integer id) {
        if (mapper.select(id) == null) {
            throw new RuntimeException();
        } else {
            return mapper.select(id);
        }
    }

    @Override
    public Department update(Department obj) {
        if (validate(obj)) {
            throw new IllegalArgumentException();
        }
        
        if (mapper.select(obj.getId()) == null) {
            throw new RuntimeException();
        } else {
            mapper.update(obj);
        }
        return obj;
    }

    @Override
    public void deleteById(Integer id) {
        mapper.delete(id);
    }

    private boolean validate(Department department) {
        if (department != null) {
            return true;
        } else {
            return false;
        }
    }
}
