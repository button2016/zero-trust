package com.example.doc;

import java.util.Arrays;

public enum DocumentType {
    WORD(".docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document"),
    PDF(".pdf", "application/pdf"),
    TEXT(".txt", "text/plain"),
    EXCEL(".xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

    private final String extension;
    private final String mimeType;

    DocumentType(String extension, String mimeType) {
        this.extension = extension;
        this.mimeType = mimeType;
    }

    // 根据文件扩展名识别类型
    public static DocumentType fromFileName(String filename) {
        String ext = filename.substring(filename.lastIndexOf(".")).toLowerCase();
        return Arrays.stream(values())
                .filter(type -> type.extension.equals(ext))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unsupported file type: " + filename));
    }
}