package valerko.lgs.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import valerko.lgs.dao.BucketDao;
import valerko.lgs.domain.Bucket;
import valerko.lgs.utils.ConnectionUtil;

public class BucketDaoImpl implements BucketDao {
	private static final String READ_ALL = "select * from bucket";
	private static final String CREATE = "insert into bucket(`user_id`, `product_id`, `purchase_date`) values (?,?,?)";
	private static final String READ_BY_ID = "select * from bucket where id=?";
	private static final String READ_BY_USER_ID = "select * from bucket where user_id=?";
	private static final String UPDATE_BY_ID = "update bucket set user_id=?, product_id=?, purchase_date = ? where id = ?";
	private static final String DELETE_BY_ID = "delete from bucket where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	private static Logger LOGGER = Logger.getLogger(BucketDaoImpl.class);

	public BucketDaoImpl() {
		this.connection = ConnectionUtil.getInstance().getConnection();
	}

	@Override
	public Bucket create(Bucket bucket) {
		try {
			preparedStatement = connection.prepareStatement(CREATE);
			preparedStatement.setInt(1, bucket.getUserId());
			preparedStatement.setInt(2, bucket.getProductId());
			preparedStatement.setDate(3, new Date(bucket.getPurchaseDate().getTime()));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return bucket;
	}

	@Override
	public Bucket read(Integer id) {
		Bucket bucket = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			bucket = Bucket.map(result);
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return bucket;
	}
	public List<Bucket> readByUserId(Integer id) {
		List<Bucket> listOfBuckets = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_BY_USER_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				listOfBuckets.add(Bucket.map(result));
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return listOfBuckets;
	}

	@Override
	public Bucket update(Bucket bucket) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setInt(1, bucket.getUserId());
			preparedStatement.setInt(2, bucket.getProductId());
			preparedStatement.setDate(3, new Date(bucket.getPurchaseDate().getTime()));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return bucket;
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

	@Override
	public List<Bucket> readAll() {
		List<Bucket> listOfBuckets = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				listOfBuckets.add(Bucket.map(result));
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return listOfBuckets;
	}
}
