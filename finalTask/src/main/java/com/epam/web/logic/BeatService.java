package com.epam.web.logic;

import com.epam.web.model.Beat;

import java.util.ArrayList;

public class BeatService {
    private ArrayList<Beat> beats = new ArrayList<>();

    public BeatService(ArrayList<Beat> beats) {
        this.beats = beats;
    }

    public void addBook(Beat beat) {
        beats.add(beat);
    }

    public ArrayList<Beat> getAll() {
        return new ArrayList<>(beats);
    }
}
