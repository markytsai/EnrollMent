package com.tjzhic.entity;

public class Message {
    // 消息类型
    private String infoType;

    // 消息内容
    private String infoContent;

    public Message(String infoType, String infoContent) {
        this.infoType = infoType;
        this.infoContent = infoContent;
    }
}
