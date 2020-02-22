package com.tykamm.quiz;


import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 */
public class PhotoFragment extends Fragment {

    Button btn;
    ImageView imageView;
    WallpaperManager wallpaperManager;
    Bitmap bitmap1,bitmap2;
    DisplayMetrics displayMetrics;
    int width,height;
    BitmapDrawable bitmapDrawable;

    public PhotoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_photo, container, false);
       btn=view.findViewById(R.id.button);
       imageView=view.findViewById(R.id.image_view);
       wallpaperManager=WallpaperManager.getInstance(getContext());
       bitmapDrawable=(BitmapDrawable)imageView.getDrawable();
       bitmap1=bitmapDrawable.getBitmap();
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               getScreenWidthHeight();
               setBitmapSize();
               wallpaperManager=WallpaperManager.getInstance(getContext());
               try{
                   wallpaperManager.setBitmap(bitmap2);
                   wallpaperManager.suggestDesiredDimensions(width,height);
               }catch (IOException e){
                   e.printStackTrace();
               }
           }
       });
       return view;
    }
    public void getScreenWidthHeight(){
        displayMetrics=new DisplayMetrics();
        width=displayMetrics.widthPixels;
        height=displayMetrics.heightPixels;
    }
    public void setBitmapSize(){
        bitmap2=Bitmap.createScaledBitmap(bitmap1,width,height,false);
    }

}
