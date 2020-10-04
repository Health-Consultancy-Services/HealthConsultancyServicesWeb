var app = angular.module('HealthConsultancyServiceWeb', []);

app.controller('DoctorViewController', function($scope,$http){
$http({

method: 'GET',

url: 'http://localhost:8080/doctor'

}).then(function success(response) {

$scope.Doctor = response.data;
}, function error(response) {

});
$scope.deleteDoctor = function(doctor) {

    //$http DELETE function
    $http({
      url: 'http://localhost:8080/deletedoctor/' + doctor.doctor_id,
      method: 'DELETE',

    }).then(function successCallback(response) {

      alert("Doctor has deleted Successfully");
      var index = $scope.Doctor.indexOf(doctor);
      $scope.Doctor.splice(index, 1);

    }, function errorCallback(response) {

      alert("Error. while deleting user Try Again!");

    });

  };

});

app.controller('PatientViewController', function($scope,$http){
$http({

method: 'GET',

url: 'http://localhost:8080/patient'

}).then(function success(response) {

$scope.Patient = response.data;
}, function error(response) {

});

});

app.controller('CountController', function($scope,$http){
$http({

method: 'GET',

url: 'http://localhost:8080/CountDoctor'

}).then(function success(response) {
$scope.data = response.data;
}, function error(response) {

});

});

app.controller('LoginController', function ($scope, $http, $log, $location) {

  $scope.email;
  $scope.password;
  $scope.role;

  $scope.login = function () {

    $http({
      url: "http://localhost:8080/login" + "/" + $scope.email + "/" + $scope.password + "/admin" ,
      method: "GET"
    }).then(function (response) {
	if(response.data.email){
	    alert("Successfully login!!!");	
		location.replace("../Dashboard.html");}
		else{
			$scope.error = 'Invalid credentials!!!';
		}
}, function error(response) {
      $scope.error = 'Invalid credentials!!!';
    });
  };
});

app.controller('ChangePasswordController', function ($scope, $http, $log, $location) {
  $scope.changepass = function () {
    $http({
      url: "http://localhost:8080/changepassword" + "/" + $scope.email + "/" + $scope.password + "/" + $scope.newpassword,
      method: "GET"
    }).then(function (respone) {
	if(respone.data==1){
	location.replace("../login.html");
	 alert("Password Changed Sucessfully!!");}
else if(respone.data==0){
	$scope.error = 'Invalid email_id and password!!';
   } 
}, function (response) {
	location.replace("../login.html");
	 alert("Password Changed Sucessfully!!");
});
  };
});



app.controller('AcceptDoctorViewController', function($scope,$http, $location){
$http({

method: 'GET',

url: 'http://localhost:8080/doctorbystatus'

}).then(function success(response) {

$scope.Doctor = response.data;
}, function error(response) {

});
$scope.acceptDoctor = function(doctor) {

    //$http DELETE function
    $http({
      url: 'http://localhost:8080/acceptdoctor/' + doctor.doctor_id,
      method: 'GET',

    }).then(function successCallback(response) {

      alert("Doctor Added Successfully");
      location.replace("../AcceptDoctor.html");

    }, function errorCallback(response) {

      alert("Error. while deleting user Try Again!");

    });

  };

});
