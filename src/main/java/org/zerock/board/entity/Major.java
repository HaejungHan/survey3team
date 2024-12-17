package org.zerock.board.entity;

public enum Major {
    HUMANITIES("인문"),
    SCIENCE("자연과학"),
    ART("예체능");

    private final String description;

    Major(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Major fromString(String text) {
        for (Major major : Major.values()) {
            if (major.description.equalsIgnoreCase(text)) {
                return major;
            }
        }
        throw new IllegalArgumentException("Unexpected value: " + text);
    }
}
