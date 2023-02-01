package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Locations;

public class TestDataBuild {
	
	public AddPlace addPlacePayload(String name, String language, String address) {
		
		AddPlace p = new AddPlace();
	    p.setAccuracy(50);
	    p.setAddress(address);
	    p.setLanguage(language);
	    p.setPhone_number("(+1) 236.516.2065");
	    p.setWebsite("https://rahulshettyacademy.com");
	    p.setName(name);
	    List<String> myList = new ArrayList<String>();
	    myList.add("test1");
	    myList.add("test2");
	    p.setTypes(myList);
	    Locations l = new Locations();
	    l.setLat(-38.3833494);
	    l.setLng(33.427362);
	    p.setLocation(l);
	    return p;
	}

}
