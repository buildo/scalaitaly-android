package io.buildo.scalaitaly.views;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import io.buildo.scalaitaly.R;

/**
 * Created by andreaascari on 27/04/15.
 */
@EViewGroup(R.layout.tag_item_view)
public class TagItemView extends LinearLayout {

    @ViewById(R.id.tagValue)
    TextView tagView;


    public TagItemView(Context context) {
        super(context);
    }

    public void bind(String tag, Integer tagColorResource) {
        tagView.setText(tag);

        GradientDrawable leftDrawable = (GradientDrawable) getResources().getDrawable(R.drawable.tag_circle);
        leftDrawable.setColor(getResources().getColor(tagColorResource));
        tagView.setCompoundDrawablesWithIntrinsicBounds(leftDrawable, null, null, null);
        tagView.setGravity(Gravity.CENTER);
    }
}
