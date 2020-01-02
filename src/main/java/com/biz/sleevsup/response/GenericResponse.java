package com.biz.sleevsup.response;

public class GenericResponse {
    private String response;
    private int responseCode;

    public GenericResponse(String response, int responseCode) {
        this.response = response;
        this.responseCode = responseCode;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    @Override
    public String toString() {
        return "GenericResponse{" +
                "response='" + response + '\'' +
                ", responseCode=" + responseCode +
                '}';
    }
}
