package org.zerock.board.entity;

public enum Status {
    UNDERGRADUATE("학부생"),
    OTHER("기타");

    private final String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Status fromString(String text) {
        for (Status status : Status.values()) {
            if (status.description.equalsIgnoreCase(text)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unexpected value: " + text);
    }
}
