package io_serialization;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws Exception {
		File file = new File("d://xml-storage//city_ser.xml");
		try (ClosableResource fileInputStream = new ClosableResource();) {

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}