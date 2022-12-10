package com.lgadetsky.TicketSystem.service;

public interface GeneralService<T> {
    T create(T obj);
    T findById(Integer id);
    T update (T obj);
    void deleteById(Integer id);
}
