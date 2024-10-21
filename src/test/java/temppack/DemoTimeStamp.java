package temppack;

import java.util.Date;

public class DemoTimeStamp {

	public String generateEmail() {
		
		return new Date().toString().replaceAll("\\s","").replaceAll("\\:","")+"@gmail.com";
		
	}

}
