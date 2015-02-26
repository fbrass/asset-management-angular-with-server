'use strict';
var assetManagementController = angular.module('assetManagementController', []);


assetManagementController.controller('NavCtrl', ['$scope', '$route', function ($scope, $route) {
    $scope.$route = $route;
}]);

assetManagementController.controller('AssetTypeListCtrl', ['$scope', 'AssetTypeList', function ($scope, AssetTypeList) {
    $scope.assetTypeActive = AssetTypeList.query();
}]);

assetManagementController.controller('EditAssetTypeCtrl', ['$scope', function ($scope) {
    //not implemented yet
}]);

assetManagementController.controller('AssetsCtrl', ['$scope', '$route', '$routeParams', 'AssetList',
    function ($scope, $route, $routeParams, AssetList) {

        $scope.paginationInfo = {
            searchText: undefined,
            pageSize: 25,
            page: 1,
            hasNext: true,
            hasPrev: false,
            count: 0
        };

        var typeMode = $route.current.typeMode !== 'type';

        $scope.titleText = typeMode ? 'Assets' : 'All Assets From Type '+$routeParams.type_id;

        $scope.getPaginated = function () {
            var search;

            if ($scope.paginationInfo.searchText && $scope.paginationInfo.searchText.length > 1) {
                search = $scope.paginationInfo.searchText;
            } else {
                search = undefined;
            }

            var args;
            if (search) {
                args = {
                    pageSize: $scope.paginationInfo.pageSize,
                    page: $scope.paginationInfo.page,
                    searchText: search
                };
            }
            if ($routeParams.type_id) {
                args = {
                    pageSize: $scope.paginationInfo.pageSize,
                    page: $scope.paginationInfo.page,
                    typeId: $routeParams.type_id
                };
            } else {
                args = {
                    pageSize: $scope.paginationInfo.pageSize,
                    page: $scope.paginationInfo.page
                };
            }


            AssetList.getPaginated(args, function (data) {
                $scope.assets = data.assets;
                $scope.paginationInfo.count = data.total;
                $scope.paginationInfo.hasPrev = $scope.paginationInfo.page > 1;
                $scope.paginationInfo.hasNext = data.assets.length >= $scope.paginationInfo.pageSize;

            });

        };

        $scope.paginatePrev = function () {
            if ($scope.paginationInfo.hasPrev) {
                $scope.paginationInfo.page -= 1;
                $scope.getPaginated();
            }
        };

        $scope.paginateNext = function () {
            if ($scope.paginationInfo.hasNext) {
                $scope.paginationInfo.page += 1;
                $scope.getPaginated();
            }
        };

        $scope.search = function () {
            var timer;
            if (timer) {
                clearTimeout(timer);
            }

            timer = setTimeout(function () {
                $scope.getPaginated();
            }, 300);
        };

        $scope.$watch('paginationInfo.searchText', function () {
            $scope.paginationInfo.page = 1;
        });

        $scope.isSearchEnabled = function () {
            return $scope.paginationInfo.searchText && $scope.paginationInfo.searchText.length > 1;
        };

        //initial load of data
        $scope.getPaginated();

    }]);


assetManagementController.controller('EditAssetCtrl', ['$scope', '$route', '$routeParams', '$location', '$upload','Asset',
    function ($scope, $route, $routeParams, $location, $upload, Asset) {
        var editMode = $route.current.editMode !== 'create';

        $scope.isEditMode = editMode;

        $scope.titleText = editMode ? 'Edit Asset' : 'New Asset';
        $scope.subTitleText = editMode ? '' : '';
        $scope.legendText = $scope.titleText;
        $scope.saveAssetText = editMode ? 'Save' : 'Create';
        $scope.cancelText = 'Cancel';

        function dateToYMD(date) {
            var d = date.getDate();
            var m = date.getMonth() + 1;
            var y = date.getFullYear();
            return '' + y + '-' + (m <= 9 ? '0' + m : m) + '-' + (d <= 9 ? '0' + d : d);
        }


        var defaultForm = {
            name: '',
            comment: '',
            construction_date: dateToYMD(new Date()),
            opening_value: 0,
            currency: ''
        };

        if (editMode) {
            $scope.asset = Asset.get({assetId: $routeParams.asset_id}, function(asset){
                $scope.asset = asset;
            });


        } else {
            $scope.asset = angular.copy(defaultForm);
        }

        $scope.saveAsset = function (anAsset) {
            anAsset.imageUrl = undefined; //Not known on the server!


            //service zum erstellen eines Assets hier benutzten!!!!

            //unterscheidung zwischen edit und save nicht vergessen

            //location ändern zum der asset list oder was gewünscht ist!!

            $location.path('/asset');
            $location.replace();

        };

        $scope.cancelEdit = function () {
            $location.path(/assets/ + $routeParams.asset_id);
        };

        $scope.removeImage = function () {
            $scope.imageUrl = undefined;
            $scope.asset.logoId = undefined;
        };

        $scope.onFileSelect = function ($files) {

            //console.log($files);

            $scope.imageUrl = 'images/spqr.png';


            /*
             // $files: an array of files selected, each file has name, size, and type.
             for (var i = 0; i < $files.length; i++) {
             var file = $files[i];
             /*$scope.upload = $upload.upload({
             url: 'file',
             method: 'POST',
             file: file
             }).progress(function (evt) {
             console.log('percent: ' + parseInt(100.0 * evt.loaded / evt.total));
             }).success(function (data /*, status, headers, config) { // file is uploaded successfully

             console.log("bis hier hin");
             console.log(data);
             console.log("bis hier hin2");
             $scope.uploads = data;


             if (data != null && data.length > 0) {
             var i = data[0];
             console.log("bis hier hin3");
             $scope.asset.logo_id = i.logo_id;
             $scope.imageUrl = i.imageUrl;
             }
             });

             }*/
        }


    }

]);

assetManagementController.controller('AboutCtrl', ['$scope', function ($scope) {


}]);