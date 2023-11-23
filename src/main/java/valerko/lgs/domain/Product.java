package valerko.lgs.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class Product {
	private Integer id;
	private String title;
	private String description;
	private Double price;

	public Product(Integer id, String title, String description, Double price) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
	}

	public Product(String title, String description, Double price) {
		this.title = title;
		this.description = description;
		this.price = price;
	}

	public static Product map(ResultSet result) throws SQLException {
		Integer id = result.getInt("id");
		String title = result.getString("title");
		String description = result.getString("description");
		Double price = result.getDouble("price");
		return new Product(id, title, description, price);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product{" + "id=" + id + ", title='" + title + '\'' + ", price=" + price + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Product product = (Product) o;
		return Objects.equals(id, product.id) && Objects.equals(title, product.title)
				&& Objects.equals(description, product.description) && Objects.equals(price, product.price);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, description, price);
	}
}
