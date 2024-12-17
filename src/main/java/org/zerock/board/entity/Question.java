package org.zerock.board.entity;

public enum Question {
    도서관_사용빈도("도서관 사용 빈도");
//    도서관_이용시_사서에게_도움을_요쳥하지_않는_이유("도서관 이용시 사세ㅓ에게");

    private final String label;

    Question(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }

    // 문자열 라벨을 받아 해당 enum 항목을 반환하는 메서드
    public static Question fromLabel(String label) {
        for (Question q : values()) {
            if (q.label.equals(label)) {
                return q;
            }
        }
        throw new IllegalArgumentException("Unknown label: " + label);
    }
}
