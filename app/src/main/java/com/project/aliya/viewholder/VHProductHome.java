package com.project.aliya.viewholder;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.project.aliya.R;
import com.project.aliya.activity.DetailProductActivity;
import com.project.aliya.model.content.ModelProduct;

public class VHProductHome extends RecyclerView.ViewHolder  implements View.OnClickListener  {

    private TextView name;
    private TextView description;
    private ModelProduct modelProduct;

    public VHProductHome(View itemView) {
        super(itemView);
        name            = findView(R.id.name);
        description     = findView(R.id.description);
        itemView.setOnClickListener(this);
    }

    public void setData(ModelProduct data) {
        name.setText(data.getName());
        description.setText(data.getDescription());
        modelProduct = data;
    }


    private <T extends View> T findView(int id) {
        return (T) itemView.findViewById(id);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), DetailProductActivity.class);
        String stringProduct = (new Gson().toJson(modelProduct));
        intent.putExtra("product", stringProduct);
        view.getContext().startActivity(intent);
    }
}
