package io.buildo.scalaitaly;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import io.buildo.scalaitaly.data.Program;
import io.buildo.scalaitaly.data.Talks;

/**
 * Created by andreaascari on 22/04/15.
 */
public class ScalaItalyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Talks.buildTalks();
        Program.buildProgram();
        Fresco.initialize(getApplicationContext());
    }
}
