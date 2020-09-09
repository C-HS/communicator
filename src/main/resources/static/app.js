var stompClient = null;
function connect() {
    var socket = new SockJS('/iaito-iot');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        stompClient.subscribe('/topic/vehicleDeviceInformation', function (vehicleDeviceData) {
//        	showDeviceInfo(JSON.parse(vehicleDeviceData.body));
        	console.log(JSON.parse(vehicleDeviceData.body));
        });
    });
}
function showDeviceInfo(message) {
    $("#userinfo").append("<tr>" +
    						"<td>" + message.longitude + "</td>" + 
    						"<td>" + message.latitude + "</td>" +
    						"<td>" + message.altitude + "</td>" +
    						"<td>" + message.tagId + "</td>" 
    					+"</tr>");
}
function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}
$(function () {
	connect();
});