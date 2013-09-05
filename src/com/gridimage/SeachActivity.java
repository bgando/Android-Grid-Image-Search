package com.gridimage;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

public class SeachActivity extends Activity {
	EditText etQuery;
	GridView gvResults;
	Button btnSearch;
	
	private ImageAdapter adapter;
	List<Image> imageResults = new ArrayList<Image>();
	
	private void setupViews() {
		btnSearch = (Button) findViewById(R.id.btnSearch);
		gvResults = (GridView) findViewById(R.id.gvResults);
		etQuery = (EditText) findViewById(R.id.etQuery);
		adapter = new ImageAdapter(getBaseContext(), imageResults);
		gvResults.setAdapter(adapter);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seach);
		setupViews();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.seach, menu);
		return true;
	}
	
	private void getImage(String query){
		AsyncHttpClient client = new AsyncHttpClient(); 
		client.get(query, new JsonHttpResponseHandler() {
			@Override
			public void onSuccess(JSONObject arg0) {
				Log.d("Debug", arg0.toString());
//				var x = responseData.results;
				try {
					JSONObject rdJsonObject = arg0.getJSONObject("responseData");
					JSONArray resultJsonObject = rdJsonObject.getJSONArray("results");
					
					List<Image> parseJsonArray = Image.parseJsonArray(resultJsonObject);
					adapter.addAll(parseJsonArray);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			@Override
			public void onFailure(Throwable arg0) {
				Log.d("Debug", "request failed.");
			}
		});
	}
	
	public void imageSearch(View v){
		
		String query = etQuery.getText().toString();
		String searchQuery = "https://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=" + query;
		getImage(searchQuery);
	}
}
