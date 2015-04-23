package io.buildo.scalaitaly;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Window;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.WindowFeature;

import io.buildo.scalaitaly.fragments.ProgramListFragment_;


/**
 * Created by andreaascari on 22/04/15.
 */
@EActivity(R.layout.activity_main)
@WindowFeature(Window.FEATURE_ACTION_BAR)
public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getString(R.string.program));
            getSupportActionBar().setWindowTitle(getString(R.string.program));
            getSupportActionBar().setDisplayShowCustomEnabled(true);
            getSupportActionBar().show();
        }

        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.listFragmentContainer, ProgramListFragment_.builder().build())
                .commitAllowingStateLoss()
        ;

    }



}
