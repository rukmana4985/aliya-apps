package com.project.aliya.utils;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputType;
import android.util.Patterns;
import android.view.Display;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by faizf on 2/10/2017.
 */
public class UtilsLayout {
    Activity context;


    public String getBodyText(TextView textView) {
        return textView.getText().toString();
    }


    public boolean checkLength(TextView textView, String error) {
        if (getBodyText(textView).length() > 0) {
            textView.setError(null);
            return true;
        } else {
            textView.setError(error);
            textView.requestFocus();
            return false;
        }
    }

    public boolean checkLength(TextView textView, String error, int length) {
        if (getBodyText(textView).length() >= length) {
            textView.setError(null);
            return true;
        } else {
            textView.setError(error);
            textView.requestFocus();
            return false;
        }
    }

    public boolean checkLength(TextView textView, String error, int min, int max) {
        int length = getBodyText(textView).length();
        if (length >= min && length <= max) {
            textView.setError(null);
            return true;
        } else {
            textView.setError(error);
            textView.requestFocus();
            return false;
        }
    }

    public boolean checkLength(TextView textView, String error, String regex, int min, int max) {
        String body = getBodyText(textView);
        int length = body.length();
        if (length >= min && length <= max && Util.regex(body, regex)) {
            textView.setError(null);
            return true;
        } else {
            textView.setError(error);
            textView.requestFocus();
            return false;
        }
    }


    public boolean checkEmail(TextView textView, String error) {
        if (checkLength(textView, error)) {
            Pattern pattern = Patterns.EMAIL_ADDRESS;
            Matcher matcher = pattern.matcher(getBodyText(textView));
            if (matcher.matches()) {
                return true;
            } else {
                textView.setError(error);
                return false;
            }
        }
        return false;
    }


    public boolean checkPassMatch(TextView pass, TextView confirmation, String error) {
        if (checkLength(pass, error)) {
            if (getBodyText(pass).equals(getBodyText(confirmation)))
                return true;
            else {
                confirmation.setError(error);
                return false;
            }
        }
        return false;
    }

    public int widthPhone() {
        Display display = context.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x;
    }

    public int heightPhone() {
        Display display = context.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.y;
    }

    public void showHidePass(TextView textView) {
        if (textView.getInputType() == (InputType.TYPE_CLASS_TEXT |
                InputType.TYPE_TEXT_VARIATION_PASSWORD))
            textView.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        else
            textView.setInputType(InputType.TYPE_CLASS_TEXT |
                    InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }

//    public String setImage(Intent data, ImageView image, int background, Resources resources) {
//        String path = data.getStringExtra(UtilsCamera.resultTagCamera);
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
//        if (path != null) {
//            Bitmap bitmap = BitmapFactory.decodeFile(path, options);
//            if (bitmap != null) {
//                image.setImageBitmap(null);
//                switch (background) {
//                    case IntentManager.Code.BACKGROUND:
//                        Drawable drawable = new BitmapDrawable(resources, bitmap);
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//                            image.setImageDrawable(drawable);
//                            image.bringToFront();
//
//                        } else {
//                            image.setImageDrawable(drawable);
//                            image.bringToFront();
//                        }
//                        break;
//                    case IntentManager.Code.BITMAP:
//                        image.setImageBitmap(bitmap);
//                        break;
//                }
//            }
//        }
//        return path;
//    }
}
