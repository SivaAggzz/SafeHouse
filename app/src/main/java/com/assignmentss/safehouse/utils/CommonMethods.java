package com.assignmentss.safehouse.utils;

import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class CommonMethods {
    public static void showShortToast(Context context,String msg) {
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
    public static void loadImage(ImageView imageView, String URL){
        Glide.with(imageView.getContext()).load(URL).into(imageView);
    }
}
