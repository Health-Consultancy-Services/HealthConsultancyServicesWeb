var app = angular.module('HealthConsultancyServiceWeb', []);

app.controller('DoctorViewController', function($scope,$http){
$http({

method: 'GET',

url: 'http://localhost:8080/doctor'

}).then(function success(response) {

$scope.Doctor = response.data;
}, function error(response) {

});
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

app.controller('LoginController', function ($scope, $http, $log, $location) {

  $scope.email;
  $scope.password;
  $scope.role;

  $scope.login = function () {

    $http({
      url: "http://localhost:8080/login" + "/" + $scope.email + "/" + $scope.password + "/" + $scope.role,
      method: "GET"
    }).then(function (response) {
	$scope.response = response.data;
	$scope.email = response.data.email;
	$scope.password = response.data.password;
	$scope.role = response.data.role;
	    alert("Successfully login!!!");	
		location.replace("../Dashboard.html");
}, function error(response) {
      $scope.error = 'Invalid credentials!!!';
    });
  };
});

app.controller('ChangePasswordController', function ($scope, $http, $log, $location) {

  $scope.email;
  $scope.password;
  $scope.newpassword;

  $scope.changepass = function () {

    $http({
      url: "http://localhost:8080/changepassword" + "/" + $scope.email + "/" + $scope.password + "/" + $scope.newpassword,
      method: "GET"
    }).then(function (respone) {
	if(response.data= 1){location.replace("../login.html");
	 alert("Password Changed Sucessfully!!");}
	 else{$scope.error = 'Invalid email_id and password!!';;}
    }, function (response) {
	location.replace("../login.html");
	 alert("Password Changed Sucessfully!!");
});
  };
});
