package controllers;

import models.ChefDetails;

import com.feth.play.module.pa.providers.password.UsernamePasswordAuthProvider;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import providers.MyUsernamePasswordAuthProvider;
import providers.MyUsernamePasswordAuthProvider.MyLogin;
import views.html.cheflogin;
import views.html.chefsignupsuccess;
import static play.data.Form.form;
public class ChefSignUp extends Controller {
	
	public static Result chefsignup() {
	final	Form<models.ChefDetails> chefDetailsForm = form(models.ChefDetails.class).bindFromRequest();
		return ok(cheflogin.render(chefDetailsForm));
	}

	public static Result doChefSignup() {
		com.feth.play.module.pa.controllers.Authenticate.noCache(response());
		final	Form<models.ChefDetails> chefDetailsForm = form(models.ChefDetails.class).bindFromRequest();
		
		if (chefDetailsForm.hasErrors()) {
			// User did not fill everything properly
			return badRequest(cheflogin.render(chefDetailsForm));
		} else {
			ChefDetails chefDetails = chefDetailsForm.get();
			chefDetails.save();
		    return ok(chefsignupsuccess.render(chefDetailsForm));
			
		}
	}
}
