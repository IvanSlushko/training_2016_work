package daodb;

import java.util.List;


import com.ivanslushko.training.datamodel.City;

public interface CityDao {

	City get(Long id);

	void insert(City entity);
	
    void update(City entity);

	void save(City entity);

	void delete(Long id);

	List<City> getAll();

}
