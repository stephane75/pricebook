'use strict';

/* App Module */

var priceBookApp = angular.module('priceBookApp', [
    'ngRoute',
    'priceBookControllers'
]);

priceBookApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/products', {
                templateUrl: '/partials/list',
                controller: 'ProductListCtrl'
            }).
            when('/products/:productId', {
                templateUrl: '/partials/detail',
                controller: 'ProductDetailCtrl'
            }).
            otherwise({
                redirectTo: '/products'
            });
    }]);

// /angular.module('pricebook', ['pricebook.service']);
//
//angular.module('pricebook.service', ['ngResource']).factory('Rest', function ($resource) {
//    return $resource('/product/:id', {}, {
//        query:  {method: 'GET', isArray: true},
//        get:    {method: 'GET'}
////        remove: {method: 'DELETE'},
////        edit:   {method: 'PUT'},
////        add:    {method: 'POST'}
//    });
//});
//
////angular.module('pricebook', ['pricebook.service']).config(function ($httpProvider) {
////    $httpProvider.defaults.transformRequest = function (data) {
////        var str = [];
////        for (var p in data) {
////            data[p] !== undefined && str.push(encodeURIComponent(p) + '=' + encodeURIComponent(data[p]));
////        }
////        return str.join('&');
////    };
////    $httpProvider.defaults.headers.put['Content-Type'] = $httpProvider.defaults.headers.post['Content-Type'] =
////        'application/x-www-form-urlencoded; charset=UTF-8';
////});
//
//angular.module('pricebook').config(['$routeProvider', function ($routeProvider) {
//    $routeProvider.when('/add', {templateUrl: 'partials/add', controller: ProductCtrl})
//        .when('/edit/:id', {templateUrl: 'partials/edit', controller: ProductCtrl})
//        .when('/', {templateUrl: 'partials/list', controller: ProductCtrl});
//}]);
//
//var ProductCtrl = function ($scope, $routeParams, $location, Rest) {
//    if ($routeParams.id) {
//        $scope.product = Rest.get({id: $routeParams.id});
//    }
//    if ($location.path() === '/') {
//        $scope.products = Rest.query();
//    }
//
////    $scope.add = function () {
////        Rest.add({}, $scope.newProduct, function (data) {
////            $location.path('/');
////        });
////    };
////
////    $scope.delete = function (id) {
////        if (!confirm('Confirm delete')) {
////            return;
////        }
////
////        Rest.remove({id: id}, {}, function (data) {
////            $location.path('/');
////        });
////    };
////
////    $scope.save = function () {
////        Rest.edit({id: $scope.product.id}, $scope.product, function (data) {
////            $location.path('/');
////        });
////    };
//};