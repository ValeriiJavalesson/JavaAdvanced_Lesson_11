package valerko.lgs.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Magazine {
	private int id;
	private String title;
	private String description;

	public Magazine(int id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}

	public Magazine(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public static Magazine map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String title = result.getString("title");
		String description = result.getString("description");
		return new Magazine(id, title, description);
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "Magazine [id=" + id + ", title=" + title + "]";
	}
}
