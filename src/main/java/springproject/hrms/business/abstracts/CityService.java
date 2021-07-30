package springproject.hrms.business.abstracts;

import springproject.hrms.core.utilities.results.DataResult;
import springproject.hrms.entities.concretes.City;

import java.util.List;

public interface CityService {

    DataResult<List<City>> getAll();
    DataResult<City> getById(int id);
}
