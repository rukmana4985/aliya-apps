package com.project.aliya.viewholder;

import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.project.aliya.R;
import com.project.aliya.activity.DetailInfoActivity;
import com.project.aliya.activity.MainActivity;
import com.project.aliya.model.content.ModelInfo;
import com.project.aliya.model.response.ResponseListInfo;
import com.project.aliya.model.response.ResponseListProduct;
import com.squareup.picasso.Picasso;

public class VHListInfo extends RecyclerView.ViewHolder  implements View.OnClickListener  {

    private ImageView image;
    private TextView title,preview;
    private ModelInfo modelInfo;
    public VHListInfo(View itemView) {
        super(itemView);
        title            = findView(R.id.title);
        preview          = findView(R.id.preview);
        image            = findView(R.id.image);
        itemView.setOnClickListener(this);
    }

    public void setData(ModelInfo data) {
        Picasso.get().load(data.getImage())
                .into(image);
        title.setText(data.getTitle());
        preview.setText(data.getContentPreview());
        modelInfo = data;
    }

    private <T extends View> T findView(int id) {
        return (T) itemView.findViewById(id);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), DetailInfoActivity.class);
        String stringInfo = (new Gson().toJson(modelInfo));
        intent.putExtra("info", stringInfo);
        view.getContext().startActivity(intent);
    }
}
