package hans.logic;

import java.util.List;
import java.util.Optional;

import hans.data.PostNummerDA;
import hans.domain.PostNummer;
import util.DataAccess;
import util.LogicTrans;

public class PostNummerLogicImpl implements PostNummerLogic {
	private PostNummerDA postnummerda = new PostNummerDA();

	@Override
	public void create(PostNummer domain) {
		try (DataAccess dataaccess = new DataAccess();) {
			new LogicTrans<>(dataaccess)
				.transaction(() -> postnummerda.create(dataaccess, domain));
		}
	}

	@Override
	public Optional<PostNummer> read(String key) {
		try (DataAccess dataaccess = new DataAccess();) {
			return new LogicTrans<Optional<PostNummer>>(dataaccess)
					.transaction(() -> postnummerda.read(dataaccess, key));				
		}
	}

	@Override
	public void update(PostNummer domain) {
		try (DataAccess dataaccess = new DataAccess();) {
			new LogicTrans<>(dataaccess)
				.transaction(() -> postnummerda.update(dataaccess, domain));
		}
	}

	@Override
	public void delete(PostNummer domain) {
		try (DataAccess dataaccess = new DataAccess();) {
			new LogicTrans<>(dataaccess)
				.transaction(() -> postnummerda.delete(dataaccess, domain));
		}
	}
	
	@Override
	public List<PostNummer> list(String search) {
		try (DataAccess dataaccess = new DataAccess();) {
			return new LogicTrans<List<PostNummer>>(dataaccess)
					.transaction(() -> postnummerda.list(dataaccess, search));				
		}
	}

}
