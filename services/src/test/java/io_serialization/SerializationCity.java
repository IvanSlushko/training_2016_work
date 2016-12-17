package io_serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.ivanslushko.training.datamodel.City;

public class SerializationCity {
	public static void main(String[] args) throws Exception {

		ArrayList<City> cityList = new ArrayList<City>();

		for (int i = 0; i < 10; i++) {
			City e = new City();
			e.setCity_ru("City ru " + i);
			e.setCity_en("City en " + i);
			e.setCity_by("City by " + i);
			e.setId(new Long(i));
			cityList.add(e);
		}

		byte[] data = serialize(cityList);
		File file = new File("d://cityList.data");
		if (!file.exists()) {
			file.createNewFile();
		}

		FileUtils.writeByteArrayToFile(file, data);

		byte[] readFileToByteArray = FileUtils.readFileToByteArray(file);
		List<City> deSerializesdList = deSerialize(readFileToByteArray);

		for (City city : deSerializesdList) {
			System.out.println(city);
		}

	}

	public static byte[] serialize(List<City> cityList) throws IOException {

		ByteArrayOutputStream byteOs = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(byteOs);
		out.writeObject(cityList);
		out.close();
		return byteOs.toByteArray();
	}

	public static List<City> deSerialize(byte[] bytes) throws IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bytes));
		List<City> list = (List<City>) in.readObject();
		in.close();
		return list;
	}
}