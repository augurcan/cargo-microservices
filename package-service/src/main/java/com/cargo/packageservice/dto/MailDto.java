package com.cargo.packageservice.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class MailDto {
    @NotNull
    @Valid
    private UserDto sender;
    @NotNull
    @Valid
    private UserDto recipient;

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
