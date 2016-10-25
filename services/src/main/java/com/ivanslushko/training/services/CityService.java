package services;

import java.util.List;
import com.ivanslushko.training.datamodel.City;

public interface CityService {
	
	void saveAll(List<City> cities);

	void save(City city);

	City get(Long id);
}
