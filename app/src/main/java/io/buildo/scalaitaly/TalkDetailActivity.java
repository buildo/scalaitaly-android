package io.buildo.scalaitaly;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Window;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.WindowFeature;

import io.buildo.scalaitaly.fragments.TalkDetailFragment;
import io.buildo.scalaitaly.fragments.TalkDetailFragment_;

/**
 * Created by andreaascari on 22/04/15.
 */
@EActivity(R.layout.activity_talk_detail)
@WindowFeature(Window.FEATURE_ACTION_BAR)
public class TalkDetailActivity extends ActionBarActivity {

    private TalkDetailFragment mTalkDetailFragment;

    @Extra
    int eventId;
    @Extra
    int talkId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.detail_talk);
        }

        mTalkDetailFragment = TalkDetailFragment_.builder()
                .eventId(eventId)
                .talkId(talkId)
                .build();


        getSupportFragmentManager()
                .beginTransaction()
                .add(
                        R.id.talkDetailContainer,
                        mTalkDetailFragment
                )
                .commitAllowingStateLoss();
    }

    @OptionsItem(android.R.id.home)
    boolean onHomeClick() {
        finish();
        overridePendingTransition(R.anim.slide_back_in, R.anim.slide_back_out);
        return true;
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_back_in, R.anim.slide_back_out);
    }

    @Override
    protected void onDestroy() {
        getSupportFragmentManager()
                .beginTransaction()
                .detach(mTalkDetailFragment)
                .remove(mTalkDetailFragment)
                .commitAllowingStateLoss();
        mTalkDetailFragment = null;
        System.gc();
        super.onDestroy();
    }
}
