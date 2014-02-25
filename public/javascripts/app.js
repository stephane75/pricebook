'use strict';

/* App Module */

var priceBookApp = angular.module('priceBookApp', [
    'ngRoute',
    'angularFileUpload',
    'priceBookControllers',
    'priceBookServices'
]);

priceBookApp.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.
            when('/products', {
                templateUrl: '/partials/list',
                controller: 'ProductListCtrl'
            }).
            when('/products/add', {
                templateUrl: '/partials/add',
                controller: 'ProductAddCtrl'
            }).
            when('/products/:productId', {
                templateUrl: '/partials/detail',
                controller: 'ProductDetailCtrl'
            }).
            otherwise({
                redirectTo: '/products'
            });
    }]);