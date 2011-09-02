package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Feedback extends Model {
	public String message;
	@ManyToOne
	public User user;
	public int points;
}
