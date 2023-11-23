package valerko.lgs.domain;

//import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;

public class Bucket {
	private Integer id;
	private Integer userId;
	private Integer productId;
	private Date purchaseDate;

	public Bucket(Integer id, Integer userId, Integer productId, Date purchaseDate) {
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.purchaseDate = purchaseDate;
	}

	public Bucket(Integer userId, Integer productId, Date date) {
		this.userId = userId;
		this.productId = productId;
		this.purchaseDate = date;
	}

	public static Bucket map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		int userId = result.getInt("user_id");
		int productId = result.getInt("product_id");
		Date purchaseDate = result.getDate("purchase_date");
		return new Bucket(id, userId, productId, purchaseDate);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public String toString() {
		return "Bucket{" + "id=" + id + ", userId=" + userId + ", productId=" + productId + ", purchaseDate="
				+ purchaseDate + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Bucket bucket = (Bucket) o;
		return Objects.equals(id, bucket.id) && Objects.equals(userId, bucket.userId)
				&& Objects.equals(productId, bucket.productId) && Objects.equals(purchaseDate, bucket.purchaseDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, userId, productId, purchaseDate);
	}
}
