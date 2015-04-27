package io.buildo.scalaitaly.fragments;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Space;
import android.widget.TextView;


import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;
import org.apmem.tools.layouts.FlowLayout;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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
import io.buildo.scalaitaly.views.TagItemView;
import io.buildo.scalaitaly.views.TagItemView_;

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

    @ViewById(R.id.header)
    LinearLayout headerLayout;

    @ViewById(R.id.circularImagesOverlay)
    RelativeLayout circularImagesOverlay;

    @ViewById(R.id.topFrame)
    View topFrameView;

    @ViewById(R.id.leftFrame)
    View leftFrameView;

    @ViewById(R.id.rightFrame)
    View rightFrameView;

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
                setHeaderBackgroundColor(talk.getRoom().getRoomColor());
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

            if (talk.hasTags()) {
                tagsContainerLayout.removeAllViews();
                List<Integer> tagsColor = new LinkedList<>(Arrays.asList(
                        R.color.matisse,
                        R.color.red_violet,
                        R.color.vida_loca
                ));
                Collections.shuffle(tagsColor);
                Random rand = new Random();
                for (String tag: talk.getTags()) {
                    int randomIndex = rand.nextInt(tagsColor.size());
                    TagItemView tagItemView = TagItemView_.build(getActivity());
                    tagItemView.bind(tag, tagsColor.get(randomIndex));
                    tagsColor.remove(randomIndex);

                    tagsContainerLayout.addView(tagItemView);
                }
            }

        }

    }

    private void setHeaderBackgroundColor(int roomResourceColor) {
        int roomColor = getResources().getColor(roomResourceColor);
        headerBackgroundLayout.setBackgroundColor(roomColor);
        SemiCircleDrawable semiCircleDrawable  = new SemiCircleDrawable(
                getResources().getColor(android.R.color.transparent),
                roomColor,
                SemiCircleDrawable.Direction.TOP
        );

        headerLayout.setBackgroundColor(roomColor);
        if (Build.VERSION.SDK_INT >= 16) {
            circularImagesCropperView.setBackground(semiCircleDrawable);
        } else {
            circularImagesCropperView.setBackgroundDrawable(semiCircleDrawable);
        }
        topFrameView.setBackgroundColor(roomColor);
        leftFrameView.setBackgroundColor(roomColor);
        rightFrameView.setBackgroundColor(roomColor);
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
