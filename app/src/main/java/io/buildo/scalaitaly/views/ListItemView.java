package io.buildo.scalaitaly.views;

import android.content.Context;
import android.net.Uri;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import io.buildo.scalaitaly.R;
import io.buildo.scalaitaly.models.Event;
import io.buildo.scalaitaly.models.Talk;
import io.buildo.scalaitaly.utils.AssetsUri;

/**
 * Created by andreaascari on 23/04/15.
 */
@EViewGroup(R.layout.list_item)
public class ListItemView extends LinearLayout {

    @ViewById(R.id.talkImage)
    SimpleDraweeView talkImage;

    @ViewById(R.id.talkTime)
    TextView talkTime;

    @ViewById(R.id.talksContainer)
    LinearLayout talksContainerLayout;


    public ListItemView(Context context) {
        super(context);
    }

    public void bind(Event event) {
        GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(getResources());
        RoundingParams roundingParams = new RoundingParams()
                .setRoundAsCircle(true)
                .setOverlayColor(getResources().getColor(android.R.color.white))
                ;

        GenericDraweeHierarchy hierarchy = builder
                .setFadeDuration(300)
                .setOverlay(getResources().getDrawable(R.color.black73pc))
                .setRoundingParams(roundingParams)
                .build();

        talkImage.setHierarchy(hierarchy);
        talkImage.setImageURI(Uri.parse(AssetsUri.getAssetsUri(event.getImage())));

        if (event.hasHour()) {
            talkTime.setText(event.getHour().toFuzzyString());
        }


        talksContainerLayout.removeAllViews();

        for(Talk talk: event.getTalks()) {
            TalkItemView talkItemView = TalkItemView_.build(getContext());
            talkItemView.bind(event, talk);
            talksContainerLayout.addView(talkItemView);

        }
    }

}
