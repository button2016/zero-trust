package com.example.doc;


import lombok.Data;

import java.time.LocalDateTime;

@Data
// 元数据类示例
public class Metadata {
    private String author;
    private LocalDateTime createTime;
    private DocumentType type;

    // 构造方法和Getter/Setter
}