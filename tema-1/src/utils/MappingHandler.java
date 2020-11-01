package utils;

import model.Location;
import model.Transition;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MappingHandler {

    public static Location JsonObjToLocation(JSONObject jsonObject) throws Exception {

        Location location = new Location();
        try {
            location.SetId(jsonObject.get("id").toString());
            location.Set(Integer.parseInt(jsonObject.get("tokens").toString()));

            JSONArray jsonArray = (JSONArray) jsonObject.get("input");
            List<String> ioList = new ArrayList<String>();
            Iterator<String> iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                ioList.add(iterator.next());
            }
            location.SetInput(ioList);

            jsonArray = (JSONArray) jsonObject.get("output");
            ioList = new ArrayList<String>();
            iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                ioList.add(iterator.next());
            }
            location.SetOutput(ioList);
        } catch (Exception e) {
            throw new Exception("JSON ERROR. Location parameters");
        }
        return location;
    }

    public static Transition JsonObjToTransition(JSONObject jsonObject) throws Exception {

        Transition transition = new Transition();
        try {
            transition.SetId(jsonObject.get("id").toString());
            transition.SetMinTime(Integer.parseInt(jsonObject.get("minTime").toString()));
            transition.SetMaxTime(Integer.parseInt(jsonObject.get("maxTime").toString()));

            JSONArray jsonArray = (JSONArray) jsonObject.get("input");
            List<String> ioList = new ArrayList<String>();
            Iterator<String> iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                ioList.add(iterator.next());
            }
            transition.SetInput(ioList);

            jsonArray = (JSONArray) jsonObject.get("output");
            ioList = new ArrayList<String>();
            iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                ioList.add(iterator.next());
            }
            transition.SetOutput(ioList);
        }  catch (Exception e) {
            throw new Exception("JSON ERROR. Transition parameters");
        }
        return transition;
    }
}
