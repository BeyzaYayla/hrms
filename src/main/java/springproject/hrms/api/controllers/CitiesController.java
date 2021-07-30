package springproject.hrms.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springproject.hrms.business.abstracts.CityService;
import springproject.hrms.core.utilities.results.DataResult;
import springproject.hrms.entities.concretes.City;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {

    private CityService cityService;

    public CitiesController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/getall")
    public DataResult<List<City>> getAll() {
        return this.cityService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<City> getById(int id){
        return this.cityService.getById(id);
    }
}
