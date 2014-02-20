'use strict';

/* Controllers */

var priceBookControllers = angular.module('priceBookControllers', []);

priceBookControllers.controller('ProductListCtrl', ['$scope', '$http',
    function($scope, $http) {
        $http.get('/products').success(function(data) {
            $scope.products = data;
            $scope.orderBy = 'name';
        });
    }]);

priceBookControllers.controller('ProductDetailCtrl', ['$scope', '$routeParams', '$http',
    function($scope, $routeParams, $http) {
        $http.get('/products/' + $routeParams.productId).success(function(data) {
            $scope.product = data;
        });
        $http.post('/products/add')
    }]);