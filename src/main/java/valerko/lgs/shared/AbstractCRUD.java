package valerko.lgs.shared;

import java.util.List;

public interface AbstractCRUD<T> {
	public T create(T t);

	public T read(Integer id);

	public T update(T t);

	public void delete(Integer id);

	public List<T> readAll();
}