package io.buildo.scalaitaly.core;

import android.support.v4.app.Fragment;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

/**
 * Created by andreaascari on 22/04/15.
 */
@EFragment
public abstract class InjectedFragment extends Fragment {


    @AfterViews
    public abstract void onViewsInjected();



}
