package com.ivanslushko.training.daoxml.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.ivanslushko.training.daoapi.ICityDao;
import com.ivanslushko.training.datamodel.City;
import com.thoughtworks.xstream.XStream;

@Repository
public class CityDaoXmlImpl implements ICityDao {

	private XStream xstream;
	private File file;

	@Value("${basePath}")
	private String basePath;

	@PostConstruct
	private void intialize() throws IOException {
		// TODO move to the parent class
		// TODO refactoring: use classname instead of hardcoded filename
		xstream = new XStream();
		xstream.alias("city", City.class);

		file = new File(basePath + "/cityes.xml");
		if (!file.exists()) {
			FileUtils.forceMkdir(file.getParentFile());
			file.createNewFile();
			xstream.toXML(new ArrayList<>(), new FileOutputStream(file));
		}
	}

	@Override
	public City get(Long id) {
		List<City> allCity = readCollection();
		for (City city : allCity) {
			if (city.getId().equals(id)) {
				return city;
			}
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		List<City> allCity = readCollection();
		List<City> newList = new ArrayList<>();
		// don't iterate whole collection
		for (City city : allCity) {
			if (!city.getId().equals(id)) {
				newList.add(city);
			}
		}
		writeCollection(newList);
	}

	@Override
	public List<City> getAll() {
		return readCollection();
	}

	@Override
	public Long insert(final City entity) {
		List<City> allCity = readCollection();
		Long id = getNextId(allCity);
		allCity.add(entity);
		entity.setId(new Long(id));
		writeCollection(allCity);
		return id;
	}

	@Override
	public Long update(final City entity) {
		List<City> allCity = readCollection();
		for (City city : allCity) {
			if (city.getId().equals(entity.getId())) {
				city.setCity_ru(entity.getCity_ru());
				city.setCity_en(entity.getCity_en());
				city.setCity_by(entity.getCity_by());
			}
		}
		writeCollection(allCity);
		return null;
	}

	private List<City> readCollection() {
		return (List<City>) xstream.fromXML(file);
	}

	private void writeCollection(List<City> newList) {
		try {
			xstream.toXML(newList, new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);// TODO custom exception
		}
	}

	private long getNextId(List<City> allCity) {
		return allCity.isEmpty() ? 1l : allCity.get(allCity.size() - 1).getId() + 1;
	}

	@Override
	public void save(City entity) {
		// TODO Auto-generated method stub
	}
}
