package Model;

import org.json.simple.JSONObject;

@XMLName(value = "geo")
public class Geo {

	private float lat;
	private float lng;

	public Geo(JSONObject geo) {
		// TODO Auto-generated constructor stub
		super();
		this.lat = Float.parseFloat(geo.get("lat").toString());
		this.lng = Float.parseFloat(geo.get("lng").toString());
	}

	public Geo(float lat, float lon) {
		super();
		this.lat = lat;
		this.lng = lon;
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLon() {
		return lng;
	}

	public void setLon(float lon) {
		this.lng = lon;
	}

}
