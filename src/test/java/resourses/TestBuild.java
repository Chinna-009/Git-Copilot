package resourses;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestBuild {
	
	public AddPlace addPlacePayload(String name , String language, String address) 
	{
		AddPlace a = new AddPlace();
	    a.setAccuracy(50);
	    a.setAddress(address);
	    a.setLanguage(language);
	    a.setName(name);
	    a.setPhone_number("(+91) 983 893 3937");
	    a.setWebsite("http://google.com");
	    
	    List<String> myList = new ArrayList<String>();
	    myList.add("shoe park");
	    myList.add("shop");
	    a.setTypes(myList);
	    
	    Location loc = new Location();
	    loc.setLat(38.383494);
		loc.setLng(33.427362);
		a.setLocation(loc);
		
		return a;
	}
	
	public String delPayload(String PlaceId)
	{
		return  "{\r\n    \"place_id\":\""+PlaceId+"\"\r\n}\r\n";
	}

}
