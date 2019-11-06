package com.chenmin.queue;

public enum QueueKeyEnum {
    BROADCAST("BROADCAST","广播形式"),MAIL("MAIL","邮件形式");
    private String key;
    private String text;

    QueueKeyEnum(String key, String text) {
        this.key = key;
        this.text = text;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
