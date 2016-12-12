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

    // public static Result insertIntoTrips(Integer tripId, String currentLocation, String destination, String startTime) throws SQLException {
    //     boolean success = hitchhiker42.insertIntoTrips(new hitchhiker42.TripInfo(tripId, currentLocation, destination, startTime));
    //     if (success){
    //         return ok(edit.render("Trip creation successful"));
    //     } else {
    //         return ok(error.render("Trip creation unsuccessful"));
    //     }
    // }
//--------------------------------------------------------------------------------------------------------------------------------
    public static Result updateTripInfo(Integer tripId, String currentLocation, String destination, String startTime, boolean delete) throws SQLException {
        boolean success = hitchhiker42.updateTripInfo((new hitchhiker42.TripInfo(tripId, currentLocation, destination, startTime)), delete);
        if (success){
            return ok(edit.render("Success"));
        } else {
            return ok(error.render("Error"));
        }
    }






    public static Result insertIntoUserInfo(String email, String name, String password) throws SQLException {
        //check to sanitize inputs


        boolean success = hitchhiker42.insertUserInfo(email, name, password);
        if (success) {
            return ok(edit.render("success, logging in..."));
        } else{
            return ok(error.render("error try again"));
        }
    }


    public static Result updateUserInfo(String email, String name, String password, boolean delete) throws SQLException {
        //check to sanitize inputs


        boolean success = hitchhiker42.updateUserInfo(email, name, password, delete);
        if (success) {
            return ok(edit.render("success, user info updated"));
        } else{
            return ok(error.render("error try again"));
        }
    }


    public static Result insertIntoPassengers(int trip_id, String email) throws SQLException {
        //check to sanitize inputs


        boolean success = hitchhiker42.insertIntoPassengers(trip_id, email);
        if (success) {
            return ok(edit.render("trip added successfull"));
        } else{
            return ok(error.render("error try again"));
        }
    }

    //FIGURE OUT WHAT IS WRONG WITH THIS, SAYS EXPECTS A .CLASS
    // public static Result updatePassengers(int trip_id, String email, boolean delete) throws SQLException {
    //     //check to sanitize inputs

    //     boolean success = hitchhiker42.updatePassengers(int trip_id, String email, boolean delete);
    //     if (success) {
    //         return ok(edit.render("success, trip updated"));
    //     } else{
    //         return ok(error.render("error try again"));
    //     }
    // }


    public static Result insertUsersWithCar(String email, int numSeats) throws SQLException {
        //check to sanitize inputs


        boolean success = hitchhiker42.insertUsersWithCar(email, numSeats);
        if (success) {
            return ok(edit.render("success, user with car added"));
        } else{
            return ok(error.render("error try again"));
        }
    }


    public static Result updateUsersWithCar(String email, int numSeats, boolean delete) throws SQLException {
        //check to sanitize inputs


        boolean success = hitchhiker42.updateUsersWithCar(email, numSeats, delete);
        if (success) {
            return ok(edit.render("success, logging in..."));
        } else{
            return ok(error.render("error try again"));
        }
    }


    public static Result insertIntoIsDrivenBy(int trip_id, String email) throws SQLException {
        //check to sanitize inputs


        boolean success = hitchhiker42.insertIntoIsDrivenBy(trip_id, email);
        if (success) {
            return ok(edit.render("success, driver for trip added"));
        } else{
            return ok(error.render("error try again"));
        }
    }


    public static Result updateIsDrivenBy(int trip_id, String email, boolean delete) throws SQLException {
        //check to sanitize inputs


        boolean success = hitchhiker42.updateIsDrivenBy(trip_id, email, delete);
        if (success) {
            return ok(edit.render("success, driver for trip info updated"));
        } else{
            return ok(error.render("error try again"));
        }
    }


    public static Result getDriver(int trip_id) throws SQLException {
        //check to sanitize inputs


        String driverEmail = hitchhiker42.getDriver(trip_id);
        if (driveremail != null) {
            return ok(edit.render(driverEmail));
        } else{
            return ok(error.render("error try again"));
        }
    }


    public static Result getPassengers(int trip_id) throws SQLException {
        //check to sanitize inputs


        ArrayList<String> passengerEmails = hitchhiker42.getPassengers(trip_id);
        if (passengerEmails != null) {
            return ok(edit.render(passengerEmails));
        } else{
            return ok(error.render("error try again"));
        }
    }


    public static Result getUserInfoo(String email) throws SQLException {
        //check to sanitize inputs


        ArrayList<String> userInfo = hitchhiker42.getUserInfo(email);
        if (userInfo != null) {
            return ok(edit.render(userInfo));
        } else{
            return ok(error.render("error try again"));
        }
    }
//--------------------------------------------------------------------------------------------------------------------------------
    public static Result signInEntry(String email, String password) throws SQLException {
        boolean success = signIn(email, password);
        if (success) {
            return ok(main.render(email));
        } else{
            return ok(error.render("Either incorrect email or password"));
        }
    }


//--------------------------------------------------------------------------------------------------------------------------------
    public static Result getTripsList(int tripId, String depart, String arriv, String st) throws SQLException {
        hitchhiker42.Trips trips = hitchhiker42.getTrips(tridId, depart, arriv, st);
        if (trips == null) {
            return ok(error.render("No trips match search criteria"));
        } else{
            return ok(Trips.render(trips));
        }
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
