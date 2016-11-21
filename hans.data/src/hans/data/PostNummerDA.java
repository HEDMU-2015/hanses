package hans.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import hans.domain.PostNummer;
import util.Crud;
import util.DataAccess;

/**
 * PostNummerDA - DataAccess for table postnummer
 * Test kommentar
 * @author hi
 *
 */
public class PostNummerDA implements Crud<PostNummer, String> {

	private static final String SELECT_ONE = "SELECT bynavn FROM postnummer where postnummer = ?";
	private static final String SELECT_MANY = "SELECT postnummer, bynavn FROM postnummer where UPPER(bynavn) LIKE ? or postnummer LIKE ? ORDER BY postnummer";
	private static final String INSERT_ONE = "INSERT INTO postnummer (postnummer, bynavn) VALUES(?, ?)";
	private static final String UPDATE_ONE = "UPDATE postnummer SET bynavn = ? where postnummer = ?";
	private static final String DELETE_ONE = "DELETE FROM postnummer where postnummer = ?";

	/**
	 * Insert row into table postnummer
	 * 
	 * @param access instance of DataAccess containing Connection to DB
	 * @param domain instance of PostNummer containing information to insert
	 */
	@Override
	public void create(DataAccess access, PostNummer domain) {
		try (PreparedStatement stmt = access.getConnection().prepareStatement(INSERT_ONE);) {
			stmt.setString(1, domain.getPostnr());
			stmt.setString(2, domain.getBy());
			int antal = stmt.executeUpdate();
			if (antal != 1) {
				throw new RuntimeException("Postnummer allready exists");
			}
		} catch (SQLException e) {
			throw new RuntimeException("SQLException caught", e);
		}
		
	}

	/**
	 * Read single row from table postnummer
	 * 
	 * @param access instance of DataAccess containing Connection to DB
	 * @param key primary key for select
	 * @return Optional with instance of PostNummer, if key matches row in table postnummer
	 */
	@Override
	public Optional<PostNummer> read(DataAccess access, String key) {
		try (PreparedStatement stmt = access.getConnection().prepareStatement(SELECT_ONE);) {
			stmt.setString(1, key);
			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					PostNummer pn = new PostNummer();
					pn.setPostnr(key);
					pn.setBy(rs.getString("bynavn"));
					return Optional.of(pn);
				} else {
					return Optional.empty();
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException("SQLException caught", e);
		}
	}

	/**
	 * Update single row in table postnummer
	 * 
	 * @param access instance of DataAccess containing Connection to DB
	 * @param domain instance of PostNummer containing information to update in postnummer
	 */
	@Override
	public void update(DataAccess access, PostNummer domain) {
		try (PreparedStatement stmt = access.getConnection().prepareStatement(UPDATE_ONE);) {
			stmt.setString(1, domain.getBy());
			stmt.setString(2, domain.getPostnr());
			int antal = stmt.executeUpdate();
			if (antal != 1) {
				throw new RuntimeException("Postnummer does not exist");
			}
		} catch (SQLException e) {
			throw new RuntimeException("SQLException caught", e);
		}
		
	}

	/**
	 * Delete single row in table postnummer
	 * 
	 * @param access instance of DataAccess containing Connection to DB
	 * @param domain instance of PostNummer containing primary key of row to delete in table postnummer
	 */
	@Override
	public void delete(DataAccess access, PostNummer domain) {
		try (PreparedStatement stmt = access.getConnection().prepareStatement(DELETE_ONE);) {
			stmt.setString(1, domain.getPostnr());
			int antal = stmt.executeUpdate();
			if (antal != 1) {
				throw new RuntimeException("Postnummer does not exist");
			}
		} catch (SQLException e) {
			throw new RuntimeException("SQLException caught", e);
		}
		
	}

	/**
	 * Return List of PostNummer-objects, according to search-criteria
	 * 
	 * @param access instance of DataAccess containing Connection to DB
	 * @param search search-criteria to match rows in column bynavn in table postnummer
	 * @return List of PostNummer-objects
	 */
	@Override
	public List<PostNummer> list(DataAccess access, String search) {
		try (PreparedStatement stmt = access.getConnection().prepareStatement(SELECT_MANY);) {
			stmt.setString(1, "%" + search + "%");
			stmt.setString(2, search);
			try (ResultSet rs = stmt.executeQuery();) {
				List<PostNummer> list = new ArrayList<>();
				while (rs.next()) {
					PostNummer pn = new PostNummer();
					pn.setPostnr(rs.getString("postnummer"));
					pn.setBy(rs.getString("bynavn"));
					list.add(pn);
				}
				return list;
			}
		} catch (SQLException e) {
			throw new RuntimeException("SQLException caught", e);
		}
	}
	
}
