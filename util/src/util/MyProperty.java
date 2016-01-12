package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MyProperty {
	private Map<String, String> props = new HashMap<>();

	public MyProperty(File file) {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				int index = line.indexOf('=');
				if (index > 0) {
					String key = line.substring(0, index - 1).trim().toLowerCase();
					String value = line.substring(index + 1).trim();
					props.put(key, value);
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getProperty(String property) {
		return props.get(property);
		
	}

}
