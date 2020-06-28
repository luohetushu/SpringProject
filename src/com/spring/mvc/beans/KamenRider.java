package com.spring.mvc.beans;

public class KamenRider {
    HeiseiRider heiseiRider;

    public KamenRider() {
    }

    public KamenRider(HeiseiRider heiseiRider) {
        this.heiseiRider = heiseiRider;
    }

    public HeiseiRider getHeiseiRider() {
        return heiseiRider;
    }

    public void setHeiseiRider(HeiseiRider heiseiRider) {
        this.heiseiRider = heiseiRider;
    }

    public void likes(){
        this.heiseiRider.love();
    }
}
