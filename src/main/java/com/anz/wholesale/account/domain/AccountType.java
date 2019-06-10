package com.anz.wholesale.account.domain;

public enum AccountType {

    CURRENT("Current"),
    SAVING("Saving");

    private final String name;

    AccountType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
