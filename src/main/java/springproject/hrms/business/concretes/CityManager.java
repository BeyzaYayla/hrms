package springproject.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springproject.hrms.business.abstracts.CityService;
import springproject.hrms.core.utilities.results.DataResult;
import springproject.hrms.core.utilities.results.SuccessDataResult;
import springproject.hrms.dataAccess.abstracts.CityDao;
import springproject.hrms.entities.concretes.City;

import java.util.List;

@Service
public class CityManager implements CityService {

    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>(this.cityDao.findAll(), "Cities listed");
    }

    @Override
    public DataResult<City> getById(int id) {
        return new SuccessDataResult<City>(this.cityDao.getById(id));
    }
}
