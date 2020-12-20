var app = angular.module('HealthConsultancyServiceWeb', []);

app.controller('DoctorViewController', function($scope,$http,$location){
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
		location.replace("../Dashboard.html");
   sessionStorage.setItem("email" ,JSON.stringify(response.data.email));}
		else{
			$scope.error = 'Invalid credentials!!!';
		}
}, function error(response) {
      $scope.error = 'Invalid credentials!!!';
    });
  };
});



app.controller('ChangePasswordController', function ($scope, $http, $log, $location) {
string=sessionStorage.getItem("email");
		var obj =JSON.parse(string);
		$scope.email = obj;
  $scope.changepass = function () {
    $http({
      url: "http://localhost:8080/changepassword" + "/" + $scope.email + "/" + $scope.password + "/" + $scope.newpassword,
      method: "GET"
    }).then(function (respone) {
	if(respone.data==1){
		sessionStorage.clear();
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


app.controller('DentistViewController', function($scope,$http){
$http({

method: 'GET',

url: 'http://localhost:8080/doctorbydepartment/Dentist'

}).then(function success(response) {
$scope.Doctor = response.data;
}, function error(response) {

});

});

app.controller('ENTViewController', function($scope,$http){
$http({

method: 'GET',

url: 'http://localhost:8080/doctorbydepartment/ENTspecialist'

}).then(function success(response) {
$scope.Doctor = response.data;
}, function error(response) {

});

});

app.controller('GastrologistViewController', function($scope,$http){
$http({

method: 'GET',

url: 'http://localhost:8080/doctorbydepartment/Gastrologist'

}).then(function success(response) {
$scope.Doctor = response.data;
}, function error(response) {

});

});

app.controller('GynecologistViewController', function($scope,$http){
$http({

method: 'GET',

url: 'http://localhost:8080/doctorbydepartment/Gynecologist'

}).then(function success(response) {
$scope.Doctor = response.data;
}, function error(response) {

});

});

app.controller('CardiologistViewController', function($scope,$http){
$http({

method: 'GET',

url: 'http://localhost:8080/doctorbydepartment/Cardiologist'

}).then(function success(response) {
$scope.Doctor = response.data;
}, function error(response) {

});

});

app.controller('CardiologistViewController', function($scope,$http){
$http({

method: 'GET',

url: 'http://localhost:8080/doctorbydepartment/Cardiologist'

}).then(function success(response) {
$scope.Doctor = response.data;
}, function error(response) {

});

});

app.controller('EyespecialistViewController', function($scope,$http){
$http({

method: 'GET',

url: 'http://localhost:8080/doctorbydepartment/Eyespecialist'

}).then(function success(response) {
$scope.Doctor = response.data;

}, function error(response) {

});

});

app.controller('Logout', function ($scope) {
  $scope.logout = function () {
   sessionStorage.clear();
location.replace("../login.html");
  };
});

app.controller('AddContactController', function ($scope, $http, $log, $location) {
  $scope.addContact = function () {
const data={
    "name": $scope.name,
    "email": $scope.email,
    "phoneno": $scope.phoneno,
    "message": $scope.message
}
    $http({
      url: "http://localhost:8080/contact",data ,
      method: "POST"
    }).then(function (response) {   
	alert("Successfully send message!!!");
	location.replace("../index.html");	
}, function error(response) {
      $scope.error = 'Invalid credentials!!!';
    });
  };
});

app.controller('ContactViewController', function($scope,$http){
$http({

method: 'GET',

url: 'http://localhost:8080/contact'

}).then(function success(response) {

$scope.Contact = response.data;
}, function error(response) {

});
$scope.editContact = function(contact) {

    $http({
      url: 'http://localhost:8080/contact/' + contact.name,
      method: 'GET',

    }).then(function successCallback(response) {
var index = $scope.Contact.indexOf(contact);
sessionStorage.setItem("Contact" ,JSON.stringify(response.data));
location.replace("../read-message.html");
    }, function errorCallback(response) {

    });
  };
});