package stepDefination;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	
	
	
	@Before("@DelPlace")
	public void beforeScenario() throws IOException
	{
		
		stepDefination m = new stepDefination();
		if(stepDefination.PlaceId ==null)
		m.add_place_paylod("Chinna", "Malayalam", "Asia");
		m.user_calls_with_http_request("addPlaceAPI", "Post");
		m.verify_place_id_created_addplace_ap_imaps_and_verify_name_should_match_to_using("Chinna", "getPlaceAPI");
	}

}
