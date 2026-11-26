package com.halukkilincer.adventure.items;

import java.util.Arrays;
import java.util.Optional;

public enum MissionItem {
    ACCESS_KEY("Access Key"),
    DATA_CRYSTAL("Data Crystal"),
    CORE_CIPHER("Core Cipher");

    private final String label;

    MissionItem(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static Optional<MissionItem> fromLabel(String label) {
        return Arrays.stream(values())
                .filter(item -> item.label.equals(label))
                .findFirst();
    }
}
