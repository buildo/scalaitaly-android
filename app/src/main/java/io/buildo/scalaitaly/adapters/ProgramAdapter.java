package io.buildo.scalaitaly.adapters;

import android.content.Context;
import android.view.ViewGroup;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.HashMap;

import io.buildo.scalaitaly.core.RecyclerViewAdapterBase;
import io.buildo.scalaitaly.models.Event;
import io.buildo.scalaitaly.views.BreakItemView;
import io.buildo.scalaitaly.views.BreakItemView_;
import io.buildo.scalaitaly.views.ListItemView;
import io.buildo.scalaitaly.views.ListItemView_;

/**
 * Created by andreaascari on 22/04/15.
 */
@EBean
public class ProgramAdapter extends RecyclerViewAdapterBase<BreakItemView, ListItemView> {

    @RootContext
    Context context;

    private HashMap<Integer, Event> mProgram;

    public void init(HashMap<Integer, Event> program) {
        mProgram = program;
    }

    @Override
    public int getItemViewType(int position) {

        if (mProgram.get(position) != null) {
            if (mProgram.get(position).getType() == Event.TALK_TYPE) {
                return RecyclerViewAdapterBase.ITEM_TYPE;
            } else {
                return RecyclerViewAdapterBase.HEADER_TYPE;
            }
        }

        return RecyclerViewAdapterBase.ITEM_TYPE;
    }

    @Override
    protected ListItemView onCreateItemView(ViewGroup parent, int viewType) {
        return ListItemView_.build(context);
    }

    @Override
    protected BreakItemView onCreateHeaderView(ViewGroup parent, int viewType) {
        return BreakItemView_.build(context);
    }

    @Override
    protected void onBindItemViewHolder(ListItemView itemView, int position) {
        boolean showBottomLine = getItemViewType(position + 1) != RecyclerViewAdapterBase.HEADER_TYPE;
        itemView.bind(mProgram.get(position), showBottomLine);
    }

    @Override
    protected void onBindHeaderViewHolder(BreakItemView holder, int position) {
        holder.bind(mProgram.get(position));
    }

    @Override
    public int getItemCount() {
        return mProgram.size();
    }
}
