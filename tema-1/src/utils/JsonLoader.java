package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import simulator.PetriNet;
import java.io.FileReader;

public class JsonLoader {

    public boolean LoadJson(String file){

        boolean loadStatus = true;
        PetriNet petriNet = PetriNet.getInstance();
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(file));
            JSONObject jsonObject = (JSONObject) obj;
            JSONObject jsonObjectPN = (JSONObject) jsonObject.get("PN");
            if (jsonObjectPN != null) {
                JSONArray jsonArray = (JSONArray) jsonObjectPN.get("Locations");
                if(jsonArray == null || jsonArray.size() == 0 ){
                    throw new Exception(" Locations empty");
                } else {
                    for(int i = 0; i < jsonArray.size(); i++){
                        jsonObject = (JSONObject) jsonArray.get(i);
                        petriNet.addLocation(MappingHandler.JsonObjToLocation(jsonObject));
                    }
                }
                jsonArray = (JSONArray) jsonObjectPN.get("Transitions");
                if(jsonArray == null || jsonArray.size() == 0 ){
                    throw new Exception(" Transitions empty");
                } else {
                    for(int i = 0; i<jsonArray.size(); i++){
                        jsonObject = (JSONObject) jsonArray.get(i);
                        petriNet.addTransition(MappingHandler.JsonObjToTransition(jsonObject));
                    }
                }
            } else {
                throw new Exception(" PN empty");
            }
        } catch (Exception e) {
            loadStatus = false;
            e.printStackTrace();
        }
        return loadStatus;
    }
}
