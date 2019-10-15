package com.example.sliderandviewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;

public class SlideShowAdapter extends PagerAdapter {

    private Context context;
    LayoutInflater inflater;

    public int[] images = {
            R.drawable.javascript_png,
            R.drawable.python_banner,
            R.drawable.swift_png,
            R.drawable.sql_png
    };


    // only used in the slide show adapter class

    public SlideShowAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {

        /*
        *How many pictures my slide show has
        * */

        return images.length;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.slideshow_layout,container,false);
        ImageView img = (ImageView)view.findViewById(R.id.imageview_id);
        //img.setImageResource(images[position]);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view,"Image"+(position+1),Snackbar.LENGTH_LONG).show();

            }
        });
        Glide.with(context).load(images[position]).into(img);
        container.addView(view);
        return view;

        /*
        * images are loaded into our image view
        * */
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        /*
        * For every new images the previous image is destroyed
        * */
        container.removeView((LinearLayout)object);
        /*
        that is for the destroy item method
        * */
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==object);
    }
}
