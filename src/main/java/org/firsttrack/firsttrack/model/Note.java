package org.firsttrack.firsttrack.model;

public class Note {
    private String[] questions;
    private String[] responses;

    public Note(String[] questions, String[] responses) {
        this.questions = questions;
        this.responses = responses;
    }

    public String[] getQuestions() {
        return questions;
    }

    public void setQuestions(String[] questions) {
        this.questions = questions;
    }

    public String[] getResponses() {
        return responses;
    }

    public void setResponses(String[] responses) {
        this.responses = responses;
    }

    public String toFormattedString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < questions.length; i++) {
            sb.append(questions[i]).append(": ").append(responses[i]).append("\n");
        }
        return sb.toString();
    }

    public void clear() {
        for(int i = 0; i < responses.length; i++) {
            responses[i] = "";
        }
    }
}
