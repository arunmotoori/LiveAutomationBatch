package temppack;

import java.util.Date;

public class DemoTimeStamp {

	public String generateNewEmail() {
		
		return new Date().toString().replaceAll("\\s","").replaceAll("\\:","")+"@gmail.com";
		
	}

}
