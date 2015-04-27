package io.buildo.scalaitaly.fragments;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import io.buildo.scalaitaly.R;
import io.buildo.scalaitaly.adapters.ProgramAdapter;
import io.buildo.scalaitaly.core.InjectedFragment;
import io.buildo.scalaitaly.data.Program;

/**
 * Created by andreaascari on 22/04/15.
 */
@EFragment(R.layout.talks_list_fragment)
public class ProgramListFragment extends InjectedFragment {

    @ViewById(R.id.talksList)
    RecyclerView talksList;

    @Bean
    ProgramAdapter programAdapter;


    @Override
    public void onViewsInjected() {

        programAdapter.init(Program.getProgram());

        talksList.setAdapter(programAdapter);
        talksList.setLayoutManager(new LinearLayoutManager(getActivity()));

    }
}
