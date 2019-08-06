package jcg.demo.model;

public class CallDetailRecord_Simple {

    private String callerId;
    private String calling;

    public String getCallerId() {
        return callerId;
    }

    public String getCalling() {
        return calling;
    }

    public void setCalling(String calling) {
        this.calling = calling;
    }

    public void setCallerId(String callerId) {
        this.callerId = callerId;
    }

    @Override
    public String toString() {
        return "CallDetailRecord_Simple [callerId=" + callerId + ", calling=" + calling + "]";
    }
}
