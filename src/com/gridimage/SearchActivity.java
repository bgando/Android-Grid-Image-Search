package com.gridimage;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

public class SearchActivity extends Activity {
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
		setContentView(R.layout.activity_search);
		setupViews();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.seach, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if (item.getItemId() == R.id.action_settings) {
			
			// Launch settings Activity.
			Intent intent = new Intent();
			intent.setClass(this, SettingsActivity.class);
			startActivity(intent);
			
			
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	//does GET request to image search API using AsyncHttpClient library
	private void getImage(String query){
		//create a http client
		AsyncHttpClient client = new AsyncHttpClient(); 
		//get request
		client.get(query, new JsonHttpResponseHandler() {
			@Override
			public void onSuccess(JSONObject arg0) {
				Log.d("Debug", arg0.toString());
				//var x = responseData.results;
				try {
					//get the results array out of the JSON response
					JSONObject rdJsonObject = arg0.getJSONObject("responseData");
					JSONArray resultJsonObject = rdJsonObject.getJSONArray("results");
					
					//method defined in the class to parse the array
					List<Image> parseJsonArray = Image.parseJsonArray(resultJsonObject);
					//uses image adapter
					adapter.addAll(parseJsonArray);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			
			public void onFailure(Throwable error) {
				Log.d("Debug", "NOOO request failed.");
				Log.d("Debug", error.getMessage());
			}
		});
	}
	
	public void imageSearch(View v){
		//get the queryString
		String query = etQuery.getText().toString();
		String searchQuery = "https://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=" + query;
		getImage(searchQuery);
	}
}
