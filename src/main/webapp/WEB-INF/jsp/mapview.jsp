<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Yard Management Console</title>
	<link rel="stylesheet" href="https://unpkg.com/leaflet@1.6.0/dist/leaflet.css" integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ=="
		  crossorigin="" />
	<script src="https://unpkg.com/leaflet@1.6.0/dist/leaflet.js" integrity="sha512-gZwIG9x3wUXg2hdXF6+rVkLF/0Vi9U8D2Ntg4Ga5I5BZpVkVxlJWbSQtXPSiUTtC0TjtGOmxa1AJPuV0CPthew=="
			crossorigin="">
	</script>
	<link rel="stylesheet" href="assets/vendors/mdi/css/materialdesignicons.min.css">
	<link rel="stylesheet" href="assets/vendors/css/vendor.bundle.base.css">
	<link rel="stylesheet" href="assets/css/style.css">
	<link rel="shortcut icon" href="assets/images/favicon.ico" />
	<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="/webjars/sockjs-client/sockjs.min.js"></script>
	<script src="/webjars/stomp-websocket/stomp.min.js"></script>
	<!-- <script src="sample-geojson.js" type="text/javascript"></script> -->
	<!-- <script src="/app.js"></script> -->
	<style>
		#map {
			width: 100%;
			height: 720px;
		}
		#basemaps-wrapper {
			position: absolute;
			top: 125px;
			right: 25px;
			z-index: 400;
			background: white;
			padding: 10px;
		}
		#basemaps {
			margin-bottom: 5px;
		}
	</style>
</head>
<body>
<div class="container-scroller">
	<jsp:include page="./partials/navbar.jsp" />
	<div class="container-fluid page-body-wrapper">
		<jsp:include page="./partials/sidebar.jsp" />
		<div class="main-panel">
			<div class="content-wrapper">
				<div class="row">
					<div id='map'></div>
					<div id="basemaps-wrapper" class="leaflet-bar">
						<select id="basemaps" onchange="changeMapTile(this);">
							<option value="terr">Terrian</option>
							<option value="street">Street</option>
							<option value="hyb">Hybrid</option>
							<option value="sat">Satellite</option>
						</select>
					</div>
				</div>
			</div>
			<jsp:include page="./partials/footer.jsp" />
		</div>
	</div>
</div>
<script>

/* 
    var customeBondedArea = {
        "type":"FeatureCollection",
        "features":[{
            "type":"Feature",
            "geometry":{
                "type":"Polygon",
                "coordinates":[[
                    [80.2457953,26.4585406,0],
                    [80.2457953,26.4579739,0],
                    [80.2463103,26.4579355,0],
                    [80.2462674,26.4574937,0],
                    [80.2484346,26.45734,0],
                    [80.2485848,26.4583293,0],
                    [80.2457953,26.4585406,0]
                ]]
            },
            "properties":{
                "name":"Customs Bonded Area"
            }
        }]
    };
    var emptyContainerYard = {"type":"FeatureCollection","features":[
            {"type":"Feature","geometry":{"type":"Polygon","coordinates":[[[80.2428771,26.4588576,0],[80.2428127,26.4583005,0],[80.2456344,26.4580796,0],[80.2456559,26.4586367,0],[80.2428771,26.4588576,0]]]},"properties":{"name":"Empty Container Yard"}}
        ]};
    var railwayYard = {"type":"FeatureCollection","features":[
            {"type":"Feature","geometry":{"type":"Polygon","coordinates":[[[80.2422012,26.4591553,0],[80.2421797,26.4589248,0],[80.2485956,26.4583965,0],[80.2486492,26.4586463,0],[80.2422012,26.4591553,0]]]},"properties":{"name":"Railway Yard"}}
        ]};
    var areaUnitOne = {
        "type": "Feature",
        "properties": {
            "name": "Unit One"
        },
        "geometry": {
            "type": "Polygon",
            "coordinates": [
                [
                    [
                        80.24818137288094,
                        26.45808706517649
                    ],
                    [
                        80.24854212999344,
                        26.45808706517649
                    ],
                    [
                        80.24854212999344,
                        26.458327192510943
                    ],
                    [
                        80.24818137288094,
                        26.458327192510943
                    ],
                    [
                        80.24818137288094,
                        26.45808706517649
                    ]
                ]
            ]
        }
    };
    var areaUnitTwo = {
        "type": "Feature",
        "properties": {
            "name": "Unit Two"
        },
        "geometry": {
            "type": "Polygon",
            "coordinates": [
                [
                    [
                        80.24772405624388,
                        26.45808826581443
                    ],
                    [
                        80.24816930294037,
                        26.45808826581443
                    ],
                    [
                        80.24816930294037,
                        26.458348803946482
                    ],
                    [
                        80.24772405624388,
                        26.458348803946482
                    ],
                    [
                        80.24772405624388,
                        26.45808826581443
                    ]
                ]
            ]
        }
    };
    var areaUnitThree = {
        "type": "Feature",
        "properties": {
            "name": "Unit Three"
        },
        "geometry": {
            "type": "Polygon",
            "coordinates": [
                [
                    [
                        80.24710714817047,
                        26.45808706517649
                    ],
                    [
                        80.24770930409431,
                        26.45808706517649
                    ],
                    [
                        80.24770930409431,
                        26.45837641855265
                    ],
                    [
                        80.24710714817047,
                        26.45837641855265
                    ],
                    [
                        80.24710714817047,
                        26.45808706517649
                    ]
                ]
            ]
        }
    };
    var areaUnitFour = {
        "type": "Feature",
        "properties": {
            "name": "Unit Four"
        },
        "geometry": {
            "type": "Polygon",
            "coordinates": [
                [
                    [
                        80.24656131863594,
                        26.45808706517649
                    ],
                    [
                        80.2470937371254,
                        26.45808706517649
                    ],
                    [
                        80.2470937371254,
                        26.458405233786785
                    ],
                    [
                        80.24656131863594,
                        26.458405233786785
                    ],
                    [
                        80.24656131863594,
                        26.45808706517649
                    ]
                ]
            ]
        }
    };
    var areaUnitFive = {
        "type": "Feature",
        "properties": {
            "name": "Unit Five"
        },
        "geometry": {
            "type": "Polygon",
            "coordinates": [
                [
                    [
                        80.24581298232079,
                        26.45808946645232
                    ],
                    [
                        80.24654790759087,
                        26.45808946645232
                    ],
                    [
                        80.24654790759087,
                        26.458468867403347
                    ],
                    [
                        80.24581298232079,
                        26.458468867403347
                    ],
                    [
                        80.24581298232079,
                        26.45808946645232
                    ]
                ]
            ]
        }
    };
    var areaUnitSix = {
        "type": "Feature",
        "properties": {
            "name": "Unit Six"
        },
        "geometry": {
            "type": "Polygon",
            "coordinates": [
                [
                    [
                        80.24793058633804,
                        26.457638025717106
                    ],
                    [
                        80.24847239255905,
                        26.457638025717106
                    ],
                    [
                        80.24847239255905,
                        26.45799701729695
                    ],
                    [
                        80.24793058633804,
                        26.45799701729695
                    ],
                    [
                        80.24793058633804,
                        26.457638025717106
                    ]
                ]
            ]
        }
    };
    var areaUnitSeven = {
        "type": "Feature",
        "properties": {
            "name": "Unit Seven"
        },
        "geometry": {
            "type": "Polygon",
            "coordinates": [
                [
                    [
                        80.24721041321754,
                        26.457638025717106
                    ],
                    [
                        80.24791985750198,
                        26.457638025717106
                    ],
                    [
                        80.24791985750198,
                        26.457982609629706
                    ],
                    [
                        80.24721041321754,
                        26.457982609629706
                    ],
                    [
                        80.24721041321754,
                        26.457638025717106
                    ]
                ]
            ]
        }
    };
    var areaUnitEight = {
        "type": "Feature",
        "properties": {
            "name": "Unit Eight"
        },
        "geometry": {
            "type": "Polygon",
            "coordinates": [
                [
                    [
                        80.24651035666466,
                        26.457640427002303
                    ],
                    [
                        80.24719029664993,
                        26.457640427002303
                    ],
                    [
                        80.24719029664993,
                        26.457987412185652
                    ],
                    [
                        80.24651035666466,
                        26.457987412185652
                    ],
                    [
                        80.24651035666466,
                        26.457640427002303
                    ]
                ]
            ]
        }
    };
    var areaUnitNine = {
        "type": "Feature",
        "properties": {
            "name": "Unit Nine",
            "fill": "#ad1010"
        },
        "geometry": {
            "type": "Polygon",
            "coordinates": [
                [
                    [
                        80.2476717531681,
                        26.457412304685693
                    ],
                    [
                        80.24843618273735,
                        26.457412304685693
                    ],
                    [
                        80.24843618273735,
                        26.457577993571107
                    ],
                    [
                        80.2476717531681,
                        26.457577993571107
                    ],
                    [
                        80.2476717531681,
                        26.457412304685693
                    ]
                ]
            ]
        }
    };
 */

 var kesaGround = {
	"type":"FeatureCollection",
	"features":[{
		"type":"Feature",
		"geometry":{
			"type":"Polygon",
			"coordinates":[[
				[80.258848, 26.5108258, 0],
				[80.2591766, 26.5106818, 0],
				[80.2593978, 26.5111259, 0],
				[80.259084, 26.5112639, 0],
				[80.258848, 26.5108258, 0]
			]]
		},
		"properties":{
			"name":"Kesa Ground"
		}
	}]
};

var area1 = {
      "type": "Feature",
      "properties": {
      	"name": "Area1"
       },
      "geometry": {
        "type": "Polygon",
        "coordinates": [
          [
            [80.2590867, 26.5112507],
			[80.259068, 26.5112195],
			[80.2591337, 26.5111895],
			[80.2591551, 26.5112207],
			[80.2590867, 26.5112507]
          ]
        ]
      }
    };


var area2 = {
      "type": "Feature",
      "properties": {
      	"name": "Area2"
       },
      "geometry": {
        "type": "Polygon",
        "coordinates": [
          [
			[80.2591551, 26.5112207],
			[80.2591337, 26.5111895],
			[80.2592048, 26.5111583],
			[80.2592276, 26.5111871],
			[80.2591551, 26.5112207]
          ]
        ]
      }
    };

    var area3 = {
      "type": "Feature",
      "properties": {
      	"name": "Area3"
       },
      "geometry": {
        "type": "Polygon",
        "coordinates": [
          [
			[80.2592276, 26.5111871],
			[80.2592048, 26.5111583],
			[80.2592866, 26.5111223],
			[80.2593053, 26.5111523],
			[80.2592276, 26.5111871]
          ]
        ]
      }
    };

    var area4 = {
      "type": "Feature",
      "properties": {
      	"name": "Area4"
       },
      "geometry": {
        "type": "Polygon",
        "coordinates": [
          [
			[80.2593053, 26.5111523],
			[80.2592866, 26.5111223],
			[80.259371, 26.5110923],
			[80.2593871, 26.5111151],
			[80.2593053, 26.5111523]
          ]
        ]
      }
    };


    var area5 = {
      "type": "Feature",
      "properties": {
      	"name": "Area5"
       },
      "geometry": {
        "type": "Polygon",
        "coordinates": [
          [
			[80.2590572, 26.5111871],
			[80.2590371, 26.5111559],
			[80.2591001, 26.5111283],
			[80.2591203, 26.5111595],
			[80.2590572, 26.5111871]
          ]
        ]
      }
    };

   var area6 = {
      "type": "Feature",
      "properties": {
      	"name": "Area6"
       },
      "geometry": {
        "type": "Polygon",
        "coordinates": [
          [
			[80.2591203, 26.5111595],
			[80.2591001, 26.5111283],
			[80.2591712, 26.5110959],
			[80.2591967, 26.5111283],
			[80.2591203, 26.5111595]
          ]
        ]
      }
    };

   var area7 = {
      "type": "Feature",
      "properties": {
      	"name": "Area7"
       },
      "geometry": {
        "type": "Polygon",
        "coordinates": [
          [
			[80.2591967, 26.5111283],
			[80.2591712, 26.5110959],
			[80.259249, 26.5110671],
			[80.2592718, 26.5110971],
			[80.2591967, 26.5111283]
          ]
        ]
      }
    };

   var area8 = {
      "type": "Feature",
      "properties": {
      	"name": "Area8"
       },
      "geometry": {
        "type": "Polygon",
        "coordinates": [
          [
			[80.2592718, 26.5110971],
			[80.259249, 26.5110671],
			[80.2593348, 26.5110275],
			[80.2593576, 26.5110623],
			[80.2592718, 26.5110971]
          ]
        ]
      }
    };

   var area9 = {
      "type": "Feature",
      "properties": {
      	"name": "Area9"
       },
      "geometry": {
        "type": "Polygon",
        "coordinates": [
          [
			[80.2590371, 26.5111559],
			[80.2590143, 26.5111247],
			[80.2590787, 26.5110959],
			[80.2591001, 26.5111283],
			[80.2590371, 26.5111559]
          ]
        ]
      }
    };

   var area10 = {
      "type": "Feature",
      "properties": {
      	"name": "Area10"
       },
      "geometry": {
        "type": "Polygon",
        "coordinates": [
          [
			[80.2591001, 26.5111283],
			[80.2590787, 26.5110959],
			[80.2591471, 26.5110563],
			[80.2591712, 26.5110959],
			[80.2591001, 26.5111283]
          ]
        ]
      }
    };

   var area11 = {
      "type": "Feature",
      "properties": {
      	"name": "Area11"
       },
      "geometry": {
        "type": "Polygon",
        "coordinates": [
          [
			[80.2591712, 26.5110959],
			[80.2591565, 26.5110623],
			[80.2592249, 26.5110335],
			[80.259249, 26.5110671],
			[80.2591712, 26.5110959]
          ]
        ]
      }
    };

   var area12 = {
      "type": "Feature",
      "properties": {
      	"name": "Area12"
       },
      "geometry": {
        "type": "Polygon",
        "coordinates": [
          [
			[80.2592514, 26.5110592],
			[80.2592249, 26.5110335],
			[80.259309, 26.5109968],
			[80.2593251, 26.5110244],
			[80.2592514, 26.5110592]
          ]
        ]
      }
    };

    var stompClient = null;
	var satUrl = 'http://{s}.google.com/vt/lyrs=s&x={x}&y={y}&z={z}';
	var streetUrl = 'http://{s}.google.com/vt/lyrs=m&x={x}&y={y}&z={z}';
	var hybridUrl = 'http://{s}.google.com/vt/lyrs=s,h&x={x}&y={y}&z={z}';
	var terrUrl = 'http://{s}.google.com/vt/lyrs=p&x={x}&y={y}&z={z}';
    var mZoom = 20;
	var sDomain = ['mt0','mt1','mt2','mt3'];
	var customStreetLayer = new L.TileLayer(streetUrl, {subdomains:sDomain, maxZoom:22, maxNativeZoom:19});
	var customTerrLayer = new L.TileLayer(terrUrl, {subdomains:sDomain, maxZoom:22, maxNativeZoom:19});
	var customHybridLayer = new L.TileLayer(hybridUrl, {subdomains:sDomain, maxZoom:22, maxNativeZoom:19});
	var customSatelliteLayer = new L.TileLayer(satUrl, {subdomains:sDomain, maxZoom:22, maxNativeZoom:19});
	var map ;
	changeMapTile = function(sel){
		map.eachLayer(function (layer) {
			map.removeLayer(layer);
		});
		switch (sel.value) {
			case 'terr':
				map.addLayer(customTerrLayer);
				break;
			case 'street':
				map.addLayer(customStreetLayer);
				break;
			case 'hyb':
				map.addLayer(customHybridLayer);
				break;
			case 'sat':
				map.addLayer(customSatelliteLayer);
				break;
		}
		drawAreas();
	}
	initiateMap = function(){
		//map = new L.Map('map', {layers: [customStreetLayer], center: new L.LatLng(26.45854, 80.2457), zoom:mZoom, attributionControl:false });
        map = new L.Map('map', {layers: [customStreetLayer], center: new L.LatLng(26.511041, 80.259164), zoom:mZoom, attributionControl:false });
        drawAreas();
	}
	function connect() {
		var socket = new SockJS('/iaito-iot');
		stompClient = Stomp.over(socket);
		stompClient.connect({}, function (frame) {
			stompClient.subscribe('/topic/vehicleDeviceInformation', function (vehicleDeviceData) {
				var  demo = JSON.parse(vehicleDeviceData.body);
				placeContainer(demo);
			});
		});
	}
	function disconnect() {
		if (stompClient !== null) {
			stompClient.disconnect();
		}
		setConnected(false);
		console.log("Disconnected");
	}
	$(function () {
		initiateMap();
		connect();
	});
	function drawAreas(){
		// L.geoJSON(customeBondedArea, {onEachFeature: onEachFeature}).addTo(map);
		// L.geoJSON(emptyContainerYard, {onEachFeature: onEachFeature}).addTo(map);
		// L.geoJSON(railwayYard, {onEachFeature: onEachFeature}).addTo(map);
		// L.geoJSON(areaUnitOne, {onEachFeature: onEachFeature}).addTo(map);
		// L.geoJSON(areaUnitTwo, {onEachFeature: onEachFeature}).addTo(map);
		// L.geoJSON(areaUnitThree, {onEachFeature: onEachFeature}).addTo(map);
		// L.geoJSON(areaUnitFour, {onEachFeature: onEachFeature}).addTo(map);
		// L.geoJSON(areaUnitFive, {onEachFeature: onEachFeature}).addTo(map);
		// L.geoJSON(areaUnitSix, {onEachFeature: onEachFeature}).addTo(map);
		// L.geoJSON(areaUnitSeven, {onEachFeature: onEachFeature}).addTo(map);
		// L.geoJSON(areaUnitEight, {onEachFeature: onEachFeature}).addTo(map);
        // L.geoJSON(areaUnitNine, {onEachFeature: onEachFeature}).addTo(map);
        
        L.geoJSON(kesaGround,{onEachFeature: onEachFeature}).addTo(map);
		L.geoJSON(area1, {onEachFeature: onEachFeature}).addTo(map);
		L.geoJSON(area2, {onEachFeature: onEachFeature}).addTo(map);
		L.geoJSON(area3, {onEachFeature: onEachFeature}).addTo(map);
		L.geoJSON(area4, {onEachFeature: onEachFeature}).addTo(map);
		L.geoJSON(area5, {onEachFeature: onEachFeature}).addTo(map);
		L.geoJSON(area6, {onEachFeature: onEachFeature}).addTo(map);
		L.geoJSON(area7, {onEachFeature: onEachFeature}).addTo(map);
		L.geoJSON(area8, {onEachFeature: onEachFeature}).addTo(map);
		L.geoJSON(area9, {onEachFeature: onEachFeature}).addTo(map);
		L.geoJSON(area10, {onEachFeature: onEachFeature}).addTo(map);
        L.geoJSON(area11, {onEachFeature: onEachFeature}).addTo(map);
        L.geoJSON(area12, {onEachFeature: onEachFeature}).addTo(map);
	}
	function onEachFeature(feature, layer) {
		layer.bindPopup(feature.properties["name"]);
	}
	function placeContainer(liveContainerData){
		L.marker([liveContainerData.longitude,  liveContainerData.latitude]).addTo(map)
				.bindPopup(liveContainerData.tagId)
				.openPopup();
	}
	function placeAlreadyExistingAssets(){}
</script>
<script src="assets/vendors/js/vendor.bundle.base.js"></script>
<script src="assets/vendors/chart.js/Chart.min.js"></script>
<script src="assets/js/off-canvas.js"></script>
<script src="assets/js/hoverable-collapse.js"></script>
<script src="assets/js/misc.js"></script>
<script src="assets/js/dashboard.js"></script>
<script src="assets/js/todolist.js"></script>
</body>
</html>
