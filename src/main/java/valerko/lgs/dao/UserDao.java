package valerko.lgs.dao;

import valerko.lgs.domain.User;
import valerko.lgs.shared.AbstractCRUD;

public interface UserDao extends AbstractCRUD<User> {
	public User read(String email);
}
