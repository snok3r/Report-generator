package com.kdavidenko.interfaces.util;

import java.nio.charset.Charset;
import java.util.List;

public interface DataFileParser {

    void parse(String fileName, Charset charset) throws Exception;

    void parse(String fileName) throws Exception;

    List<String[]> getResult();
}
