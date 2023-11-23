package valerko.lgs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import valerko.lgs.domain.User;
import valerko.lgs.utils.ConnectionUtil;
import valerko.lgs.dao.UserDao;

public class UserDaoImpl implements UserDao {

	private static final String READ_ALL = "select * from user where is_deleted=false";
	private static final String CREATE = "insert into user(`firstName`, `lastName`, `email`, `password`) values (?,?,?,?)";
	private static final String READ_BY_ID = "select * from user where id =?";
	private static final String READ_BY_EMAIL = "select * from user where email =?";
	private static final String UPDATE_BY_ID = "update user set firstName=?, lastName = ?, email = ?, password = ? where id = ?";
	private static final String DELETE_BY_ID = "update user set is_deleted=true where id=?";
	private static final String DELETE_BY_EMAIL = "update user set is_deleted=true where email=?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	private static Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

	public UserDaoImpl() {
		this.connection = ConnectionUtil.getInstance().getConnection();
	}

	@Override
	public User create(User user) {
		try {
			preparedStatement = connection.prepareStatement(CREATE);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return user;

	}

	@Override
	public User read(Integer id) {
		User user = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			user = User.map(result);
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return user;
	}

	@Override
	public User read(String email) {
		User user = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_EMAIL);
			preparedStatement.setString(1, email);
			ResultSet result = preparedStatement.executeQuery();
			if (result.next())
				user = User.map(result);
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return user;
	}

	@Override
	public User update(User user) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getRole().name());
			preparedStatement.setInt(6, user.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
			;
		}
		return user;
	}

	@Override
	public void delete(Integer id) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}

	public void delete(String email) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_EMAIL);
			preparedStatement.setString(1, email);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}

	@Override
	public List<User> readAll() {
		List<User> listOfUsers = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				listOfUsers.add(User.map(result));
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return listOfUsers;
	}
}
