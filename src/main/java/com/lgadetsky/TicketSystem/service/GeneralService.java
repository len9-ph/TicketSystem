package com.lgadetsky.TicketSystem.service;

import org.springframework.stereotype.Component;

@Component
public interface GeneralService<T> {
    T create(T obj);
    T findById(Integer id);
    T update (T obj);
    void deleteById(Integer id);
}
