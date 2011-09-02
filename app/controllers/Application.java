package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void login(String email) {
    	User user = User.findOrCreate(email);
    	session.put("user", user.id);
    	redirect("/status");
    }
    
    public static void status() {
    	User user = User.findById(Long.parseLong(session.get("user")));
    	render(user);
    }

	public static void feedback(Feedback feedback) {
		feedback.save();
		redirect("/status");
	}
}