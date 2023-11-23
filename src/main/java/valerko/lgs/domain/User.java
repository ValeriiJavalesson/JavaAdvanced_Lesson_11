package valerko.lgs.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import valerko.lgs.dao.UserRole;

public class User {
	private int id ;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private UserRole role;
	
	public User(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	public User(int id, String firstName, String lastName, String email, String password, UserRole role) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	public User(int id, String firstName, String lastName, String email, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
    public static User map(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String firstName = result.getString("firstName");
        String lastName = result.getString("lastName");
        String email = result.getString("email");
        String password = result.getString("password");
        UserRole role = UserRole.valueOf(result.getString("role").toUpperCase());
        return new User(id, firstName, lastName, email, password, role);
    }
    
	public String getFirstName() {
		return firstName;
	}

	public int getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	public UserRole getRole() {
		return role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", role=" + role +"]";
	}
	
	
	

}
