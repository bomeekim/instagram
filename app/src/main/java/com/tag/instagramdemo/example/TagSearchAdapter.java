package com.tag.instagramdemo.example;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tag.instagramdemo.R;
import com.tag.instagramdemo.lazyload.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class TagSearchAdapter extends BaseAdapter {

	private ArrayList<HashMap<String, String>> tagsInfo;
	private LayoutInflater inflater;
	//private ImageLoader imageLoader;

	public TagSearchAdapter(Context context,
							ArrayList<HashMap<String, String>> tagsInfo) {
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.tagsInfo = tagsInfo;
		//this.imageLoader = new ImageLoader(context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = inflater.inflate(R.layout.hashtag_inflater, null);
		Holder holder = new Holder();
		holder.ivPhoto = (ImageView) view.findViewById(R.id.ivImage);
		holder.tvTagName = (TextView) view.findViewById(R.id.tvTagName);
		holder.tvTagName.setText("#" + tagsInfo.get(position).get(
				TagSearch.TAG_NAME));

		holder.tvTagMediaCount = (TextView) view.findViewById(R.id.tvTagMediaCount);
		int count = Integer.parseInt(tagsInfo.get(position).get(TagSearch.TAG_MEDIA_COUNT));
		String convertedCount = String.format("%,d", count);

		holder.tvTagMediaCount.setText("게시물 " + convertedCount + "개");

		//imageLoader.DisplayImage(
				//tagsInfo.get(position).get(Relationship.TAG_PROFILE_PICTURE),
				//holder.ivPhoto);
		return view;
	}

	private class Holder {
		private ImageView ivPhoto;
		private TextView tvTagName;
		private TextView tvTagMediaCount;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return tagsInfo.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

}
