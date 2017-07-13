package com.web.domain.enums;

/**
 * Created by KimYJ on 2017-07-12.
 */
public enum BoardType {
    notice("공지사항"),
    free("자유게시판");

    private String value;

    BoardType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
