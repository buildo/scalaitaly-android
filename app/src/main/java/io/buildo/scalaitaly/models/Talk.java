package io.buildo.scalaitaly.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andreaascari on 22/04/15.
 */
public class Talk {
    private int mId;

    private String mBrief;
    private List<Speaker> mSpeakers;
    private String mTitle;
    private int speakersNames;


    public Talk(String title) {
        mTitle = title;
        mSpeakers = new ArrayList<>();
    }


    public void addSpeaker(Speaker speaker) {
        mSpeakers.add(speaker);
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setBrief(String brief) {
        mBrief = brief;
    }



    public List<Speaker> getSpeakers() {
        return mSpeakers;
    }

    public String getBrief() {
        return mBrief;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public Speaker getSpeaker() {
        return mSpeakers.get(0);
    }

    public boolean hasOneSpeaker() {
        return mSpeakers != null && mSpeakers.size() == 1;
    }

    public boolean hasManySpeakers() {
        return mSpeakers != null && mSpeakers.size() > 1;
    }

    public String getSpeakersNames() {
        String speakersNames = "";
        String nameFormatter = "%1$s";
        String andFormatter = " & %1$s";
        String commaFormatter = ", %1$s";
        for(int i = 0; i < mSpeakers.size(); i++) {
            String currentFormatter;
            if (i == (mSpeakers.size() - 1)) {
                currentFormatter = andFormatter;
            } else if (speakersNames.length() > 0 ){
                currentFormatter = commaFormatter;
            } else {
                currentFormatter = nameFormatter;
            }
            speakersNames = speakersNames.concat(String.format(currentFormatter, mSpeakers.get(i).getDisplayName()));
        }
        return speakersNames;
    }
}
