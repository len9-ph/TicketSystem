package com.lgadetsky.TicketSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgadetsky.TicketSystem.mapper.DeveloperMapper;
import com.lgadetsky.TicketSystem.model.entity.Developer;

@Service
public class DeveloperService implements GeneralService<Developer> {

    @Autowired
    private DeveloperMapper mapper;

    @Override
    public Developer create(Developer obj) {
        if (validate(obj)) {
            mapper.insert(obj);
            return obj;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Developer findById(Integer id) {
        if (mapper.select(id) == null) {
            throw new RuntimeException();
        } else {
            return mapper.select(id);
        }
    }

    @Override
    public Developer update(Developer obj) {
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

    private boolean validate(Developer developer) {
        if (developer != null) {
            return true;
        } else {
            return false;
        }

    }
}
