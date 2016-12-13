package controllers;

import java.sql.SQLException;
import java.util.Map;
import java.util.ArrayList;

import play.*;
import play.mvc.*;
import play.data.*;
import play.libs.*;
import play.libs.Json;

//import org.codehaus.jackson.JsonNode;
//import org.codehaus.jackson.node.ObjectNode;

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
    public static Result updateTripInfo(String tripId, String currentLocation, String destination, String startTime, String delete) throws SQLException {
        int tripId_int = Integer.parseInt(tripId);
        boolean delete_bool = true;
        if(delete.equalsIgnoreCase("false")){
            delete_bool = false;
        }

        boolean success = hitchhiker42.updateTripInfo((new hitchhiker42.TripInfo(tripId_int, currentLocation, destination, startTime)), delete_bool);
        if (success){
            return ok("Success");
        } else {
            return ok(error.render("Error"));
        }
    }






    public static Result insertIntoUserInfo(String email, String name, String password) throws SQLException {
        //check to sanitize inputs


        boolean success = hitchhiker42.insertUserInfo(email, name, password);
        if (success) {
            return ok("success, user inserted into db");
        } else{
            return ok(error.render("error try again"));
        }
    }


    public static Result updateUserInfo(String email, String name, String password, String delete) throws SQLException {
        //check to sanitize inputs

        boolean delete_bool = true;
        if(delete.equalsIgnoreCase("false")){
            delete_bool = false;
        }
        boolean success = hitchhiker42.updateUserInfo(email, name, password, delete_bool);
        if (success) {
            return ok("success, user info updated");
        } else{
            return ok(error.render("error try again"));
        }
    }


    public static Result insertIntoPassengers(String trip_id, String email) throws SQLException {
        //check to sanitize inputs

        int trip_id_int = Integer.parseInt(trip_id);
        boolean success = hitchhiker42.insertIntoPassengers(trip_id_int, email);
        if (success) {
            return ok("trip added successfull");
        } else{
            return ok(error.render("error try again"));
        }
    }

//     //FIGURE OUT WHAT IS WRONG WITH THIS, SAYS EXPECTS A .CLASS
    public static Result updatePassengers(String trip_id, String email, String delete) throws SQLException {
        //check to sanitize inputs
        boolean delete_bool = true;
        if(delete.equalsIgnoreCase("false")){
            delete_bool = false;
        }

        int trip_id_int = Integer.parseInt(trip_id);
        boolean success = hitchhiker42.updatePassengers(trip_id_int, email, delete_bool);
        if (success) {
            return ok("success, trip updated");
        } else{
            return ok(error.render("error try again"));
        }
    }


    public static Result insertUsersWithCar(String email, String numSeats) throws SQLException {
        //check to sanitize inputs

        int numSeats_int = Integer.parseInt(numSeats);
        boolean success = hitchhiker42.insertUsersWithCar(email, numSeats_int);
        if (success) {
            return ok("success, user with car added");
        } else{
            return ok(error.render("error try again"));
        }
    }


    public static Result updateUsersWithCar(String email, String numSeats, String delete) throws SQLException {
        //check to sanitize inputs

        int numSeats_int = Integer.parseInt(numSeats);
        boolean delete_bool = true;
        if(delete.equalsIgnoreCase("false")){
            delete_bool = false;
        }
        boolean success = hitchhiker42.updateUsersWithCar(email, numSeats_int, delete_bool);
        if (success) {
            return ok("success, logging in...");
        } else{
            return ok(error.render("error try again"));
        }
    }


    public static Result insertIntoIsDrivenBy(String trip_id, String email) throws SQLException {
        //check to sanitize inputs

        int trip_id_int = Integer.parseInt(trip_id);
        boolean success = hitchhiker42.insertIntoIsDrivenBy(trip_id_int, email);
        if (success) {
            return ok("success, driver for trip added");
        } else{
            return ok(error.render("error try again"));
        }
    }


    public static Result updateIsDrivenBy(String trip_id, String email, String delete) throws SQLException {
        //check to sanitize inputs

        boolean delete_bool = true;
        if(delete.equalsIgnoreCase("false")){
            delete_bool = false;
        }

        int trip_id_int = Integer.parseInt(trip_id);
        boolean success = hitchhiker42.updateIsDrivenBy(trip_id_int, email, delete_bool);
        if (success) {
            return ok("success, driver for trip info updated");
        } else{
            return ok(error.render("error try again"));
        }
    }


    public static Result getDriver(String trip_id) throws SQLException {
        //check to sanitize inputs
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^getting driver application.java");
        //Integer intTripId = Integer.parseInt(trip_id);
        String driverEmail = hitchhiker42.getDriver(trip_id);
        if (driverEmail != "") {   //CHECK THIS IF STATEMENT
            return ok(driverEmail);
        } else{
            return ok(error.render("error try again"));
        }
    }

    public static Result getPassengers(String trip_id) throws SQLException {
        //check to sanitize inputs


        ArrayList<String> passengerEmails = hitchhiker42.getPassengers(trip_id);
        if (passengerEmails != null) {
            return ok(passengerEmails.toString());
        } else{
            return ok(error.render("error try again"));
        }
    }


    public static Result getUserInfo(String email) throws SQLException {
        //check to sanitize inputs
        ArrayList<String> userInfo = hitchhiker42.getUserInfo(email);
        if (userInfo != null) {
            return ok(userInfo.toString());
        } else{
            return ok(error.render("error try again"));
        }
    }
// //--------------------------------------------------------------------------------------------------------------------------------
    public static Result signInEntry(String email, String password) throws SQLException {
        boolean success = signIn(email, password);
        if (success) {
            return ok(email);
        } else{
            return ok(error.render("Either incorrect email or password"));
        }
    }


// //--------------------------------------------------------------------------------------------------------------------------------
public static Result getTripsList(String tripId, String depart, String arriv, String st1, String st2) throws SQLException {
         hitchhiker42.TripInfo trips = hitchhiker42.getTrips(tripId, depart, arriv, st1, st2);
         if (trips == null) {
             return ok(error.render("No trips match search criteria"));
         } else{
             return ok("hiii");
         }
     }

    public static Result test2(String stringDict) throws SQLException {
        //System.out.println("hello world");
        //JsonNode result = Json.newObject();
        //result.put("status", "OK");
        System.out.println("*********************************");
        return ok("hello world");
    }

    public static Result test() throws SQLException {
        //System.out.println("hello world");
        //JsonNode result = Json.newObject();
        //result.put("status", "OK");
        return ok("hello world");
    }


    public static Result index() throws SQLException {
        return ok(main.render(""));
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
