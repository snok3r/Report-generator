package com.kdavidenko.util;

import com.kdavidenko.interfaces.DataFileParser;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static com.kdavidenko.util.Setting.DATA_DELIMITER;

public class DataParserImpl implements DataFileParser {

    private List<String[]> result;

    @Override
    public void parse(String fileName) throws Exception {
        parse(fileName, Charset.forName("UTF-16"));
    }

    @Override
    public void parse(String fileName, Charset charset) throws Exception {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileName),
                        charset));

        List<String[]> result = new ArrayList<String[]>();
        for (String str = in.readLine(); str != null; str = in.readLine())
            result.add(str.split(String.valueOf(DATA_DELIMITER)));
        in.close();

        this.result = result;
    }

    @Override
    public List<String[]> getResult() {
        return result;
    }
}
