package com.example.master_study.persistance.enums;

public enum Districts {
    CENTRAL("Центральный"),
    NORTHERN("Северный"),
    NORTHEAST("Северо-Восточный"),
    EAST("Восточный"),
    SOUTHEAST("Юго-Восточный"),
    SOUTH("Южный"),
    SOUTHWEST("Юго-Западный"),
    WEST("Западный"),
    NORTHWEST("Северо-Западный"),
    ZELAO("Зеленоградский"),
    TAO("Троицкий"),
    NAO("Новомосковский");

    private String values;

    Districts(String values) {
        this.values = values;
    }
}
