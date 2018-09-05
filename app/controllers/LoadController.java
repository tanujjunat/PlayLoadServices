package controllers;

import javax.inject.Inject;

import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import services.HttpClient;
import services.VehiclePollutionData;
import views.html.*;

public class LoadController extends Controller {
	
	private final Form<PollutionLevel> form;
	
	@Inject
	HttpClient client;
	
	@Inject
	public LoadController(FormFactory formFactory) {
		this.form = formFactory.form(PollutionLevel.class);
	}
	
	public Result load() {
        return ok(load.render(form));
    }
	
	public Result getPollutionData() {
		final Form<PollutionLevel> boundForm = form.bindFromRequest();
		PollutionLevel data = boundForm.get();
		VehiclePollutionData vdata = client.getDBData();
        return ok(pollutiondata.render(vdata));
    }

}
