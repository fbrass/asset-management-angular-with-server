/**
 * Created by Felix on 19.02.2015.
 */
'use strict';

var assetManagementServices = angular.module('assetManagementServices', ['ngResource']);

assetManagementServices.factory('AssetTypeList', ['$resource',
    function ($resource) {
        return $resource('resources/assettypelist', {}, {
            query: {method: 'GET', params: {}, isArray: true}
        });
    }]);

assetManagementServices.factory('AssetList', ['$resource',
    function ($resource) {
        return $resource('resources/assetlist/:assetId/:pageSize/:page/:searchText/:typeId', {
                assetId: null, pageSize: null, page: null, searchText: null, typeId: null
            },
            {
                'getPaginated': {method: 'GET', isArray: false}
            });
    }]);

assetManagementServices.factory('Asset', ['$resource',
    function ($resource) {
        return $resource('resources/assets/:assetId', {}, {
            query: {method: 'GET', params: {assetId: ''}, isArray: true}
        });
    }]);

