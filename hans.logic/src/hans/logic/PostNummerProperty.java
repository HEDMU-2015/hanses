package hans.logic;

import java.io.File;

import util.Environment;
import util.MyProperty;

public class PostNummerProperty {
	private final static File file = new File("postnummer.properties");
	private final static String POSTNUMMERLOGIC = "logic";
	private final static String ENVIRONMENT = "environment";
	private final static PostNummerProperty instance = new PostNummerProperty();
	private MyProperty props = new MyProperty(file);

	private PostNummerProperty() {

	}

	public static PostNummerProperty getInstance() {
		return instance;
	}

	public String getLogic() {
		return props.getProperty(POSTNUMMERLOGIC);
	}

	public Environment getEnvironment() {
		String env = props.getProperty(ENVIRONMENT);
		if (env.equalsIgnoreCase(Environment.PROD.name())) {
			return Environment.PROD;
		} else if (env.equalsIgnoreCase(Environment.TEST.name())) {
			return Environment.TEST;
		} else {
			return null;
		}
	}

}
