//09-06 05:22:43.931: D/dalvikvm(2425): Debugger has detached; object registry had 1 entries

package com.gridimage;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

public class SettingsActivity extends Activity {

	private Spinner spinnerImageColorFilter;
	private Spinner spinnerImageSize;
	private Spinner spinnerImageType;
	private EditText etSiteFilter;
	private Button okButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.advanced_search);

		spinnerImageColorFilter = (Spinner) findViewById(R.id.spinnerColorFilter);
		spinnerImageSize = (Spinner) findViewById(R.id.spinnerImageSize);
		spinnerImageType = (Spinner) findViewById(R.id.spinnerImageType);
		etSiteFilter = (EditText) findViewById(R.id.editTextSiteFilter);
		okButton = (Button) findViewById(R.id.okButton);
		okButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				saveSettings();
				finish();
			}
		});

		initImageColorFilterSpinner(spinnerImageColorFilter);
		initImageSizeSpinner(spinnerImageSize);
		initImageTypeSpinner(spinnerImageType);
	}

	private void saveSettings() {

		// Get selected settings
		String colorFilter = (String) spinnerImageColorFilter.getSelectedItem();
		String imageSize = (String) spinnerImageSize.getSelectedItem();
		String imageType = (String) spinnerImageType.getSelectedItem();
		String siteFilter = etSiteFilter.getText().toString();
		
		Toast.makeText(this, colorFilter, Toast.LENGTH_LONG).show();

		// Save selected settings
		SharedPreferences prefs = getPreferences(MODE_PRIVATE);
		prefs.edit().putString("color_filter", colorFilter).commit();
		prefs.edit().putString("image_size", imageSize).commit();
		prefs.edit().putString("image_type", imageType).commit();
		prefs.edit().putString("site_filter", siteFilter).commit();
	}

	private void initImageColorFilterSpinner(Spinner spinner) {
		String[] imageFilters = new String[] { "blue", "green", "red" };
		SpinnerAdapter adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, imageFilters);
		spinner.setAdapter(adapter);
	}

	private void initImageSizeSpinner(Spinner spinner) {
		String[] imageFilters = new String[] { "small", "medium", "large" };
		SpinnerAdapter adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, imageFilters);
		spinner.setAdapter(adapter);
	}

	private void initImageTypeSpinner(Spinner spinner) {
		String[] imageFilters = new String[] { "faces", "animals",
				"landscapes", "houses" };
		SpinnerAdapter adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, imageFilters);
		spinner.setAdapter(adapter);
	}
}
