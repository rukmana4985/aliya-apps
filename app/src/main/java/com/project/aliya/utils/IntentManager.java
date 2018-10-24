package com.project.aliya.utils;

import android.app.Activity;
import android.content.Intent;

import com.project.aliya.activity.LoginActivity;
import com.project.aliya.activity.TermActivity;


public class IntentManager {


    public static void toLogin(Activity context) {
        context.finish();
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    public interface Code {
        int FORM = 6001;
        int REQUEST_CAMERA = 1;
        int REQUEST_CAMERA_FARMER = 2;
        int BACKGROUND = 1;
        int BITMAP = 2;

        int IMAGE_ONE = 11;
        int IMAGE_TWO = 12;
        int IMAGE_THREE = 13;
        int IMAGE_FOUR = 14;
        int IMAGE_FIVE = 15;

    }

  /* public static String setDataResult(Intent data, ImageView image, int setImage, Resources resources, Context context) {
        String path = data.getStringExtra(UtilsCamera.resultTagCamera);
        String urlImage = sendImage(path, context);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        if (path != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(path, options);
            if (bitmap != null) {
                image.setImageBitmap(null);
                switch (setImage) {
                    case Code.BACKGROUND:
                        Drawable drawable = new BitmapDrawable(resources, bitmap);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            //image.setBackground(drawable);
                            image.setImageDrawable(drawable);

                        } else
                            image.setImageDrawable(drawable);
                            //image.setBackgroundDrawable(drawable);
                        break;
                    case Code.BITMAP:
                        image.setImageBitmap(bitmap);
                        break;
                }
            }
        }
        return urlImage;
    }

    private static String sendImage(final String path, final Context context) {
        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setMessage(context.getResources().getString(R.string.content_progress));
        progressDialog.show();
        final String[] urlImage = {""};
        File file = new File(path);
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part multipartBody = MultipartBody.Part.createFormData("image", file.getName(),
                requestBody);
        ApiConfig apiConfig = ApiClient.getClient((Activity) context).create(ApiConfig.class);
        Call<ResponseUploadPicture> uploadImage = apiConfig.getUploadImage(multipartBody);
        uploadImage.enqueue(new Callback<ResponseUploadPicture>() {
            @Override
            public void onResponse(Call<ResponseUploadPicture> call, Response<ResponseUploadPicture> response) {
                if (response.body().getStatus() == 401) {
                    Token token = new Token(context);
                    token.setAuthToken(response.body().getNewAuthToken());
                    sendImage(path, context, req);
                } else if (response.body().getStatus() == 202) {
                    urlImage[0] = response.body().getData().getImageUrl();
                    req.setFarmerImage(response.body().getData().getImageUrl());
                    progressDialog.dismiss();
                } else {
                    Util util = new Util();
                    util.showDialogError(context, response.body().getMessage());
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ResponseUploadPicture> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
                //Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return urlImage[0];
    }

    public static void toNavigationHome(Activity activity) {
        NavigationActivity_.intent(activity).start();
        activity.finish();
    }
  */
}
