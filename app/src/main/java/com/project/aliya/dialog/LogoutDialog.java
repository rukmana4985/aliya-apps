package com.project.aliya.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.project.aliya.R;
import com.project.aliya.base.session.PersonalData;
import com.project.aliya.base.session.SessionToken;
import com.project.aliya.utils.IntentManager;

/**
 * Created by Nalandya on 20/09/2017.
 */

public class LogoutDialog {


    public static void showLogout(final Context context) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final AlertDialog alert = builder.create();
        builder.setMessage(context.getResources().getString(R.string.prompt_logout));
        builder.setCancelable(false);
        builder.setNegativeButton(context.getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                SessionToken token = new SessionToken(context);
                token.clear();
                PersonalData personalData = new PersonalData(context);
                personalData.clear();
                IntentManager.toLogin((Activity) context);

            }
        });
        builder.setPositiveButton(context.getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alert.cancel();
            }
        });
        builder.show();
    }
}
