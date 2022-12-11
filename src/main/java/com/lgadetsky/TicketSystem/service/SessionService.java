package com.lgadetsky.TicketSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgadetsky.TicketSystem.model.entity.Session;
import com.lgadetsky.TicketSystem.repository.mapper.SessionMapper;

@Service
public class SessionService implements GeneralService<Session> {

    @Autowired
    private SessionMapper mapper;

    @Override
    public Session create(Session obj) {
        if (validate(obj)) {
            mapper.insert(obj);
            return obj;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Session findById(Integer id) {
        if (mapper.select(id) == null) {
            throw new RuntimeException();
        } else {
            return mapper.select(id);
        }
    }
    
    public Session findByUsername(String username) {
        if (mapper.selectByLogin(username) == null) {
            throw new RuntimeException();
        } else {
            return mapper.selectByLogin(username);
        }
    }

    @Override
    public Session update(Session obj) {
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

    private boolean validate(Session session) {
        if (session != null) {
            return true;
        } else {
            return false;
        }
    }
}
