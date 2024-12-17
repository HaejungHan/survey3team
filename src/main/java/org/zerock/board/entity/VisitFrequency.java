package org.zerock.board.entity;


public enum VisitFrequency {
    DAILY("매일"),
    WEEKLY("주 1-3회"),
    MONTHLY("월 1-3회"),
    SEMESTERLY("학기 1-3회"),
    YEARLY("연 1-3회"),
    NEVER("이용하지 않는다");

    private final String description;

    // 생성자
    VisitFrequency(String description) {
        this.description = description;
    }

    // 각 항목에 대한 설명 반환
    public String getDescription() {
        return description;
    }

    // 문자열로부터 Enum 항목을 얻는 메소드
    public static VisitFrequency fromString(String text) {
        for (VisitFrequency frequency : VisitFrequency.values()) {
            if (frequency.description.equalsIgnoreCase(text)) {
                return frequency;
            }
        }
        throw new IllegalArgumentException("Unexpected value: " + text);
    }
}

