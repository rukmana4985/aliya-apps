package com.project.aliya.viewholder;

import android.Manifest;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.aliya.R;
import com.project.aliya.model.response.ResponseListBonus;
import com.squareup.picasso.Picasso;

/**
 * Created by faizf on 6/18/2017.
 */

public class VHListBonus extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ImageView image;
    private TextView title;
    private TextView description;
    private RecyclerView list;

    public VHListBonus(View itemView) {
        super(itemView);
        title = findView(R.id.title);
        image = findView(R.id.image);
        description = findView(R.id.description);
        list= findView(R.id.list);
        itemView.setOnClickListener(this);
    }

    public void setData(ResponseListBonus data) {
        Picasso.get().load(data.getImage())
                .into(image);
        title.setText(data.getTitle());
        description.setText(data.getDescriptions());
        itemView.setTag(data.getUrl());
    }

    private <T extends View> T findView(int id) {
        return (T) itemView.findViewById(id);
    }

    @Override
    public void onClick(View v) {
        downloadFile(v.getContext(),(String) v.getTag());

    }
    public void downloadFile(Context context, String url){
        if(ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 1);

        }else{
            String myHTTPUrl = url;
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));
            request.setTitle(title.getText());
            request.setDescription("File is being downloaded...");
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            String nameOfFile = URLUtil.guessFileName(myHTTPUrl,null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, nameOfFile);
            DownloadManager manager = (DownloadManager)context.getSystemService(Context.DOWNLOAD_SERVICE);
            manager.enqueue(request);
        }

    }


}
