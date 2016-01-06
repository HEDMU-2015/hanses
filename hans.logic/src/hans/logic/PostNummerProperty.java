package hans.logic;

import java.io.File;

import util.MyProperty;

public class PostNummerProperty {
	private final static File file = new File("postnummer.properties");
	private final static String POSTNUMMERLOGIC = "logic";
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
	

}
