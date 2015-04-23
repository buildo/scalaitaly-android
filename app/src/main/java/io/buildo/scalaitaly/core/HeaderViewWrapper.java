package io.buildo.scalaitaly.core;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by andreaascari on 23/04/15.
 */
public class HeaderViewWrapper<V extends View> extends RecyclerView.ViewHolder {

    private V view;

    public HeaderViewWrapper(V itemView) {
        super(itemView);
        view = itemView;
    }

    public V getView() {
        return view;
    }
}
