package io.buildo.scalaitaly.views;

import android.content.Context;
import android.net.Uri;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import io.buildo.scalaitaly.R;
import io.buildo.scalaitaly.models.Speaker;
import io.buildo.scalaitaly.utils.AssetsUri;

/**
 * Created by andreaascari on 23/04/15.
 */
@EViewGroup(R.layout.speaker_bio)
public class SpeakerBioView extends RelativeLayout {

    @ViewById(R.id.speakerImage)
    SimpleDraweeView speakerImageView;

    @ViewById(R.id.speakerDisplayNameBio)
    TextView speakerDisplayNameBio;

    @ViewById(R.id.speakerBio)
    TextView speakerBioView;


    public SpeakerBioView(Context context) {
        super(context);
    }

    public void bind(Speaker speaker) {
        speakerImageView.setImageURI(Uri.parse(AssetsUri.getAssetsUri(speaker.getAvatar())));
        speakerDisplayNameBio.setText(speaker.getDisplayName());
        speakerBioView.setText(speaker.getBio());

    }
}
