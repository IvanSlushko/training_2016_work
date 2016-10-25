package services.impl;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

import com.ivanslushko.training.datamodel.City;
import daodb.CityDao;
import services.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Inject
	private CityDao cityDao;

	@Override
	public City get(Long id) {
		return cityDao.get(id);

	}
	
	@Override
	public void saveAll(List<City> cities) {
		for (City city : cities) {
			save(city);
		}
	}


	@Override
	public void save(City city) {
		if (city.getId() == null) {
			cityDao.insert(city);
		} else {
			cityDao.update(city);
		}

	}

}
