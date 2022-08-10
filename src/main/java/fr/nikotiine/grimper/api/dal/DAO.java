package fr.nikotiine.grimper.api.dal;

import fr.nikotiine.grimper.api.ApiException;

import java.util.List;

public interface DAO<T> {
    void findOrCreate(T object) throws ApiException;
    T findByPk(int id);
    List<T> findAll();
    int update(T object);
}
