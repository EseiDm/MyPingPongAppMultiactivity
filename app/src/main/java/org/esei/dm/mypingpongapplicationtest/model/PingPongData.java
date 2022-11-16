package org.esei.dm.mypingpongapplicationtest.model;

import java.io.Serializable;

public class PingPongData implements Serializable {

    private String message="";
    private int count=0;

    public PingPongData(String message){
        this.message = message;
    }

    public void increment(){
        count++;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
