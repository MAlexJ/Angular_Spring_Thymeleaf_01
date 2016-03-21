'use strict';

myApp.controller('myController', ['$scope', '$http',
    function ($scope, $http) {

        // GET: {id}
        $http.get('/phone/1').success(function (data) {
            $scope.phone = data;
            $scope.loaded = true;
        }).error(function (data, status) {
            console.log("код ответа: " + status);
        });

        // GET: list
        $http.get('/phone').success(function (data) {
            $scope.phones = data;
        }).error(function (data, status) {
            console.log("код ответа: " + status);
        });

        // PUT
        $scope.save = function (answer, answerForm) {
            if (answerForm.$valid) {
                $http.put('/phone', answer).success(function () {
                    {
                        $scope.answer.title = "";
                        $scope.answer.description = "";
                        $scope.answer.price = "";
                        console.log("put: success");

                        // repeat: get list
                        $http.get('/phone').success(function (data) {
                            $scope.phones = data;
                        }).error(function (data, status) {
                            console.log("код ответа: " + status);
                        });
                    }
                });
            }
        }

        //DELETE
        $scope.delete = function (selectOpt) {
            if (selectOpt > 0) {

                $http.delete('/phone/'+selectOpt).success(function () {                    
                   
                    // repeat: get list
                    $http.get('/phone').success(function (data) {
                        $scope.phones = data;
                    }).error(function (data, status) {
                        console.log("код ответа: " + status);
                    });                   
                });   
            }
            else {
                console.log('Error');
            }
        };


    }
]);
