package al.sda.finalproject.bakeoff.service;

import java.util.List;

public interface GenericService <T> {
    List<T> findAll();
    T findById(Long id);
    void save(T t);
    void deleteById(Long id);
}
