package io.buildo.scalaitaly.models;

/**
 * Created by andreaascari on 23/04/15.
 */
public class Hour {


    private final String mMinute;
    private final String mHour;

    public Hour(String hour, String minute) {
        mHour = hour;
        mMinute = minute;
    }

    public String toFuzzyString() {
        return String.format("%1$s.%2$s", mHour, mMinute);
    }
}
