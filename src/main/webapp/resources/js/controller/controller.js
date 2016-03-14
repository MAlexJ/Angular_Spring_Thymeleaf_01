'use strict';

myApp.controller('myController', ['$scope', '$http',
    function($scope, $http) {

        $http.get('/goods').success(function(data) {
            $scope.goods = data;
            $scope.loaded=true;
        }).error(function(data, status) {
            console.log("код ответа: " +status);
        });

        $http.get('/listGoods').success(function(data) {
            $scope.listGoods = data;
        }).error(function(data, status) {
            console.log("код ответа: " +status);
        });
    }
]);
