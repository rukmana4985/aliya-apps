package com.project.aliya.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public class VHEmpty extends RecyclerView.ViewHolder{
    public VHEmpty(View itemView) {
        super(itemView);
    }

    public void setData(){

    }

    private <T extends View> T findView(int id) {
        return (T) itemView.findViewById(id);
    }
}
