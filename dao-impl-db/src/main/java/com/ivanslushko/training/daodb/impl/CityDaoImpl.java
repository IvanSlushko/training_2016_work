package daodb.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ivanslushko.training.datamodel.City;
import daodb.CityDao;


@Repository
public class CityDaoImpl implements CityDao{

	
    @Inject
    private JdbcTemplate jdbcTemplate;
	
    @Override
    public City get (Long id) {
        return jdbcTemplate.queryForObject(
                "select * from city where id = ?",
                new Object[] { id }, new BeanPropertyRowMapper<City>(
                		City.class));
    }
    
	@Override
	public void save(City entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<City> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(City entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(City entity) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
