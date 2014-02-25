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
            Product.addPrice({productId: $routeParams.productId}, $scope.price, function($resource) {
                $scope.product = Product.get({productId: $routeParams.productId})})
            }
    }]);

priceBookControllers.controller('ProductListCtrl', ['$scope', 'Product',
    function ($scope, Product) {
        $scope.products = Product.query();
        $scope.orderBy = 'name';
    }]);

priceBookControllers.controller('ProductAddCtrl', [ '$scope', '$upload', 'Category', 'Product',
    function($scope, $upload, Category, Product) {
        $scope.categories = Category.query();
        $scope.category = "";
        $scope.imageUrl = "/public/images/work/thumbs/item.png";
        $scope.name = "Nom du produit";
        $scope.description = "Description du produit";

        $scope.addProduct = function(){
            $scope.product = {
                "name": $scope.name,
                "description": $scope.description,
                "picture": $scope.imageUrl,
                "category" : $scope.categories[$scope.category - 1].name
            }
            Product.addProduct($scope.product, function($resource) {
                console.log("Produit ajouté!")})
        };

        $scope.onFileSelect = function($files) {
            //$files: an array of files selected, each file has name, size, and type.
            for (var i = 0; i < $files.length; i++) {
                var file = $files[i];
                $scope.upload = $upload.upload({
                    url: '/products/uploadPicture',
                    // headers: {'headerKey': 'headerValue'},
                    // withCredentials: true,
                    data: {myObj: $scope.updloadFileModel},
                    file: file
                    // file: $files, //upload multiple files, this feature only works in HTML5 FromData browsers
                    /* set file formData name for 'Content-Desposition' header. Default: 'file' */
                    //fileFormDataName: myFile, //OR for HTML5 multiple upload only a list: ['name1', 'name2', ...]
                    /* customize how data is added to formData. See #40#issuecomment-28612000 for example */
                    //formDataAppender: function(formData, key, val){} //#40#issuecomment-28612000
                }).progress(function(evt) {
                        console.log('percent: ' + parseInt(100.0 * evt.loaded / evt.total));
                    }).success(function(data, status, headers, config) {
                        // file is uploaded successfully
                        // console.log(data[0].thumbnail_url);
                        $scope.imageUrl = data[0].thumbnail_url;
                    });
                //.error(...)
                //.then(success, error, progress);
            }
        };
}]);