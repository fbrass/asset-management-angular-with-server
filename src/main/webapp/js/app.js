'use strict';

// Declare app level module which depends on views, and components
var assetManagementApp = angular.module('assetManagementApp', [
    'ngRoute',
    'assetManagementServices',
    'assetManagementController',
    'angularFileUpload',
    'ui.bootstrap'
]);

assetManagementApp.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.
            when('/', {
                redirectTo: '/asset-type-list'
            }).
            when('/asset-type-list', {
                templateUrl: 'partials/asset-type-list.html',
                controller: 'AssetTypeListCtrl',
                activeTab: 'asset-type'
            }).
            when('/asset-type/:type_id', {
                templateUrl: 'partials/edit-asset-type.html',
                controller: 'EditAssetTypeCtrl',
                activeTab: 'asset-type'
            }).
            when('/create-asset-type', {
                templateUrl: 'partials/edit-asset-type.html',
                controller: 'EditAssetTypeCtrl',
                activeTab: 'asset-type'
            }).
            when('/asset/', {
                templateUrl: 'partials/asset-list.html',
                controller: 'AssetsCtrl',
                typeMode:'no-type',
                activeTab: 'asset'
            }).
            when('/asset/:type_id', {
                templateUrl: 'partials/asset-list.html',
                controller: 'AssetsCtrl',
                typeMode:'type',
                activeTab: 'asset'
            }).
            when('/edit-asset/:asset_id', {
                templateUrl: 'partials/edit-asset.html',
                controller: 'EditAssetCtrl',
                activeTab: 'asset'
            }).
            when('/create-asset', {
                templateUrl: 'partials/edit-asset.html',
                controller: 'EditAssetCtrl',
                editMode: 'create',
                activeTab: 'asset'
            }).
            when('/about', {
                templateUrl: 'partials/about.html',
                controller: 'AboutCtrl',
                activeTab: 'about'
            }).
            otherwise({
                redirectTo: '/asset-type-list'
            });
    }
]);




