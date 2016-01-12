package util;

import java.util.List;
import java.util.Optional;

public interface CrudLogic<D, K> {

	public void create(D domain);
	
	public Optional<D> read(K key);
	
	public void update(D domain);
	
	public void delete(D domain);
	
	public List<D> list(String search);
	
}
