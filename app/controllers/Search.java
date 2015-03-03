package controllers;

import static play.data.Form.form;
import models.ChefDetails;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.searchresult;

public class Search extends Controller{
	

	public static Result doSearch() {
		
		final	Form<models.SearchDetails> searchres = form(models.SearchDetails.class).bindFromRequest();
	
		    return ok(searchresult.render(searchres));
			
		}

}
