package com.phq.datlichonl.trangchu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.phq.datlichonl.R;

import java.util.List;

public class PhotoAdapter extends PagerAdapter {
    private  Context context ;
    private List<Photo> photoList;

    public PhotoAdapter(Context context, List<Photo> photoList) {
        this.context = context;
        this.photoList = photoList;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_photo,container,false);
        ImageView imageView = view.findViewById(R.id.imgPhoto);
        Photo photo = photoList.get(position);
        if(photo!=null)
            Glide.with(context).load(photo.getId()).into(imageView);
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        if(photoList!=null)
            return  photoList.size();
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
