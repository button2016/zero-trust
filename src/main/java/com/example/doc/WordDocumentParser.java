package com.example.doc;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.io.InputStream;

@Service
public class WordDocumentParser implements DocumentParser{
    @Override
    public Document parse(InputStream input) {
        try (XWPFDocument doc = new XWPFDocument(input)) {
            String content = extractText(doc);
            Metadata metadata = extractMetadata(doc);
            return new Document(content, metadata);
        } catch (Exception e) {
            throw new DocumentParseException("Word文档解析失败", e);
        }
    }

    private Metadata extractMetadata(XWPFDocument doc) {
        return null;
    }

    @Override
    public boolean supports(DocumentType type) {
        return type == DocumentType.WORD;
    }

    private String extractText(XWPFDocument doc) {
        // 实现文本提取逻辑
    }
}
