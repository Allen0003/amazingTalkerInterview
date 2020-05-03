package com.interview.register.enums;

public enum SourceEnum {
    Facebook("facebook"),
    Google("google"),
    None("none");

    private String soruce;

    SourceEnum(String soruce) {
        this.soruce = soruce;
    }

    public String getSource() {
        return this.soruce;
    }
    public void setSoruce(String soruce) {
        this.soruce = soruce;
    }
}
