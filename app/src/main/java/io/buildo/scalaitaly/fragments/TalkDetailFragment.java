package io.buildo.scalaitaly.fragments;

import android.net.Uri;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;


import io.buildo.scalaitaly.R;
import io.buildo.scalaitaly.core.InjectedFragment;
import io.buildo.scalaitaly.data.Talks;
import io.buildo.scalaitaly.models.Speaker;
import io.buildo.scalaitaly.models.Talk;
import io.buildo.scalaitaly.utils.AssetsUri;
import io.buildo.scalaitaly.views.SpeakerBioView;
import io.buildo.scalaitaly.views.SpeakerBioView_;

/**
 * Created by andreaascari on 22/04/15.
 */
@EFragment(R.layout.talk_detail_fragment)
public class TalkDetailFragment extends InjectedFragment {

    @FragmentArg
    int talkId;


    @ViewById(R.id.talkStartTime)
    TextView talkStartTimeView;

    @ViewById(R.id.speakerDisplayName)
    TextView speakerDisplayNameView;

    @ViewById(R.id.talkTitle)
    TextView talkTitle;

    @ViewById(R.id.talkBrief)
    TextView talkBriefView;

    @ViewById(R.id.speakersBioContainer)
    LinearLayout speakersBioContainer;




    public void onViewsInjected() {
        Talk talk = Talks.get(talkId);

        speakerDisplayNameView.setText(talk.getSpeakers().get(0).getDisplayName());

        talkTitle.setText(talk.getTitle());

        talkBriefView.setText(talk.getBrief());

        for (Speaker speaker : talk.getSpeakers()) {
            SpeakerBioView speakerBioView = SpeakerBioView_.build(getActivity());
            speakerBioView.bind(speaker);
            speakersBioContainer.addView(speakerBioView);
        }


    }
}
