package com.gridimage;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

public class SettingsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.advanced_search);
		
		Spinner spinnerImageColorFilter = (Spinner) findViewById(R.id.spinnerColorFilter);
		Spinner spinnerImageSize = (Spinner) findViewById(R.id.spinnerImageSize);
		Spinner spinnerImageType = (Spinner) findViewById(R.id.spinnerImageType);
		EditText etSiteFilter = (EditText) findViewById(R.id.editTextSiteFilter);
	}

}
