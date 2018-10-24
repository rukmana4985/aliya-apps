package com.project.aliya.utils;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.EditText;

import com.google.android.gms.maps.model.LatLng;
import com.project.aliya.R;
import com.project.aliya.base.callback.CallbackDialog;

import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

public class Util {
    protected IntentManager intentManager;

    public String VALIDATION_MAX24 = "Masukkan minimal 3 karakter";
    public String VALIDATION_MINMAX13 = "Masukkan minimal 10 karakter";

    public static String noSpecialChar = "^[\\w_\\s]+$";
    public static String address = "^[\\w\\s.]+$";
    public static String usernameRegex = "^[\\w_]+$";
    public static String inputForm = "^[\\w,\\s]+$";
    public static String onlyCharUnderScore = "^[a-zA-Z\\s]+$";
    public static String onlyDigits = "^\\d+$";

    static final Integer LOCATION = 0x1;

    public Util(){
        IntentManager intentManager = new IntentManager();
    }

    public void showDialogError(Context context, String message) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final AlertDialog alert = builder.create();
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton(context.getResources().getString(R.string.try_again), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alert.cancel();
            }
        });
        builder.show();
    }

    public void showExpired(Context context) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final AlertDialog alert = builder.create();
        builder.setMessage(context.getResources().getString(R.string.expired_session));
        builder.setCancelable(false);
        builder.setPositiveButton(context.getResources().getString(R.string.login_again), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //intentManager.toLogin();
            }
        });
        builder.show();
    }

    public void showUnauthorized(final Context context, final Activity activity) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final AlertDialog alert = builder.create();
        builder.setMessage(context.getResources().getString(R.string.expired_session));
        builder.setCancelable(false);
        builder.setPositiveButton(context.getResources().getString(R.string.login_again), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                intentManager.toLogin(activity);
            }
        });
        builder.show();
    }

    public boolean validateEdittext(EditText editText, int lengthMin, int lengthMax, String error) {
        if (editText.getText().length() < lengthMin || editText.getText().length() > lengthMax) {
            editText.setError(error);
            editText.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public final static boolean regexOnlyChar(String character) {
        return regex(character, onlyCharUnderScore);
    }

    public final static boolean regexUsername(String character) {
        return regex(character, usernameRegex);
    }


    public final static boolean regex(String input, String regex) {
        final Pattern pattern = Pattern.compile(regex);
        return (pattern.matcher(input).matches());
    }

    public static boolean askForPermission(Activity activity, String permission, Integer requestCode) {
        if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {

                //This is called if user has denied the permission before
                //In this case I am just asking the permission again
                ActivityCompat.requestPermissions(activity, new String[]{permission}, requestCode);
                return false;
            } else {
                ActivityCompat.requestPermissions(activity, new String[]{permission}, requestCode);
                return false;
            }
        } else {
            //Toast.makeText(activity, "" + permission + " is already granted.", Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    public static LatLng getCurLocation(Activity act) {
        LocationManager manager = (LocationManager) act.getSystemService(Context.LOCATION_SERVICE);
        if (manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Location loc = getLastKnownLocation(act);
            if (loc != null) {
                return new LatLng(loc.getLatitude(), loc.getLongitude());
            }
        }
        else{
            buildAlertMessageNoGps(act);
        }
        return null;
    }

    private static void buildAlertMessageNoGps(final Activity act) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(act);
        builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        act.startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

    public static Location getLastKnownLocation(Activity act) {
        LocationManager mLocationManager = (LocationManager) act.getSystemService(Context.LOCATION_SERVICE);
        List<String> providers = mLocationManager.getProviders(true);
        Location bestLocation = null;
        for (String provider : providers) {
            if (ActivityCompat.checkSelfPermission(act, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(act, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
            }
            Location l = mLocationManager.getLastKnownLocation(provider);
            if (l == null) {
                continue;
            }
            if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy()) {
                // Found best last known location: %s", l);
                bestLocation = l;
            }
        }
        return bestLocation;
    }

    public void exitDialog(final Activity context){
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final AlertDialog alert = builder.create();
        builder.setMessage(context.getString(R.string.prompt_exit));
        builder.setCancelable(true);
        builder.setNegativeButton(context.getString(R.string.yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                context.finish();
            }
        });
        builder.setPositiveButton(context.getString(R.string.no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alert.cancel();
            }
        });
        builder.show();
    }

    public void imageAlertDialog(final Activity context, final CallbackDialog callbackDialog, final int type){
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final AlertDialog alert = builder.create();
        builder.setMessage(context.getString(R.string.prompt_image));
        builder.setCancelable(true);
        builder.setNegativeButton(context.getString(R.string.no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alert.cancel();
            }
        });
        builder.setPositiveButton(context.getString(R.string.yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                callbackDialog.onYes(type);
            }
        });
        builder.show();
    }

    public static Integer randomNumber() {
        Random r = new Random( System.currentTimeMillis() );
        return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
    }
}
