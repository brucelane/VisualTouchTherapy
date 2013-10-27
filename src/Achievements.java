

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Achievements {
	
	ArrayList<String> CheevoNames;
	ArrayList<String> CheevoDescription;
	ArrayList<String> CheevoImage;
	
	JSONParser parser = new JSONParser();
	
	AppProfile theAppProfile;
	
	Achievements(){
		
		theAppProfile = theAppProfile.getInstance();
		
	}
	
	
	public void loadCheevos(){
		 try {
			 
				Object obj = parser.parse(new FileReader("data/cheevoData.json"));
		 
				JSONObject jsonObject = (JSONObject) obj;
		 
				
				for (int i=0; i < jsonObject.size(); i++){
					
						JSONArray gameData = (JSONArray) jsonObject.get(theAppProfile.gameMode.get(i));
						String gameName = theAppProfile.gameMode.get(i);
						System.out.println(gameName);
						
						
				}
								
								

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
	
		
	}
	
	
	

} /// class
