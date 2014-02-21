var priceBookServices = angular.module('priceBookServices', ['ngResource']);

priceBookServices.factory('Product', ['$resource',
    function ($resource) {
        return $resource('/products/:productId', {}, {
            query: {method: 'GET', isArray: true},
            get: {method: 'GET', params: {productId: 'products'}},
            add:{method: 'POST', params: {productId: 'productId'}}
        });
    }]);

priceBookServices.factory('Store', ['$resource',
    function ($resource) {
        return $resource('/stores', {}, {
            query: {method: 'GET', isArray: true}
        });
    }]);