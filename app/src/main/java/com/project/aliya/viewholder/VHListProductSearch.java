package com.project.aliya.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.project.aliya.R;
import com.project.aliya.model.content.ModelProduct;

public class VHListProductSearch extends RecyclerView.ViewHolder  implements View.OnClickListener  {

    private TextView name;

    public VHListProductSearch(View itemView) {
        super(itemView);
        name            = findView(R.id.name);
        itemView.setOnClickListener(this);
    }

    public void setData(ModelProduct data) {
        name.setText(data.getName());
    }

    private <T extends View> T findView(int id) {
        return (T) itemView.findViewById(id);
    }

    @Override
    public void onClick(View view) {

    }
}
