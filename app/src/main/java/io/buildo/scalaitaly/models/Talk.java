package io.buildo.scalaitaly.models;

import java.util.ArrayList;
import java.util.Collections;
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
    private List<String> mTags;
    private Room mRoom;
    private int mTalkImage;


    public Talk(String title) {
        mTitle = title;
        mSpeakers = new ArrayList<>();
        mTags = new ArrayList<>();
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

    public void addTags(String... tags) {
        Collections.addAll(mTags, tags);
    }

    public void addRoom(Room room) {
        mRoom = room;
    }

    public boolean hasRoom() {
        return mRoom != null;
    }

    public Room getRoom() {
        return mRoom;
    }

    public boolean hasTags() {
        return mTags != null && mTags.size() > 0;
    }

    public List<String> getTags() {
        return mTags;
    }

    public void setTalkImage(int talkImage) {
        mTalkImage = talkImage;
    }

    public int getImage() {
        if (mTalkImage > 0) {
            return mTalkImage;
        } else if (mSpeakers != null && mSpeakers.size() > 0) {
            Speaker firstSpeaker = mSpeakers.get(0);
            if (firstSpeaker != null && firstSpeaker.hasAvatar()) {
                return firstSpeaker.getAvatar();
            }
        }

        return 0;
    }
}
