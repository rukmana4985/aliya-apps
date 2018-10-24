package com.project.aliya.viewholder;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.project.aliya.R;
import com.project.aliya.activity.DetailProductActivity;
import com.project.aliya.model.content.ModelCategory;
import com.project.aliya.model.content.ModelProduct;

public class VHListCategory extends RecyclerView.ViewHolder  implements View.OnClickListener  {

    private TextView name;
    private ModelCategory modelCategory;

    public VHListCategory(View itemView) {
        super(itemView);
        name            = findView(R.id.name);
        itemView.setOnClickListener(this);
    }

    public void setData(ModelCategory data) {
        name.setText(data.getName());
    }

    private <T extends View> T findView(int id) {
        return (T) itemView.findViewById(id);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), DetailProductActivity.class);
        String stringProduct = (new Gson().toJson(modelCategory));
        intent.putExtra("category", stringProduct);
        view.getContext().startActivity(intent);
    }
}
