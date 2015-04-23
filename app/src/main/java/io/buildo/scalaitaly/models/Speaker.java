package io.buildo.scalaitaly.models;

/**
 * Created by andreaascari on 22/04/15.
 */
public class Speaker {
    private String mFirstName;
    private String mLastName;
    private int mAvatarResource;
    private String mBio;
    private String mTwitterUsername;
    private String mCompany;

    public Speaker(String firstName, String lastName) {
        mFirstName = firstName;
        mLastName = lastName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }


    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public int getAvatar() {
        return mAvatarResource;
    }

    public String getDisplayName() {
        return mFirstName.concat(" ").concat(mLastName);
    }

    public void setAvatar(int avatar) {
        mAvatarResource = avatar;
    }

    public String getBio() {
        return mBio;
    }

    public void setBio(String bio) {
        mBio = bio;
    }

    public void setTwitterUserName(String twitterUsername) {
        mTwitterUsername = twitterUsername;
    }

    public void setCompany(String company) {
        mCompany = company;
    }
}
