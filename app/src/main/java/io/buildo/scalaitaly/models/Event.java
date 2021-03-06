package io.buildo.scalaitaly.models;

import java.util.ArrayList;
import java.util.Collections;

import io.buildo.scalaitaly.R;

/**
 * Created by andreaascari on 23/04/15.
 */
public class Event {

    public static final int TALK_TYPE = 0;
    public static final int BREAK_TYPE = 1;

    private Hour mHour;

    private int mId;
    private ArrayList<Talk> mTalks;
    private int mType;
    private int mImage;
    private Break mBreak;

    public Event(int type) {
        mType = type;
        mTalks = new ArrayList<>();
    }

    public void addTalks(Talk... talks) {
        Collections.addAll(mTalks, talks);
    }

    public void setHour(Hour hour) {
        mHour = hour;
    }

    public int getType() {
        return mType;
    }

    public boolean hasHour() {
        return mHour != null;
    }

    public Hour getHour() {
        return mHour;
    }

    public int getImage() {
        if (mTalks != null && mTalks.size() > 0) {
            Talk firstTalk = mTalks.get(0);
            if (firstTalk != null) {
                return firstTalk.getImage();
            }
        }
        return mImage;
    }

    public boolean hasBreak() {
        return mBreak != null;
    }

    public Break getBreak() {
        return mBreak;
    }

    public void setBreak(Break brk) {
        mBreak = brk;
    }

    public ArrayList<Talk> getTalks() {
        return mTalks;
    }


    public void setId(int id) {
        mId = id;
    }

    public int getId() {
        return mId;
    }
}
