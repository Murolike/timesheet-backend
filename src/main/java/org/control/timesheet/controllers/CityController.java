package org.control.timesheet.controllers;

import org.control.timesheet.models.core.City;
import org.control.timesheet.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/index")
    public Iterable<City> index() {
        return this.cityService.findAll();
    }

    @PostMapping("/add")
    public City add(@Valid @ModelAttribute City city) {
        return this.cityService.create(city);
    }

    @PostMapping("/update/{id}")
    public City update(@PathVariable Integer id, @Valid @ModelAttribute City city) {
        return this.cityService.update(id, city);
    }

    @GetMapping("/view/{id}")
    public City view(@PathVariable Integer id) {
        return this.cityService.findById(id);
    }
}
