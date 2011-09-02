package models;

import javax.persistence.Entity;
import javax.persistence.UniqueConstraint;

import play.db.jpa.JPABase;
import play.db.jpa.Model;

@Entity
public class User extends Model {
	public String email;
	
	public User() {
	}

	public User(String email) {
		this.email = email;
	}

	public static User findOrCreate(String email) {
		User user = find("email = ?", email).first();
		if (user == null) {
			user = new User(email);
			user.save();
		}
		return user;
	}

}
