package io.buildo.scalaitaly.views;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import java.util.HashMap;
import java.util.List;

import io.buildo.scalaitaly.R;
import io.buildo.scalaitaly.models.Event;
import io.buildo.scalaitaly.models.Hour;

/**
 * Created by andreaascari on 23/04/15.
 */
@EViewGroup(R.layout.spare_time_list_item)
public class BreakItemView extends LinearLayout{

    @ViewById(R.id.eventTime)
    TextView eventTimeView;

    @ViewById(R.id.eventTitle)
    TextView eventTitleView;


    public BreakItemView(Context context) {
        super(context);
    }

    public void bind(Event event) {
        if (event.hasHour()) {
            eventTimeView.setText(event.getHour().toFuzzyString());
        }
        if (event.hasBreak())
        eventTitleView.setText(event.getBreak().getTitle());
    }
}
