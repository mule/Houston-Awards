package models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

import play.data.validation.Email;
import play.db.jpa.JPABase;
import play.db.jpa.Model;

@Entity
public class User extends Model {
	@Email
	public String email;
	public String fullname;
	@OneToMany(mappedBy = "user")
	public Set<Feedback> feedbacks;
	
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
	
	public int getPoints() {
		int total = 0;
		for (Feedback f : feedbacks) {
			total += f.points;
		}
		return total;
	}
}
