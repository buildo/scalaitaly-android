package io.buildo.scalaitaly.utils;

import java.util.HashMap;

import io.buildo.scalaitaly.models.Break;
import io.buildo.scalaitaly.models.Event;
import io.buildo.scalaitaly.models.Hour;

/**
 * Created by andreaascari on 23/04/15.
 */
public class Program {
    static HashMap<Integer, Event> mProgram;
    public static void buildProgram() {
        mProgram = new HashMap<>();


        Event martinOderskyTalkEvent = new Event(Event.TALK_TYPE);
        martinOderskyTalkEvent.setHour(new Hour("9", "30"));
        martinOderskyTalkEvent.addTalks(Talks.get(1));

        addEvent(martinOderskyTalkEvent);

        Event morningBreakEvent = new Event(Event.BREAK_TYPE);
        morningBreakEvent.setHour(new Hour("10", "20"));
        Break morningBreak = new Break();
        morningBreak.setTitle("Break");
        morningBreakEvent.setBreak(morningBreak);

        addEvent(morningBreakEvent);


        Event philCalcadoTalkEvent = new Event(Event.TALK_TYPE);
        philCalcadoTalkEvent.setHour(new Hour("10", "40"));
        philCalcadoTalkEvent.addTalks(Talks.get(2));

        addEvent(philCalcadoTalkEvent);

        Event jonPrettyTalkEvent = new Event(Event.TALK_TYPE);
        jonPrettyTalkEvent.setHour(new Hour("11", "30"));
        jonPrettyTalkEvent.addTalks(Talks.get(3));

        addEvent(jonPrettyTalkEvent);


        Event lunchEvent = new Event(Event.BREAK_TYPE);
        lunchEvent.setHour(new Hour("12", "20"));
        Break lunchBreak = new Break();
        lunchBreak.setTitle("Lunch");
        lunchEvent.setBreak(lunchBreak);

        addEvent(lunchEvent);

        Event dottaSfregolaTalksEvent = new Event(Event.TALK_TYPE);
        dottaSfregolaTalksEvent.setHour(new Hour("14", "00"));
        dottaSfregolaTalksEvent.addTalks(Talks.get(4), Talks.get(5));

        addEvent(dottaSfregolaTalksEvent);

        Event ferrettiForeldiTalksEvent = new Event(Event.TALK_TYPE);
        ferrettiForeldiTalksEvent.setHour(new Hour("14", "50"));
        ferrettiForeldiTalksEvent.addTalks(Talks.get(6), Talks.get(7));

        addEvent(ferrettiForeldiTalksEvent);

        Event coffeBreakEvent = new Event(Event.BREAK_TYPE);
        coffeBreakEvent.setHour(new Hour("15", "40"));
        Break coffeBreak = new Break();
        coffeBreak.setTitle("Coffee Break");
        coffeBreakEvent.setBreak(coffeBreak);

        addEvent(coffeBreakEvent);

        Event databizBuildoTalksEvent = new Event(Event.TALK_TYPE);
        databizBuildoTalksEvent.setHour(new Hour("16", "00"));
        databizBuildoTalksEvent.addTalks(Talks.get(8), Talks.get(9));

        addEvent(databizBuildoTalksEvent);

        Event paroAbbruzzettiTalksEvent = new Event(Event.TALK_TYPE);
        paroAbbruzzettiTalksEvent.setHour(new Hour("16", "50"));
        paroAbbruzzettiTalksEvent.addTalks(Talks.get(10), Talks.get(11));

        addEvent(paroAbbruzzettiTalksEvent);


    }

    public static HashMap<Integer, Event> getProgram() {
        return mProgram;
    }


    public static void addEvent(Event event) {
        int eventId = mProgram.size() + 1;
        event.setId(eventId);
        mProgram.put(mProgram.size(), event);


    }

    public static Event getEventById(int id) {
        for(Event event: mProgram.values()) {
            if (event.getId() == id) {
                return event;
            }
        }
        return null;
    }
}
