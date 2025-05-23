package com.example.doc;


import java.io.IOException;
import java.io.InputStream;

public interface DocumentParser {
    Document parse(InputStream input) throws IOException;
    boolean supports(DocumentType type);
}
