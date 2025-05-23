package com.example.doc;

import java.time.LocalDateTime;

// 自定义文档模型（项目自有代码，无需额外依赖）
public class Document {
    private final String content;   // 文档纯文本内容
    private final Metadata metadata; // 文档元数据（作者、创建时间等）

    public Document(String content, Metadata metadata) {
        this.content = content;
        this.metadata = metadata;
    }

    // Getter方法
    public String getContent() {
        return content;
    }

    public Metadata getMetadata() {
        return metadata;
    }
}
