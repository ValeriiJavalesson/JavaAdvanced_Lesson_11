package valerko.lgs.service;

import valerko.lgs.domain.User;
import valerko.lgs.shared.AbstractCRUD;

public interface UserService extends AbstractCRUD<User>{
	public User read(String email);
}

