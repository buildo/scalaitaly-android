package io.buildo.scalaitaly.fragments;

import android.graphics.drawable.ShapeDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Space;
import android.widget.TextView;

import com.wefika.flowlayout.FlowLayout;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;

import io.buildo.scalaitaly.R;
import io.buildo.scalaitaly.core.InjectedFragment;
import io.buildo.scalaitaly.core.SemiCircleDrawable;
import io.buildo.scalaitaly.data.Program;
import io.buildo.scalaitaly.data.Talks;
import io.buildo.scalaitaly.models.Event;
import io.buildo.scalaitaly.models.Hour;
import io.buildo.scalaitaly.models.Speaker;
import io.buildo.scalaitaly.models.Talk;
import io.buildo.scalaitaly.views.SpeakerBioView;
import io.buildo.scalaitaly.views.SpeakerBioView_;

/**
 * Created by andreaascari on 22/04/15.
 */
@EFragment(R.layout.talk_detail_fragment)
public class TalkDetailFragment extends InjectedFragment {

    @FragmentArg
    int eventId;

    @FragmentArg
    int talkId;


    @ViewById(R.id.headerBackground)
    RelativeLayout headerBackgroundLayout;

    @ViewById(R.id.circularImagesOverlay)
    RelativeLayout circularImagesOverlay;

    @ViewById(R.id.circularImagesCropper)
    View circularImagesCropperView;


    @ViewById(R.id.talkStartTime)
    TextView talkStartTimeView;

    @ViewById(R.id.speakerDisplayName)
    TextView speakerDisplayNameView;

    @ViewById(R.id.talkTitle)
    TextView talkTitle;

    @ViewById(R.id.talkRoom)
    TextView talkRoomView;

    @ViewById(R.id.headerSpace)
    Space headerSpaceVie;

    @ViewById(R.id.scrollContentContainer)
    ScrollView scrollContentContainer;

    @ViewById(R.id.talkBrief)
    TextView talkBriefView;

    @ViewById(R.id.tagsContainer)
    FlowLayout tagsContainerLayout;

    @ViewById(R.id.speakersBioContainer)
    LinearLayout speakersBioContainer;




    public void onViewsInjected() {

        final View.OnLayoutChangeListener headerLayoutChangeListener = new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                if (headerBackgroundLayout.getHeight() > 0) {
                    headerSpaceVie.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, headerBackgroundLayout.getHeight()));

                }
            }
        };

        headerBackgroundLayout.addOnLayoutChangeListener(headerLayoutChangeListener);

        SemiCircleDrawable semiCircleDrawable  = new SemiCircleDrawable(
                getResources().getColor(android.R.color.transparent),
                getResources().getColor(R.color.eastern_blue),
                SemiCircleDrawable.Direction.TOP
        );
        if (Build.VERSION.SDK_INT >= 16) {
            circularImagesCropperView.setBackground(semiCircleDrawable);
        } else {
            circularImagesCropperView.setBackgroundDrawable(semiCircleDrawable);
        }

        Event event = Program.getEventById(eventId);
        Talk talk = Talks.get(talkId);



        if (event != null) {
            Hour eventHour = event.getHour();
            talkStartTimeView.setText(eventHour.toFuzzyString());
        }

        if (talk != null) {
            talkTitle.setText(talk.getTitle());
            if (talk.hasRoom()) {
                talkRoomView.setText(talk.getRoom().getRoomName());
                talkRoomView.setTextColor(getResources().getColor(talk.getRoom().getRoomColor()));
            }
            if (talk.hasOneSpeaker()) {
                speakerDisplayNameView.setText(talk.getSpeaker().getDisplayName());
            } else if (talk.hasManySpeakers()) {
                speakerDisplayNameView.setText(talk.getSpeakersNames());
            }

            talkBriefView.setText(talk.getBrief());

            for (Speaker speaker : talk.getSpeakers()) {
                SpeakerBioView speakerBioView = SpeakerBioView_.build(getActivity());
                speakerBioView.bind(speaker);
                speakersBioContainer.addView(speakerBioView);
            }

        }

    }

    @Override
    public void onDestroyView() {
        headerBackgroundLayout = null;
        circularImagesOverlay = null;
        circularImagesCropperView = null;
        talkStartTimeView = null;
        speakerDisplayNameView = null;
        talkTitle = null;
        headerSpaceVie = null;
        scrollContentContainer = null;
        talkBriefView = null;
        tagsContainerLayout = null;
        speakersBioContainer = null;
        super.onDestroyView();

    }
}
