package com.example.master_study.persistance.enums;

public enum orderStatus {
    NEW ("Новый"),
    ASSIGNED("Назначен"),
    COMPLETE ("Завершен");
    private String value;

    orderStatus(String value) {
        this.value = value;
    }
}
