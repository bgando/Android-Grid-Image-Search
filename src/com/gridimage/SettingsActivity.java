package com.gridimage;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class SettingsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.advanced_search);
		
		Spinner spinnerImageColorFilter = (Spinner) findViewById(R.id.spinnerColorFilter);
		Spinner spinnerImageSize = (Spinner) findViewById(R.id.spinnerImageSize);
		Spinner spinnerImageType = (Spinner) findViewById(R.id.spinnerImageType);
		EditText etSiteFilter = (EditText) findViewById(R.id.editTextSiteFilter);
		
		initImageColorFilterSpinner(spinnerImageColorFilter);
		initImageSizeSpinner(spinnerImageSize);
		initImageTypeSpinner(spinnerImageType);
	}

	private void initImageColorFilterSpinner(Spinner spinner) {
		String[] imageFilters = new String[] {
			"blue", 
			"green",
			"red"
		};
		SpinnerAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, imageFilters);
		spinner.setAdapter(adapter);
	}
	
	private void initImageSizeSpinner(Spinner spinner) {
		String[] imageFilters = new String[] {
			"blue", 
			"green",
			"red"
		};
		SpinnerAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, imageFilters);
		spinner.setAdapter(adapter);
	}
	
	private void initImageTypeSpinner(Spinner spinner) {
		String[] imageFilters = new String[] {
			"blue", 
			"green",
			"red"
		};
		SpinnerAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, imageFilters);
		spinner.setAdapter(adapter);
	}
}
