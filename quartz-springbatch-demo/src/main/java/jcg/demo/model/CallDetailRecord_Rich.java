package jcg.demo.model;
 
public class CallDetailRecord_Rich {
 
    private String callerId;
    private String calling;
    private String billingAccount;
 
    public void setCallerId(String callerId) {
        this.callerId = callerId;
    }
 
    public String getCalling() {
        return calling;
    }
 
    public void setCalling(String calling) {
        this.calling = calling;
    }
 
    public String getCallerId() {
        return callerId;
    }
 
    public String getBillingAccount() {
        return billingAccount;
    }
 
    public void setBillingAccount(String billingAccount) {
        this.billingAccount = billingAccount;
    }
 
    @Override
    public String toString() {
        return "CallDetailRecord_Rich [ billingAccount=" + billingAccount + ", callerId=" + callerId + ", calling=" + calling + "]";
    }
}