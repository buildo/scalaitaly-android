package io.buildo.scalaitaly.core;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by andreaascari on 22/04/15.
 */
public class ViewWrapper<V extends View> extends RecyclerView.ViewHolder {

    private V view;

    public ViewWrapper(V itemView) {
        super(itemView);
        view = itemView;
    }

    public V getView() {
        return view;
    }
}
