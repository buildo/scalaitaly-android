package io.buildo.scalaitaly.views;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import io.buildo.scalaitaly.R;
import io.buildo.scalaitaly.TalkDetailActivity_;
import io.buildo.scalaitaly.models.Event;
import io.buildo.scalaitaly.models.Speaker;
import io.buildo.scalaitaly.models.Talk;
import io.buildo.scalaitaly.utils.AssetsUri;

/**
 * Created by andreaascari on 22/04/15.
 */
@EViewGroup(R.layout.talk_list_item)
public class TalkItemView extends LinearLayout {


    @ViewById(R.id.speakerDisplayName)
    TextView speakerDisplayNameView;

    @ViewById(R.id.talkTitle)
    TextView talkTitleView;

    @ViewById(R.id.talkRoom)
    TextView talkRoomView;

    public TalkItemView(Context context) {
        super(context);
    }

    public void bind(final Event event, final Talk talk) {

        talkTitleView.setText(talk.getTitle());

        if (talk.hasOneSpeaker()) {
            speakerDisplayNameView.setText(talk.getSpeaker().getDisplayName());
        } else if (talk.hasManySpeakers()) {
            speakerDisplayNameView.setText(talk.getSpeakersNames());
        }

        if (talk.hasRoom()) {
            talkRoomView.setText(talk.getRoom().getRoomName());
            talkRoomView.setTextColor(getResources().getColor(talk.getRoom().getRoomColor()));
        }


        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                TalkDetailActivity_
                        .intent(getContext())
                        .talkId(talk.getId())
                        .eventId(event.getId())
                        .start();
                ((ActionBarActivity) getContext()).overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });


    }
}
