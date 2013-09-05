package com.gridimage;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Image {
	private String fullUrl;
	private String tbUrl;

	public Image(JSONObject json){
		try {
			this.fullUrl = json.getString("url");
			this.tbUrl = json.getString("tbUrl");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}
	
	public String toString() {
		return tbUrl;
	}

	public static List<Image> parseJsonArray(JSONArray imageJsonResults){
		List<Image> result = new ArrayList<Image>();
		for(int i = 0; i < imageJsonResults.length(); i++){
			try {
				JSONObject imageObj =  imageJsonResults.getJSONObject(i);
				Image bitmapImg = new Image(imageObj);
				result.add(bitmapImg);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	public String getTbUrl() {
		return tbUrl;
	}
	public void setTbUrl(String tbUrl) {
		this.tbUrl = tbUrl;
	}
	public String getFullUrl() {
		return fullUrl;
	}
	public void setFullUrl(String fullUrl) {
		this.fullUrl = fullUrl;
	}

}
