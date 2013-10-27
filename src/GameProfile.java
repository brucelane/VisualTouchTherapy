

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

import processing.core.PApplet;

public class GameProfile {
	
	/// name, current level, high score, time spent playing, % completed, num wins, num losses ///// 
	boolean hasPlayed;
	int highScore;
	int curScore;
	int timeSpent;
	float percentComp;
	int numWins;
	int numLosses;
	int curLevel;
	
	///// info about games
	String gameName;
	String gameInfo;
	String gameMainPic;
	String gameThumbnail;
	
	//// cheevos
	ArrayList<String> CheevoNames;
	ArrayList<String> CheevoDescription;
	ArrayList<String> CheevoImage;
	
	JSONParser parser = new JSONParser();
	
	GameProfile(){
		
		CheevoNames = new ArrayList();
		CheevoDescription = new ArrayList();
		CheevoImage = new ArrayList();

	}
	
	//// load the achievments and data for each game
	//// and saves it with the game
	////  when player unlocks, pulls the data from here
	public void loadCheevos(){
		
			 try{
				Object obj = parser.parse(new FileReader("data/games/" + gameName + ".json"));
				JSONObject gameDataObject = (JSONObject) obj;

				gameName = (String) gameDataObject.get("name");
				gameInfo = (String) gameDataObject.get("description");
				gameMainPic = (String) gameDataObject.get("main_image");
				gameThumbnail = (String) gameDataObject.get("thumbnail");
				
				/// populate the cheevos
				/// JSONArray jsonarray = (JSONArray) obj;
				JSONArray achievmentArray = (JSONArray) gameDataObject.get(gameName);
				/// String rank = (String) jsonObject.get("rank");
				try{
					for (int i=0; i<achievmentArray.size(); i++) {
	
							JSONObject jsonObject= (JSONObject)achievmentArray.get(i);
							
							String name = (String) jsonObject.get("name");
							// System.out.println("Cheevo name: " + name);
							CheevoNames.add(name);
							
							String desc = (String) jsonObject.get("description");
							// System.out.println("Cheevo description: " + desc);
							CheevoDescription.add(desc);
							
							String img = (String) jsonObject.get("image");
							// System.out.println("Cheevo image: " + img);
							CheevoImage.add(img);
	
					}
				} catch(Exception e){
					System.out.print("cheevo load error: " + e);
				}
				// System.out.print(CheevoDescription.toString());
				
			// catch json parsing errors
			 } catch (FileNotFoundException e) {
					e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}

		/// savePlayerData();
		
		
	}
	

}/// end class
