function initMap() {
    const myLatlng = { lat: 24.0028956, lng: 90.0594985 };
    const map = new google.maps.Map(document.getElementById("map"), {
        zoom: 4,
        center: myLatlng,
    });

    let infoWindow = new google.maps.InfoWindow({
        content: "Click on the map where you placed pharmacy to get Latitude and Longitude!",
        position: myLatlng,
    });
    infoWindow.open(map);

    map.addListener("click", (mapsMouseEvent) => {

        setPositionToInputField(mapsMouseEvent.latLng);
        infoWindow.close();
        infoWindow = new google.maps.InfoWindow({
            position: mapsMouseEvent.latLng,
        });
        infoWindow.setContent(
            JSON.stringify(mapsMouseEvent.latLng.toJSON(), null, 2)
        );
        infoWindow.open(map);
    });
}


function setPositionToInputField(position) {
    const lat = position.lat();
    const lng = position.lng();

    $("#latitude").val(lat);
    $("#longitude").val(lng);
}