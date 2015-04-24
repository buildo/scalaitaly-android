package io.buildo.scalaitaly.models;

import io.buildo.scalaitaly.R;

/**
 * Created by andreaascari on 24/04/15.
 */
public class Room {

    public static final int ROOM_A = 0;
    public static final int ROOM_B = 1;
    public static final int PLENARY = 2;
    private final int mType;

    public Room(int roomType) {
        mType = roomType;
    }

    public String getRoomName() {
        String roomName;
        switch (mType) {
            case ROOM_A:
                roomName = "Room A";
                break;
            case ROOM_B:
                roomName = "Room B";
                break;
            case PLENARY:
            default:
                roomName = "Plenary";
        }
        return roomName;
    }

    public int getRoomColor() {
        int colorResource;
        switch (mType) {
            case ROOM_A:
                colorResource = R.color.mountain_meadow;
                break;
            case ROOM_B:
                colorResource = R.color.saffron;
                break;
            case PLENARY:
            default:
                colorResource = R.color.eastern_blue;
        }

        return colorResource;
    }
}
