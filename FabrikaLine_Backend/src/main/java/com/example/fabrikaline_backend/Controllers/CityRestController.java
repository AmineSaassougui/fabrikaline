package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.City;
import com.example.fabrikaline_backend.Entities.Item;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.CityServiceImpl;
import com.example.fabrikaline_backend.Services.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/City")
@RestController


public class CityRestController implements IAbstractController<City> {

    //region Construct

    @Autowired
    CityServiceImpl cityService;

    @PostMapping("/add/{countryId}")
    public ResponseEntity<City> addAndAssignItemToCategory(@RequestBody City city, @PathVariable Long countryId) {
        City newcity = cityService.saveAndAssign(countryId, city) ;
        return new ResponseEntity<>(newcity, HttpStatus.CREATED);
    }



    @Override
    public ResponseEntity<City> load(Long id) {
        return null;
    }

    @Override
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id) { cityService.delete(id);}


    @Override
    public ResponseEntity<City> save(City entity) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<City>> saveAll(List<City> entities) throws Exception {
        return null;
    }

    @Override
    @GetMapping("/GetAll")

    public ResponseEntity<List<City>> getAll() throws Exception {
        List<City> cities = cityService.getAll();
        return new ResponseEntity<>(cities,HttpStatus.OK);
    }


    @Override
    public ResponseEntity<List<City>> search(SearchCriteria criteria) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<City>> getAll(Long page, Long size) throws Exception {
        return null;
    }


    @Override
    public ResponseEntity<Long> count() throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteAll(List<Integer> ids) throws Exception {
        return null;
    }
}
