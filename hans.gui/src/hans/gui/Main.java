package hans.gui;

import java.util.List;

import hans.domain.PostNummer;
import hans.logic.PostNummerLogic;
import hans.logic.PostNummerLogicFactory;

public class Main {

	public static void main(String[] args) {
		PostNummerLogic pl = new PostNummerLogicFactory().getPostnummerLogic();
		List<PostNummer> list = pl.list("");
		for (PostNummer p : list) {
			System.out.println(p);
		}
		
//		PostNummer pn = pl.read("7400").get();
//		System.out.println(pn);
//		
//		pn.setBy("Frederiksberg");
//		pn.setPostnr("1001");
//		pl.delete(pn);
//		pl.create(pn);

	}

}
