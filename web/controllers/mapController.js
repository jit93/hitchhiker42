var myApp = angular.module('myApp',[]);

myApp.controller('MapController', ['$scope', function($scope) {
  	$scope.test = 'Hola!';
  	 //Setting the default map position
 	var pos = {lat: 51.5, lng: -0.2};
 	var map;
  var isSignedIn = false;

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
          }, function() {
            handleLocationError(true, infoWindow, map.getCenter());
          });
        } else {
          // Browser doesn't support Geolocation
          handleLocationError(false, infoWindow, map.getCenter());
        }
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
}]);