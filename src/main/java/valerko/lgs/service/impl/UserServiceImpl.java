package valerko.lgs.service.impl;

import java.util.List;

import valerko.lgs.dao.UserDao;
import valerko.lgs.dao.impl.UserDaoImpl;
import valerko.lgs.domain.User;
import valerko.lgs.service.UserService;

public class UserServiceImpl implements UserService {
	private static UserService userServiceImpl;
	private UserDao userDao;

	private UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	public static UserService getUserService() {
		if (userServiceImpl == null) {
			userServiceImpl = new UserServiceImpl();
		}

		return userServiceImpl;
	}

	@Override
	public User create(User t) {
		return userDao.create(t);
	}

	@Override
	public User read(Integer id) {
		return userDao.read(id);
	}

	@Override
	public User update(User t) {
		return userDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		userDao.delete(id);
	}

	@Override
	public List<User> readAll() {
		return userDao.readAll();
	}

	@Override
	public User read(String email) {
		return userDao.read(email);
	}

}
