package com.project.aliya.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.project.aliya.R;

public class VHLoad extends RecyclerView.ViewHolder{
    private ProgressBar progressBar;

    public VHLoad(View itemView) {
        super(itemView);
        progressBar = findView(R.id.load);
    }

    public void setData() {
    }

    private <T extends View> T findView(int id) {
        return (T) itemView.findViewById(id);
    }
}
