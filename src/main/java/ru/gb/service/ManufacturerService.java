package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.model.Manufacturer;
import ru.gb.repository.ManufacturerDao;

@Service
@RequiredArgsConstructor
public class ManufacturerService {

    private final ManufacturerDao manufacturerDao;

    public Manufacturer findById(Long id){
        return manufacturerDao.findById(id);
    }
    public Manufacturer save (Manufacturer manufacturer){
        return manufacturerDao.save(manufacturer);
    }
}
