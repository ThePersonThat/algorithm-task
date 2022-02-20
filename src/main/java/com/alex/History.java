package com.alex;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class History {
    private List<Story> historyList;

    public History() {
        historyList = new ArrayList<>();
    }

    public void addStory(Story story) {
        historyList.add(story);
    }

    public List<Story> getHistoryList() {
        return historyList;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Story story : historyList) {
            builder.append(story).append(System.lineSeparator());
        }

        return builder.toString();
    }

    public static class Story {
        private int value;
        private Coord position;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Story story = (Story) o;
            return  Objects.equals(position, story.position);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, position);
        }

        public Story(int value, Coord position) {
            this.value = value;
            this.position = position;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Coord getPosition() {
            return position;
        }

        public void setPosition(Coord position) {
            this.position = position;
        }

        @Override
        public String toString() {
            return "Value: " + value + " " + " Position: " + position;
        }
    }
}
