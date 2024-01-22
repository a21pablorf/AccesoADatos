package org.example.model;

import java.util.List;

public interface DAO<T> {
    T get(long id);

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(T t);

    public boolean deleteById(long id);

    public List<Integer> getAllIds();

    public void updateImage(T book, String f);

    public void updateImageById(long id, String f);

    void deleteAll();
}
