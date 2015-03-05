/**
 * Created by Felix Brass on 22.02.2015.
 *
 * BEFORE RUNNING INSTALL NODE MODULES!!!
 *  1. install node
 *  2. run "npm install express -g"
 *
 */
var express = require('express');
var app = express();
var path = require('path');

var html_dir = path.resolve('src/main/webapp/');
console.log(html_dir);

var mockedAssetTypes = [
    {
        "type_id": 4,
        "assetTypeName": "CI Tools",
        "description": "",
        "make": "",
        "function": "Development"
    }, {
        "type_id": 6,
        "assetTypeName": "Database Tools",
        "description": "",
        "make": "",
        "function": "DB Management"
    }, {
        "type_id": 1,
        "assetTypeName": "Default Asset Types",
        "description": "",
        "make": "",
        "function": ""
    }, {
        "type_id": 2,
        "assetTypeName": "Monitoring Tools",
        "description": "",
        "make": "",
        "function": "Monitoring"
    }, {
        "type_id": 3,
        "assetTypeName": "Test Tools",
        "description": "",
        "make": "",
        "function": "Testing"
    }, {
        "type_id": 5,
        "assetTypeName": "Visualisation Tools",
        "description": "",
        "make": "",
        "function": "Visualisation"
    }
];

var mockedAssets = [
    {
        "asset_id": 21,
        "location_id": 1,
        "type_id": 1,
        "logo_id": undefined,
        "name": "ABC Helenium Browser Automation",
        "version": "",
        "comment": "RN01853",
        "construction_date": "01-01-2013",
        "opening_value": 0,
        "currency": "euro"
    }, {
        "asset_id": 11,
        "location_id": 1,
        "type_id": 6,
        "logo_id": undefined,
        "name": "Air FlyAwayDBMigration",
        "version": "",
        "comment": "RN01110",
        "construction_date": "01-01-2013",
        "opening_value": 0,
        "currency": "euro"
    }, {
        "asset_id": 4,
        "location_id": 1,
        "type_id": 4,
        "logo_id": undefined,
        "name": "Artifactory Repository",
        "version": "12.2",
        "comment": "RN01017",
        "construction_date": "01-01-2013",
        "opening_value": 0,
        "currency": "euro"
    }, {
        "asset_id": 26,
        "location_id": 1,
        "type_id": 1,
        "logo_id": undefined,
        "name": "BuySoft EMailArchiver",
        "version": "",
        "comment": "RN01978",
        "construction_date": "01-01-2013",
        "opening_value": 0,
        "currency": "euro"
    }, {
        "asset_id": 5,
        "location_id": 1,
        "type_id": 1,
        "logo_id": undefined,
        "name": "CARGO Wrapper",
        "version": "",
        "comment": "RN01021",
        "construction_date": "01-01-2013",
        "opening_value": 0,
        "currency": "euro"
    }, {
        "asset_id": 6,
        "location_id": 1,
        "type_id": 4,
        "logo_id": undefined,
        "name": "Chef Deployer",
        "version": "",
        "comment": "RN01034",
        "construction_date": "01-01-2013",
        "opening_value": 0,
        "currency": "euro"
    }, {
        "asset_id": 7,
        "location_id": 1,
        "type_id": 3,
        "logo_id": undefined,
        "name": "Cobertus Test Coverage",
        "version": "",
        "comment": "RN01061",
        "construction_date": "01-01-2013",
        "opening_value": 0,
        "currency": "euro"
    }, {
        "asset_id": 8,
        "location_id": 1,
        "type_id": 5,
        "logo_id": undefined,
        "name": "CodeVillage Visualizer",
        "version": "",
        "comment": "RN01072",
        "construction_date": "01-01-2013",
        "opening_value": 0,
        "currency": "euro"
    }, {
        "asset_id": 9,
        "location_id": 1,
        "type_id": 4,
        "logo_id": undefined,
        "name": "Cucum DriverDevelopmentTool",
        "version": "",
        "comment": "RN01083",
        "construction_date": "01-01-2013",
        "opening_value": 0,
        "currency": "euro"
    }, {
        "asset_id": 10,
        "location_id": 1,
        "type_id": 1,
        "logo_id": undefined,
        "name": "Fabric Docker",
        "version": "",
        "comment": "RN01097",
        "construction_date": "01-01-2013",
        "opening_value": 0,
        "currency": "euro"
    }, {
        "asset_id": 17,
        "location_id": 1,
        "type_id": 1,
        "logo_id": undefined,
        "name": "FrogGem FocusDancer",
        "version": "",
        "comment": "RN01671",
        "construction_date": "01-01-2013",
        "opening_value": 0,
        "currency": "euro"
    }, {
        "asset_id": 12,
        "location_id": 1,
        "type_id": 1,
        "logo_id": undefined,
        "name": "GoGo Flashbox",
        "version": "",
        "comment": "RN01145",
        "construction_date": "01-01-2013",
        "opening_value": 0,
        "currency": "euro"
    }, {
        "asset_id": 16,
        "location_id": 1,
        "type_id": 5,
        "logo_id": undefined,
        "name": "GoodHere StructureGraph",
        "version": "",
        "comment": "RN01566",
        "construction_date": "01-01-2013",
        "opening_value": 0,
        "currency": "euro"
    }, {
        "asset_id": 22,
        "location_id": 1,
        "type_id": 1,
        "logo_id": undefined,
        "name": "HelpMe PuppetPlayer",
        "version": "",
        "comment": "RN01867",
        "construction_date": "01-01-2013",
        "opening_value": 0,
        "currency": "euro"
    }, {
        "asset_id": 28,
        "location_id": 1,
        "type_id": 1,
        "logo_id": undefined,
        "name": "HelloSoft Phone Tracer",
        "version": "",
        "comment": "RN02056",
        "construction_date": "01-01-2013",
        "opening_value": 0,
        "currency": "euro"
    }, {
        "asset_id": 19,
        "location_id": 1,
        "type_id": 3,
        "logo_id": undefined,
        "name": "IQ Soft Unified NonFunctional Testing",
        "version": "",
        "comment": "RN01831",
        "construction_date": "01-01-2013",
        "opening_value": 0,
        "currency": "euro"
    }, {
        "asset_id": 25,
        "location_id": 1,
        "type_id": 1,
        "logo_id": undefined,
        "name": "IQM Information Manager",
        "version": "",
        "comment": "RN01942",
        "construction_date": "01-01-2013",
        "opening_value": 0,
        "currency": "euro"
    }, {
        "asset_id": 15,
        "location_id": 1,
        "type_id": 1,
        "logo_id": undefined,
        "name": "KarmaSoft Fixedbase Plugin",
        "version": "",
        "comment": "RN01451",
        "construction_date": "01-01-2013",
        "opening_value": 0,
        "currency": "euro"
    }, {
        "asset_id": 27,
        "location_id": 1,
        "type_id": 1,
        "logo_id": undefined,
        "name": "Microframe License Management",
        "version": "",
        "comment": "RN02024",
        "construction_date": "01-01-2013",
        "opening_value": 0,
        "currency": "euro"
    }, {
        "asset_id": 29,
        "location_id": 1,
        "type_id": 4,
        "logo_id": undefined,
        "name": "Microframe MisteriousDeployer",
        "version": "",
        "comment": "RN02456",
        "construction_date": "01-01-2013",
        "opening_value": 0,
        "currency": "euro"
    }, {
        "asset_id": 18,
        "location_id": 1,
        "type_id": 4,
        "logo_id": undefined,
        "name": "PinkNet Pink4j GUI Builder",
        "version": "",
        "comment": "RN01728",
        "construction_date": "01-01-2013",
        "opening_value": 0,
        "currency": "euro"
    }, {
        "asset_id": 24,
        "location_id": 1,
        "type_id": 5,
        "logo_id": undefined,
        "name": "RunSoft JMiles Performance Analyzer",
        "version": "",
        "comment": "RN01921",
        "construction_date": "01-01-2013",
        "opening_value": 0,
        "currency": "euro"
    }, {
        "asset_id": 1,
        "location_id": 1,
        "type_id": 2,
        "logo_id": undefined,
        "name": "Senator Monitoring Assistant",
        "version": "14.01",
        "comment": "RN01010",
        "construction_date": "01-01-2013",
        "opening_value": 0,
        "currency": "Euro"
    }, {
        "asset_id": 2,
        "location_id": 1,
        "type_id": 6,
        "logo_id": undefined,
        "name": "SensiHo Database Accelerator",
        "version": "2.3",
        "comment": "RN01011",
        "construction_date": "01-01-2013",
        "opening_value": 0,
        "currency": "euro"
    },{
        "asset_id": 13,
        "location_id": 1,
        "type_id": 1,
        "logo_id": undefined,
        "name": "SmartFish Handsome Cl",
        "version": "",
        "comment": "RN01234",
        "construction_date": "01-01-2013",
        "opening_value": 0,
        "currency": "euro"
    }, {
        "asset_id": 14,
        "location_id": 1,
        "type_id": 1,
        "logo_id": undefined,
        "name": "Smartsoft CiPipe",
        "version": "",
        "comment": "RN01333",
        "construction_date": "01-01-2013",
        "opening_value": 0,
        "currency": "euro"
    },  {
        "asset_id": 20,
        "location_id": 1,
        "type_id": 1,
        "logo_id": undefined,
        "name": "Sonosar SonarLinkTogglTool",
        "version": "",
        "comment": "RN01842",
        "construction_date": "01-01-2013",
        "opening_value": 0,
        "currency": "euro"
    }, {
        "asset_id": 3,
        "location_id": 1,
        "type_id": 1,
        "logo_id": undefined,
        "name": "SPQR Asset Management Tool",
        "version": "7.2",
        "comment": "RN01014",
        "construction_date": "01-01-2014",
        "opening_value": 1200,
        "currency": "Euro"
    }, {
        "asset_id": 23,
        "location_id": 1,
        "type_id": 1,
        "logo_id": undefined,
        "name": "WeirdSoft ClosedEJB",
        "version": "",
        "comment": "RN01911",
        "construction_date": "01-01-2014",
        "opening_value": 0,
        "currency": "euro"
    }
];

app.use(express.static(html_dir));

app.get('/resources/assettypelist', function (req, res) {
    res.json(mockedAssetTypes);
});

app.get('/resources/assetlist/', function (req, res) {
    var sortedMockedObjects = [];
    var search = req.query.searchText;
    var typeId = req.query.typeId;
    var tmp;
    var i;
    if (typeId) {
        for (i = 0; i < mockedAssets.length; i++) {
            tmp = mockedAssets[i];
            if (tmp.type_id == typeId) {
                sortedMockedObjects.push(tmp);
            }
        }
    }
    else if (search) {
        for (i = 0; i < mockedAssets.length; i++) {
            tmp = mockedAssets[i];
            var j = tmp.name.indexOf(search);
            if (j >= 0) {

                sortedMockedObjects.push(tmp);
            }
        }
    } else if (!search && !typeId) {
        sortedMockedObjects = mockedAssets;
    }
    res.json(
        {
            "total": sortedMockedObjects.length,
            "assets": sortedMockedObjects
        }
    )

});

app.get('/resources/assets/:assetId', function (req, res) {
    for (var i = 0; i < mockedAssets.length; i++) {
        if (mockedAssets[i].asset_id == req.params.assetId) {
            res.json(
                mockedAssets[i]
            );
        }
    }


});


var server = app.listen(8080, function () {

    var host = server.address().adress;
    var port = server.address().port;

    console.log('Example app listening at http://%s:%s', host, port);

});


/*
 "asset_id": 1,
 "location_id": 1,
 "type_id": 1,
 "logo_id": undefined,
 "name": "Premium License",
 "comment": "needs to be checked",
 "construction_date": "01.01.2013",
 "opening_value": 1200,
 "currency": "euro"
 },
 {
 "asset_id": 3,
 "location_id": 1,
 "type_id": 1,
 "logo_id": undefined,
 "name": "Free License",
 "comment": "",
 "construction_date": "01.01.2015",
 "opening_value": 0,
 "currency": "euro"
 },
 {
 "asset_id": 4,
 "location_id": 1,
 "type_id": 1,
 "logo_id": undefined,
 "name": "Free License",
 "comment": "",
 "construction_date": "01.01.2015",
 "opening_value": 0,
 "currency": "euro"
 },
 {
 "asset_id": 5,
 "location_id": 1,
 "type_id": 1,
 "logo_id": undefined,
 "name": "Free License",
 "comment": "",
 "construction_date": "01.01.2015",
 "opening_value": 0,
 "currency": "euro"
 },
 {
 "asset_id": 6,
 "location_id": 1,
 "type_id": 1,
 "logo_id": undefined,
 "name": "Free License",
 "comment": "",
 "construction_date": "01.01.2015",
 "opening_value": 0,
 "currency": "euro"
 },
 {
 "asset_id": 7,
 "location_id": 1,
 "type_id": 4,
 "logo_id": undefined,
 "name": "Free License",
 "comment": "",
 "construction_date": "01.01.2015",
 "opening_value": 0,
 "currency": "euro"
 },
 {
 "asset_id": 8,
 "location_id": 1,
 "type_id": 4,
 "logo_id": undefined,
 "name": "Free License",
 "comment": "",
 "construction_date": "01.01.2015",
 "opening_value": 0,
 "currency": "euro"
 },
 {
 "asset_id": 9,
 "location_id": 1,
 "type_id": 4,
 "logo_id": undefined,
 "name": "Free License",
 "comment": "",
 "construction_date": "01.01.2015",
 "opening_value": 0,
 "currency": "euro"
 }];*/