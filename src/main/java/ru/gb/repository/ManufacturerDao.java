package ru.gb.repository;

import ru.gb.model.Manufacturer;

public interface ManufacturerDao {
    Iterable<Manufacturer> findAll();
    public String findNameById(Long id);
    Manufacturer findById(Long id);
    void insert(Manufacturer manufacturer);
    void update(Manufacturer manufacturer);
    Manufacturer save(Manufacturer manufacturer);
    void deleteById(Long id);
}
