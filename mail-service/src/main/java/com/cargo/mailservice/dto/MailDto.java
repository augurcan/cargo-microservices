package com.cargo.mailservice.dto;

public class MailDto {
    private UserDto sender;
    private UserDto recipient;

    public MailDto() {
    }

    public MailDto(UserDto sender, UserDto recipient) {
        this.sender = sender;
        this.recipient = recipient;
    }

    public UserDto getSender() {
        return sender;
    }

    public void setSender(UserDto sender) {
        this.sender = sender;
    }

    public UserDto getRecipient() {
        return recipient;
    }

    public void setRecipient(UserDto recipient) {
        this.recipient = recipient;
    }
}
