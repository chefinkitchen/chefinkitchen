package controllers;

import static play.data.Form.form;

import java.util.List;

import com.cik.elasticsearch.ElasticSearchService;
import com.cik.elasticsearch.dto.BaseSearchRequest;
import com.cik.elasticsearch.dto.BaseSearchResponse;

import models.ChefDetails;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.searchresult;

public class Search extends Controller{
	

	public static Result doSearch() {
		
		final	Form<models.SearchDetails> searchres = form(models.SearchDetails.class).bindFromRequest();
		models.SearchDetails searchD = searchres.get();
		System.out.println("searchD === "+searchD);
		BaseSearchRequest req = new BaseSearchRequest();
		req.setChefName(searchD.getKeyword());
		req.setCuisineName(searchD.getKeyword());
		req.setCuisineType(searchD.getKeyword());
		req.setLocation(searchD.getKeyword());
		req.setMenuName(searchD.getKeyword());
		req.setZipCode(searchD.getKeyword());
		System.out.println("Before ==== ");
		System.out.println("req====== "+req);
		
		List<BaseSearchResponse> E= new ElasticSearchService().searchByObj("cik","global", req);
		StringBuffer strBuffer = new StringBuffer();
		for (BaseSearchResponse baseSearchResponse : E) {
			strBuffer.append(Json.toJson(baseSearchResponse));
		}
		searchD.setResult(strBuffer.toString());
		searchres.fill(searchD);
		return ok(searchresult.render(searchres));
			
		}

}
