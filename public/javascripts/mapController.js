var myApp = angular.module('myApp', ["ngQuickDate"]);

myApp.controller('Controller', ['$scope', '$http', function($scope, $http) {
  	 //Setting the default map position
 	var pos = {lat: 36.0014258, lng: -78.9382286};
  var mapCanvasGlobal;
  var zoom = 12;
 	var map;
  $scope.isSignedIn = false;
  var currentLocKnown = false;
  var listOfMarkers = [];
  var currentTrip = $scope.currentTrip;
  var userEmail;
  var currentLocation;
  var destinationLocation;

 	$scope.initMap = function() {
 		console.log("map should load");
 		//Grabbing the DOM point to add the map
    var mapCanvas = document.getElementById("map");
    mapCanvasGlobal = mapCanvas;
    //Default map options
    var mapOptions = {
    	center: pos, 
        zoom: 10
    }

    //Creating the map
    map = new google.maps.Map(mapCanvas, mapOptions);
    //Creating the popup for geolocation
    var infoWindow = new google.maps.InfoWindow({map: map});

    // Try HTML5 geolocation.
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(function(position) {
        pos = {
          lat: position.coords.latitude,
          lng: position.coords.longitude
        };

        infoWindow.setPosition(pos);
        infoWindow.setContent('Location found.');
        map.setCenter(pos);
        currentLocation = "("+position.coords.latitude+","+position.coords.longitude+")";
        currentLocKnown = true;
      }, function() {
        handleLocationError(true, infoWindow, map.getCenter());
      });
    } else {
      // Browser doesn't support Geolocation
      handleLocationError(false, infoWindow, map.getCenter());
    }

    // Only load the current location button if the user gives location permission
    console.log("should add the current location button");
    var geoloccontrol = new klokantech.GeolocationControl(map, zoom);

    // Add the autocomplete button
    initAutocomplete();
  };

  function getTrips() {

  }

  function handleLocationError(browserHasGeolocation, infoWindow, pos) {
      infoWindow.setPosition(pos);
      infoWindow.setContent(browserHasGeolocation ?
                            'Error: The Geolocation service failed.' :
                            'Error: Your browser doesn\'t support geolocation.');
  }

  function addMarker(center, titleText) {
    console.log("should add a marker")
    var marker = new google.maps.Marker({
      position: center,
      map: map,
      title: titleText
    });
    listOfMarkers.push(marker);
    marker.addListener('click', function(){
      currentTrip=marker.title;
      console.log(currentTrip);
      $scope.currentTrip = currentTrip;
      $scope.$apply();
    });
  };

  // function addMarker() {
  // 	console.log("should add a marker")
  // 	var marker = new google.maps.Marker({
  //     position: pos,
  //     map: map,
  //     title: 'Test'
  //   });
  //   listOfMarkers.push(marker);
  //   marker.addListener('click', function(){
  //     currentTrip=marker.title;
  //     console.log(currentTrip);
  //     $scope.currentTrip = currentTrip;
  //     $scope.$apply();
  //   });
  // };

  $scope.signup = function() {
    var email     = $scope.signup_email;
    var password  = $scope.signup_password;
    var hasCar    = $scope.signup_has_car;
    var username  = $scope.signup_username;
    var numSeats  = parseInt($scope.signup_number_of_seats);
    if (hasCar == undefined) {
      hasCar = false;
    }
    if (email !== undefined && password !== undefined &&
     numSeats !== undefined && numSeats >= 0) {
      $scope.signup_password="";
      $http({
        method: 'POST', 
        url : "/insertUser?email="+email+"&name="+username+"&password="+password
      }).then(function mySuccess(response) {
        alert("sign up successful");
        userEmail = email;
        $scope.isSignedIn = true;
	      if(hasCar){
		      $http({
		        method: 'POST', 
		        url : "/insertCarUsers?email="+email+"&numSeats="+numSeats
		      }).then(function mySuccess(response) {
		        alert("sign up successful");
		      }, function myError(response) {
		        alert("sign up failed from the server");
		      });

	      }
      }, function myError(response) {
        alert("sign up failed from the server");
      });

    } else {
      alert("Please fill all required fields");
    }
  }

  $scope.signin = function() {
    var email     = $scope.signin_email;
    var password  = $scope.signin_password;
    if (email !== undefined && password !== undefined) {
      $scope.signin_password="";
      $http({
        method: 'GET', 
        url : "/signIn?email="+email+"&password="+password
      }).then(function mySuccess(response) {
        if(response['data'] == "null"){
          alert("incorrect username or password");
        }
        else{
          alert("sign in successful");
          userEmail = email;
          $scope.isSignedIn = true;
        }
        
      }, function myError(response) {
        alert("sign in failed from the server");
      });
    } else {
      alert("Please fill all required fields");
    }
    $scope.getUserInfo();
  }

  $scope.edit = function() {
    var email     = $scope.edit_email;
    var password  = $scope.edit_password;
    var hasCar    = $scope.edit_has_car;
    var username  = $scope.edit_username;
    var numSeats  = parseInt($scope.edit_number_of_seats);
    if (hasCar == undefined) {
      hasCar = false;
    }
    if (email !== undefined && password !== undefined &&
     numSeats !== undefined && numSeats >= 0) {
	 if(hasCar) { //PUT request to UsersWithCar
	 	var seats = numSeats.toString();
	 	$http({
			method: 'PUT',
			url: "/updateCarUsers?email="+email+"&numSeats="+seats+"&delete=false"
		}).then(function mySuccess(response) {
		  alert("edit with car successful");
		}, function myError(response) {
			alert("edit with car failed");
		});
	 }
	 else { //PUT request to Users
      $http({
        method: 'PUT', 
        url : "/updateUser?email="+email+"&name="+username+"&password="+password+"&delete=false"
      }).then(function mySuccess(response) {
        alert("edit user successful");
      }, function myError(response) {
        alert("edit user failed");
      });
   }
   } else {
      alert("Please fill all required fields");
    }
  }

  $scope.addToTrip = function() {
    var trip    = currentTrip;
    if (trip !== undefined) {
      $http({
        method: 'POST', 
        url : "/insert-Passenger?trip_id="+trip+"&email="+userEmail
      }).then(function mySuccess(response) {
        alert("edit successful");
      }, function myError(response) {
        alert("edit failed");
      });
    } else {
      alert("Please fill all required fields");
    }
  }

  $scope.makeTrip = function() {
    var trip_id_counter_temp = parseInt(Date.now()).toString();
    var trip_id_counter     = trip_id_counter_temp.substring(trip_id_counter_temp.length - 5, trip_id_counter_temp.length-1);
    var start       = currentLocation;
    var destination = destinationLocation;
    var startTimeTemp   = JSON.stringify($scope.newTripDate1);
    var startTime      = startTimeTemp.substring(1, startTimeTemp.length-1);
    if (start !== undefined && destination !== undefined && startTime !== undefined) {
      $http({
        method: 'POST', 
        url : "/insertTrip?tripId="+trip_id_counter+"&currentLocation="+start+"&destination="+destination+"&startTime="+startTime
      }).then(function mySuccess(response) {
        alert("edit successful");
        $http({
          method: 'POST', 
          url : "/insertDriven?trip_id="+trip_id_counter+"&email="+userEmail
        }).then(function mySuccess(response) {
          alert("edit successful");
          trip_id_counter++;
        }, function myError(response) {
          alert("edit failed");
        });
      }, function myError(response) {
        alert("edit failed");
      });
    } else {
      alert("Please fill all required fields");
    }
  }

  $scope.searchTrips = function() {
    var firstDayTemp  = JSON.stringify($scope.date1);
    var firstDay      = firstDayTemp.substring(1, firstDayTemp.length-1);
    var secondDayTemp  = JSON.stringify($scope.date2);
    var secondDay      = secondDayTemp.substring(1, secondDayTemp.length-1);
    if (firstDay === null || secondDay === null || firstDay === undefined || secondDay === undefined ||
      (firstDay >= secondDay)) {
        alert("Please fill all required fields");
    } else {
        var json      = {"first-time":firstDay, "second-time":secondDay};
        var parameter = JSON.stringify(json);
        $http({
            method: 'GET', 
            url : "/trip-search-time?st1="+firstDay+"&st2="+secondDay
          }).then(function mySuccess(response) {
            alert("success");
            alert(response);
          }, function myError(response) {
            alert("failure");
            alert(response);
          });
    }
  }

  $scope.searchTripByID = function() {
      var tripID = $scope.search_trip_by_id;
      if (tripID == undefined) {
        alert("Please fill all required fields");
      } else {
      	var tripIDS = tripID.toString();
        $http({
            method: 'GET', 

            url : "/trip-search-id?tripId="+tripIDS
          }).then(function mySuccess(response) {
            alert("success");
            //so either way input in "pac-input" and then simulate a click on it
            alert(response);

            document.getElementById('pac-input').value = response['data'].split("|")[2];
            var pos_temp = response['data'].split("|")[2];
            //pos_temp = pos_temp.substring(1, pos_temp.length-2);
            var lat_long = pos_temp.split(',');
            var my_lat = parseInt(lat_long[0]);
            var my_long = parseInt(lat_long[1]);
            var pos = {lat: my_lat, lng: my_long};
            map.setCenter(pos);
            addMarker(pos, tripID);
          }, function myError(response) {
            alert("failure");
            //so either way input in "pac-input" and then simulate a click on it
            alert(response);
            document.getElementById('pac-input').value = response['data'].split("|")[2];
            //now simulate click or enter press
            console.log(response['data'][2]);
          });
      }
  }


  $scope.getUserInfo = function() {
    //console.log("getting user info");
    var url1 = "/getUsers?email=" + $scope.signin_email;
    //var url1 = "/getUsers?email=user13@gmail.com";
    if($scope.signin_email != null){
      $http({
            method: 'GET', 
            url : url1
          }).then(function mySuccess(response) {
            console.log("success");
            //console.log(response);
            $scope.userInfo = "e-mail: " + response['data'].split(",")[0] + ", username: " + response['data'].split(",")[1];
          }, function myError(response) {
            console.log("failure");
            //console.log(response);
            $scope.userInfo = response["data"];
          });
      $http({
            method: 'GET', 
            url : "/get-Drivers?email=" + $scope.signin_email
          }).then(function mySuccess(response) {
            console.log("success");
            //console.log(response);
            if(response['data'].split(",")[0] == "."){
              $scope.useInfo += " number of seats in car: N/A";
            }
            else{
              $scope.userInfo += " number of seats in car: " + response['data'].split(",")[1];
            }
            
          }, function myError(response) {
            console.log("failure");
            //console.log(response);
            $scope.userInfo = response["data"];
          });
    }
    else{
      $scope.userInfo = "please sign in first";
    }
    
  }

  // This example adds a search box to a map, using the Google Place Autocomplete
  // feature. People can enter geographical searches. The search box will return a
  // pick list containing a mix of places and predicted search terms.

  // This example requires the Places library. Include the libraries=places
  // parameter when you first load the API. For example:
  // <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=places">

  function initAutocomplete() {
    console.log("autocomplete should start loading");

    // Create the search box and link it to the UI element.
    var input = document.getElementById('pac-input');
    var searchBox = new google.maps.places.SearchBox(input);
    map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

    // Bias the SearchBox results towards current map's viewport.
    map.addListener('bounds_changed', function() {
      searchBox.setBounds(map.getBounds());
    });

    var markers = [];
    // Listen for the event fired when the user selects a prediction and retrieve
    // more details for that place.
    searchBox.addListener('places_changed', function() {
      var places = searchBox.getPlaces();

      if (places.length == 0) {
        return;
      }

      // Clear out the old markers.
      markers.forEach(function(marker) {
        marker.setMap(null);
      });
      markers = [];

      // For each place, get the icon, name and location.
      var bounds = new google.maps.LatLngBounds();
      places.forEach(function(place) {
        if (!place.geometry) {
          console.log("Returned place contains no geometry");
          return;
        }
        var icon = {
          url: place.icon,
          size: new google.maps.Size(71, 71),
          origin: new google.maps.Point(0, 0),
          anchor: new google.maps.Point(17, 34),
          scaledSize: new google.maps.Size(25, 25)
        };
        $scope.destination = place.formatted_address;
        destinationLocation = place.geometry.location;
        // Create a marker for each place.
        markers.push(new google.maps.Marker({
          map: map,
          icon: icon,
          title: place.name,
          position: place.geometry.location
        }));

        if (place.geometry.viewport) {
          // Only geocodes have viewport.
          bounds.union(place.geometry.viewport);
        } else {
          bounds.extend(place.geometry.location);
        }
      });
      map.fitBounds(bounds);
      $scope.$apply();
    });
  }
}]);
