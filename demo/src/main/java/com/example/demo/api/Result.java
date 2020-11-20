package com.example.demo.api;

public class Result {
    private String answer;
    private boolean isError;

    public Result(String answer, boolean isError) {
        this.answer = answer;
        this.isError = isError;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isError() {
        return isError;
    }
}
