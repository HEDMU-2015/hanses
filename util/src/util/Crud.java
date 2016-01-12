package util;

import java.util.List;
import java.util.Optional;

public interface Crud<D, K> {

	public void create(DataAccess access, D domain);
	
	public Optional<D> read(DataAccess access, K key);
	
	public void update(DataAccess access, D domain);
	
	public void delete(DataAccess access, D domain);
	
	public List<D> list(DataAccess access, String search);
	
}
