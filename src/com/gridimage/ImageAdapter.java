package com.gridimage;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.loopj.android.image.SmartImageView;

public class ImageAdapter extends ArrayAdapter<Image> {

	public ImageAdapter(Context context, List<Image> objects) {
		super(context, R.layout.result, objects);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		SmartImageView view;
		if (convertView == null) {
			LayoutInflater inflator = LayoutInflater.from(getContext());

			view = (SmartImageView) inflator.inflate(R.layout.result, parent, false);
		} else {
			view = (SmartImageView) convertView;
			view.setImageResource(android.R.color.transparent);
		}
		view.setImageUrl(this.getItem(position).getTbUrl());
		return view;
	}

}
