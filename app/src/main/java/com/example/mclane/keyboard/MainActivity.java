package com.example.mclane.keyboard;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button aButton, asButton, bButton, cButton, csButton, dButton, dsButton, eButton, fButton, fsButton, gButton, gsButton;
    private Button maryButton, numberPickerPlayButton;
    private MediaPlayer aNote, asNote, bNote, cNote, csNote, dNote, dsNote, fNote, fsNote, eNote, gNote, gsNote;
    private NumberPicker whichNote, numberNote;
    private final int WHOLE_NOTE = 1000;
    private MediaPlayer[] notes;
    private Button[] mary;
    private ConstraintLayout background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        wireWidgets();
        setListener();
        createMediaPlayers();
        wireSongs();

    }

    private void createMediaPlayers() {
        aNote = MediaPlayer.create(this, R.raw.scalea);
        asNote = MediaPlayer.create(this, R.raw.scalebb);
        bNote = MediaPlayer.create(this, R.raw.scaleb);
        cNote = MediaPlayer.create(this, R.raw.scalec);
        csNote = MediaPlayer.create(this, R.raw.scalecs);
        dNote = MediaPlayer.create(this, R.raw.scaled);
        dsNote = MediaPlayer.create(this, R.raw.scaleds);
        eNote = MediaPlayer.create(this, R.raw.scalee);
        fNote = MediaPlayer.create(this, R.raw.scalef);
        fsNote = MediaPlayer.create(this, R.raw.scalefs);
        gNote = MediaPlayer.create(this, R.raw.scaleg);
        gsNote = MediaPlayer.create(this, R.raw.scalegs);
        notes = new MediaPlayer[]{aNote, asNote, bNote, cNote, csNote, dNote, dsNote, fNote, fsNote, eNote, gNote, gsNote};


    }

    private void setListener() {
        aButton.setOnClickListener(this);
        asButton.setOnClickListener(this);
        bButton.setOnClickListener(this);
        cButton.setOnClickListener(this);
        csButton.setOnClickListener(this);
        dButton.setOnClickListener(this);
        dsButton.setOnClickListener(this);
        eButton.setOnClickListener(this);
        fButton.setOnClickListener(this);
        fsButton.setOnClickListener(this);
        gButton.setOnClickListener(this);
        gsButton.setOnClickListener(this);
        maryButton.setOnClickListener(this);
        whichNote.setOnClickListener(this);
        numberNote.setOnClickListener(this);
        numberPickerPlayButton.setOnClickListener(this);
    }

    private void wireWidgets() {
        aButton = (Button) findViewById(R.id.button_a);
        asButton = (Button) findViewById(R.id.button_as);
        bButton = (Button) findViewById(R.id.button_b);
        cButton = (Button) findViewById(R.id.button_c);
        csButton = (Button) findViewById(R.id.button_cs);
        dButton = (Button) findViewById(R.id.button_d);
        dsButton = (Button) findViewById(R.id.button_ds);
        eButton = (Button) findViewById(R.id.button_e);
        fButton = (Button) findViewById(R.id.button_f);
        fsButton = (Button) findViewById(R.id.button_fs);
        gButton = (Button) findViewById(R.id.button_g);
        gsButton = (Button) findViewById(R.id.button_gs);
        maryButton = (Button) findViewById(R.id.button_mary);
        whichNote = (NumberPicker) findViewById(R.id.numberPicker_note);
        whichNote.setMinValue(0);
        whichNote.setMaxValue(11);
        whichNote.setDisplayedValues(new String[]{"A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"});
        numberNote = (NumberPicker) findViewById(R.id.numberPicker_times);
        numberNote.setMinValue(0);
        numberNote.setMaxValue(9);
        numberNote.setDisplayedValues(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"});
        numberPickerPlayButton = (Button) findViewById(R.id.button_picker_play);
        background = (ConstraintLayout) findViewById(R.id.layout);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_a:
                aNote.seekTo(0);
                delayPlaying(WHOLE_NOTE);
                aNote.start();
                break;
            case R.id.button_as:
                asNote.seekTo(0);
                delayPlaying(WHOLE_NOTE);
                asNote.start();
                break;
            case R.id.button_b:
                bNote.seekTo(0);
                delayPlaying(WHOLE_NOTE);
                bNote.start();
                break;
            case R.id.button_c:
                cNote.seekTo(0);
                delayPlaying(WHOLE_NOTE);
                cNote.start();
                break;
            case R.id.button_cs:
                csNote.seekTo(0);
                delayPlaying(WHOLE_NOTE);
                csNote.start();
                break;
            case R.id.button_d:
                dNote.seekTo(0);
                delayPlaying(WHOLE_NOTE);
                dNote.start();
                break;
            case R.id.button_ds:
                dsNote.seekTo(0);
                delayPlaying(WHOLE_NOTE);
                dsNote.start();
                break;
            case R.id.button_e:
                eNote.seekTo(0);
                delayPlaying(WHOLE_NOTE);
                eNote.start();
                break;
            case R.id.button_f:
                fNote.seekTo(0);
                delayPlaying(WHOLE_NOTE);
                fNote.start();
                break;
            case R.id.button_fs:
                fsNote.seekTo(0);
                delayPlaying(WHOLE_NOTE);
                fsNote.start();
                break;
            case R.id.button_g:
                gNote.seekTo(0);
                delayPlaying(WHOLE_NOTE);
                gNote.start();
                break;
            case R.id.button_gs:
                gsNote.seekTo(0);
                delayPlaying(WHOLE_NOTE);
                gsNote.start();
                break;
            case R.id.button_mary:
                mary();
                break;
            case R.id.button_picker_play:
                new Thread(new Runnable() {
                    private void delayPlaying(int delay) {
                        try {
                            Thread.sleep(delay);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    public void run() {
                        for (int i = 0; i < numberNote.getValue() + 1; i++) {
                            notes[whichNote.getValue()].seekTo(0);
                            notes[whichNote.getValue()].start();
                            delayPlaying(WHOLE_NOTE);
                        }
                    }
                }).start();

        }
    }


    private void delayPlaying(int delay) {
        CountDownTimer noteLength = new CountDownTimer(delay, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {

            }
        };
        noteLength.start();
    }

    //plays mary has a little lamb
    private void mary() {
        maryButton.setEnabled(false);
        new Thread(new Runnable() {
            private void delayPlaying(int delay) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            public void run() {
                for (Button j : mary) {
                    j.performClick();
                    delayPlaying((int) (WHOLE_NOTE / 2.5));
                }
            }
        }).start();
        delayPlayingMary(10750);
    }

    private void delayPlayingMary(int i) {
        CountDownTimer noteLength = new CountDownTimer(i, 1075) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                maryButton.setEnabled(true);
            }
        };
        noteLength.start();
    }

    private void wireSongs() {
        mary = new Button[]{eButton, dButton, cButton, dButton, eButton, eButton, eButton, dButton, dButton, dButton, eButton,
                gButton, gButton, eButton, dButton, cButton, dButton, eButton, eButton, eButton, eButton, dButton, dButton, eButton,
                dButton, cButton};
    }

}
