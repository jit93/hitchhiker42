var myApp = angular.module('myApp', ["ngQuickDate"]);

myApp.controller('Controller', ['$scope', '$http', function($scope, $http) {
  	$scope.test = 'Hola!';
  	 //Setting the default map position
 	var pos = {lat: 36.0014258, lng: -78.9382286};
  var zoom = 12;
 	var map;
  var isSignedIn = false;
  var currentLocKnown = false;
  var base = "localhost:9000";

 	$scope.initMap = function() {
 		console.log("map should load");
 		//Grabbing the DOM point to add the map
    var mapCanvas = document.getElementById("map");
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

  function handleLocationError(browserHasGeolocation, infoWindow, pos) {
      infoWindow.setPosition(pos);
      infoWindow.setContent(browserHasGeolocation ?
                            'Error: The Geolocation service failed.' :
                            'Error: Your browser doesn\'t support geolocation.');
  }

  $scope.addMarker = function() {
  	console.log("should add a marker")
  	var marker = new google.maps.Marker({
      position: pos,
      map: map,
      title: 'Test'
      });
  }

  $scope.searchTrips = function() {
    console.log("should be searching trips");
    var firstDay  = $scope.date1;
    var secondDay = $scope.date2;
    if (firstDay === null || secondDay === null || firstDay === undefined || secondDay === undefined ||
      (firstDay >= secondDay)) {
        console.log("shouldn't search  trips, invalid ")
    } else {
        console.log("should have rest post to server");
        var url       = "/trip-search";
        var test      = {"test":"hi"};
        var json      = {"first-time":firstDay, "second-time":secondDay};
        var parameter = JSON.stringify(json);
      $http.post(base+url, parameter).success(function(data, status, headers, config) {
        // this callback will be called asynchronously
        // when the response is available
        console.log("success");
        console.log(data);
      }).error(function(data, status, headers, config) {
        // called asynchronously if an error occurs
        // or server returns response with an error status.
        console.log("failure");
      });
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
    });
  }
}]);