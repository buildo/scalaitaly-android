package io.buildo.scalaitaly.core;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by andreaascari on 22/04/15.
 */
public abstract class RecyclerViewAdapterBase<H extends View, V extends View> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    protected static final int HEADER_TYPE = 0;
    protected static final int ITEM_TYPE = 1;

    @Override
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch(viewType) {
            case HEADER_TYPE: return new ViewWrapper<H>(onCreateHeaderView(parent, viewType));
            case ITEM_TYPE: return new ViewWrapper<V>(onCreateItemView(parent, viewType));
        }
        return new ViewWrapper<V>(onCreateItemView(parent, viewType));
    }

    protected abstract V onCreateItemView(ViewGroup parent, int viewType);

    protected abstract H onCreateHeaderView(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == HEADER_TYPE) {
            onBindHeaderViewHolder((H) holder.itemView, position);
        } else {
            onBindItemViewHolder((V) holder.itemView, position);
        }
    }

    protected abstract void onBindItemViewHolder(V itemView, int position);


    protected abstract void onBindHeaderViewHolder(H holder, int position);




    // additional methods to manipulate the items
}
