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
	<script src="/sample-geojson.js" type="text/javascript"></script>
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
	var stompClient = null;
	var satUrl = 'http://{s}.google.com/vt/lyrs=s&x={x}&y={y}&z={z}';
	var streetUrl = 'http://{s}.google.com/vt/lyrs=m&x={x}&y={y}&z={z}';
	var hybridUrl = 'http://{s}.google.com/vt/lyrs=s,h&x={x}&y={y}&z={z}';
	var terrUrl = 'http://{s}.google.com/vt/lyrs=p&x={x}&y={y}&z={z}';
	var mZoom = 18;
	var sDomain = ['mt0','mt1','mt2','mt3'];
	var customStreetLayer = new L.TileLayer(streetUrl, {subdomains:sDomain});
	var customTerrLayer = new L.TileLayer(terrUrl, {subdomains:sDomain});
	var customHybridLayer = new L.TileLayer(hybridUrl, {subdomains:sDomain});
	var customSatelliteLayer = new L.TileLayer(satUrl, {subdomains:sDomain});
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
		map = new L.Map('map', {layers: [customStreetLayer], center: new L.LatLng(26.45854, 80.2457), zoom:mZoom, attributionControl:false });
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
		L.geoJSON(customeBondedArea, {onEachFeature: onEachFeature}).addTo(map);
		L.geoJSON(emptyContainerYard, {onEachFeature: onEachFeature}).addTo(map);
		L.geoJSON(railwayYard, {onEachFeature: onEachFeature}).addTo(map);
		L.geoJSON(areaUnitOne, {onEachFeature: onEachFeature}).addTo(map);
		L.geoJSON(areaUnitTwo, {onEachFeature: onEachFeature}).addTo(map);
		L.geoJSON(areaUnitThree, {onEachFeature: onEachFeature}).addTo(map);
		L.geoJSON(areaUnitFour, {onEachFeature: onEachFeature}).addTo(map);
		L.geoJSON(areaUnitFive, {onEachFeature: onEachFeature}).addTo(map);
		L.geoJSON(areaUnitSix, {onEachFeature: onEachFeature}).addTo(map);
		L.geoJSON(areaUnitSeven, {onEachFeature: onEachFeature}).addTo(map);
		L.geoJSON(areaUnitEight, {onEachFeature: onEachFeature}).addTo(map);
		L.geoJSON(areaUnitNine, {onEachFeature: onEachFeature}).addTo(map);
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