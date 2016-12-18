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

public class SerializationComplexSample {
	public static void main(String[] args) throws Exception {

		ArrayList<Outer> objectsList = new ArrayList<Outer>();

		for (int i = 0; i < 10; i++) {
			Outer e = new Outer();
			e.setOuterProp(i + "");
			e.setInnerObject(new Inner());
			objectsList.add(e);
		}

		byte[] data = serialize(objectsList);
		File file = new File("d://complexObjectsList.data");
		if (!file.exists()) {
			file.createNewFile();
		}

		FileUtils.writeByteArrayToFile(file, data);

		byte[] readFileToByteArray = FileUtils.readFileToByteArray(file);
		List<Outer> deSerializesdList = deSerialize(readFileToByteArray);

		for (Outer author : deSerializesdList) {
			System.out.println(author);
		}

	}

	public static byte[] serialize(List<Outer> authorsList) throws IOException {

		ByteArrayOutputStream byteOs = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(byteOs);
		out.writeObject(authorsList);
		out.close();
		return byteOs.toByteArray();
	}

	public static List<Outer> deSerialize(byte[] bytes) throws IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bytes));
		@SuppressWarnings("unchecked")
		List<Outer> list = (List<Outer>) in.readObject();
		in.close();
		return list;
	}
}