package controllers;

import java.sql.SQLException;
import java.util.Map;
import java.util.ArrayList;

import play.*;
import play.mvc.*;
import play.data.*;

import views.html.*;

import models.hitchhiker42;

public class Application extends Controller {

    //COMMENTED OUT BECAUSE OF COMMENTED OUT COMMENT IN HITCHHIKER42.JAVA
    // public static Result insertIntoTrips(Integer tripId, String currentLocation, String destination, String startTime) throws SQLException {
    //     boolean success = hitchhiker42.insertIntoTrips(new hitchhiker42.TripInfo(tripId, currentLocation, destination, startTime));
    //     if (success){
    //         return ok(edit.render("Trip creation successful"));
    //     } else {
    //         return ok(error.render("Trip creation unsuccessful"));
    //     }
    // }
//--------------------------------------------------------------------------------------------------------------------------------
    public static Result signInEntry(String email, String password) throws SQLException {
        boolean success = signIn(email, password);
        HashMap<String, Object> returnMap = new HashMap<String, Object>();
        if (success) {
            returnMap.put("email", email);
            returnMap.put("status", "Welcome!");
        } else{
            returnMap.put("status", "Either incorrect email or password");
        }
    }

    public static Result getTripsList(int tripId, String depart, String arriv, String st1, String st2) throws SQLException {
        hitchhiker42.TripsInfo trips = hitchhiker42.getTrips(tridId, depart, arriv, st1, st2);
        HashMap<String, Object> returnMap = new HashMap<String, Object>();
        if (trips == null) {
            returnMap.put("status", "No trips match search criteria");
        } 
        else{
            ArrayList<Object> returnList = new ArrayList<Object>();
            for(int i = 0; i<trips.trip_ids.size(); i++){
                HashMap<String, String> innerMap = new HashMap<String, String>();
                innerMap.put("depart", trips.depart_locs.get(i));
                innerMap.put("arriv", trips.arrive_locs.get(i));
                innerMap.put("st", trips.depart_times.get(i));
                HashMap<String, Object> outerMap = new HashMap<String, Object>();
                outerMap.put(Integer.toString(tripId), innerMap);
                returnList.add(outerMap);
            }
            returnMap.put("trips", returnList);
            returnMap.put("status", "we got trips, bro");
        }
        return Json.toJson(returnMap);
    }




    public static Result index() throws SQLException {
        return ok(index.render(hitchhiker42.getAllDrinkerNames()));
    }

    public static Result viewDrinker(String name) throws SQLException {
        hitchhiker42.DrinkerInfo drinkerInfo = hitchhiker42.getDrinkerInfo(name);
        if (drinkerInfo == null) {
            return ok(error.render("No drinker named \"" + name + "\""));
        } else{
            return ok(drinker.render(drinkerInfo));
        }
    }

    public static Result editDrinker(String name) throws SQLException {
        hitchhiker42.DrinkerInfo drinkerInfo = hitchhiker42.getDrinkerInfo(name);
        if (drinkerInfo == null) {
            return ok(error.render("No drinker named \"" + name + "\""));
        } else{
            return ok(edit.render(drinkerInfo,
                                  hitchhiker42.getAllBeerNames(),
                                  hitchhiker42.getAllBarNames()));
        }
    }

    public static Result updateDrinker() throws SQLException {
        Map<String, String> data = Form.form().bindFromRequest().data();
        String name = data.get("name");
        String address = data.get("address");
        if (name == null || address == null) {
            return ok(error.render("Bad request"));
        }
        hitchhiker42.DrinkerInfo drinkerInfo = hitchhiker42.getDrinkerInfo(name);
        if (drinkerInfo == null) {
            return ok(error.render("No drinker named \"" + name + "\""));
        }
        ArrayList<String> beersLiked = new ArrayList<String>();
        ArrayList<String> barsFrequented = new ArrayList<String>();
        ArrayList<Integer> timesFrequented = new ArrayList<Integer>();
        for (Map.Entry<String, String> entry: data.entrySet()) {
            if (entry.getKey().startsWith("BeersLiked/")) {
                beersLiked.add(entry.getKey()
                               .substring("BeersLiked/".length()));
            } else if (entry.getKey().startsWith("BarsFrequented/")) {
                int times = Integer.parseInt(entry.getValue());
                if (times > 0) {
                    barsFrequented.add(entry.getKey()
                                       .substring("BarsFrequented/".length()));
                    timesFrequented.add(Integer.parseInt(entry.getValue()));
                }
            }
        }
        boolean success = hitchhiker42.updateDrinkerInfo
            (new hitchhiker42.DrinkerInfo(name, address,
                                    beersLiked, barsFrequented, timesFrequented));
        if (success) {
            return redirect(controllers.routes.Application
                            .viewDrinker(drinkerInfo.name));
        } else {
            return ok(error.render("No drinker named \"" + name + "\""));
        }
    }

}
