'use strict';

/* Controllers */

var priceBookControllers = angular.module('priceBookControllers', []);

priceBookControllers.controller('ProductDetailCtrl', ['$scope', '$routeParams', 'Product', 'Store',
    function ($scope, $routeParams, Product, Store) {
        $scope.price = {
            "productId": $routeParams.productId,
            "store": "",
            "user": "",
            "email": "",
            "value": ""
        }

        $scope.product = Product.get({productId: $routeParams.productId});
        $scope.stores = Store.query();

        $scope.addPrice = function(){
            Product.add({productId: $routeParams.productId}, $scope.price, function($resource) {
                $scope.product = Product.get({productId: $routeParams.productId})})
            }
    }]);

priceBookControllers.controller('ProductListCtrl', ['$scope', 'Product',
    function ($scope, Product) {
        $scope.products = Product.query();
        $scope.orderBy = 'name';
    }]);