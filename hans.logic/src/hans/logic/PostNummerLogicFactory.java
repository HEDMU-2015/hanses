package hans.logic;

public class PostNummerLogicFactory {
	
	public PostNummerLogic getPostnummerLogic() {
		try {
			Class<?> c = Class.forName(PostNummerProperty.getInstance().getLogic());
			return (PostNummerLogic) c.newInstance();
		} catch (Exception e) {
			throw new RuntimeException("Class for PostNummerLogic not found", e);
		}
	}

}
