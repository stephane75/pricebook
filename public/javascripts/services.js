var priceBookServices = angular.module('priceBookServices', ['ngResource']);

priceBookServices.factory('Product', ['$resource',
    function ($resource) {
        return $resource('/products/:productId', {}, {
            query: {method: 'GET', isArray: true},
            get: {method: 'GET', params: {productId: 'products'}},
            addPrice:{method: 'POST', params: {productId: 'productId'}},
            addProduct:{method: 'POST'}
        });
    }]);

priceBookServices.factory('Store', ['$resource',
    function ($resource) {
        return $resource('/stores', {}, {
            query: {method: 'GET', isArray: true}
        });
    }]);

priceBookServices.factory('Category', ['$resource',
    function ($resource) {
        return $resource('/categories', {}, {
            query: {method: 'GET', isArray: true}
        });
    }]);