package org.control.timesheet.services;

import org.control.timesheet.models.core.City;
import org.control.timesheet.models.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Component
public class CityService {
    @Autowired
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City create(City city) {
        this.cityRepository.save(city);
        return city;
    }

    public City update(Integer id, City city) {
        City storedModel = this.findById(id);

        Calendar calendar = new GregorianCalendar();
        Timestamp updatedAt = new Timestamp(calendar.getTimeInMillis()); // can be method in this class

        storedModel.setName(city.getName());
        storedModel.setIsActive(city.getIsActive());
        storedModel.setUpdatedAt(updatedAt);
        this.cityRepository.save(storedModel);
        return storedModel;
    }

    public City findById(Integer id) {
        return this.cityRepository.findById(id).orElseThrow(() -> new RuntimeException("City not founded by id = " + id));
    }

    public Iterable<City> findAll() {
        return this.cityRepository.findAll();
    }
}
