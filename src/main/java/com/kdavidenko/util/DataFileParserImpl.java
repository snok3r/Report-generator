package com.kdavidenko.util;

import com.kdavidenko.interfaces.util.DataFileParser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static com.kdavidenko.Setting.DATA_DELIMITER;

public class DataFileParserImpl implements DataFileParser {

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
        for (String line = in.readLine(); line != null; line = in.readLine())
            result.add(splitByDelimiter(line));
        in.close();

        this.result = result;
    }

    private String[] splitByDelimiter(String line) {
        return line.split(String.valueOf(DATA_DELIMITER));
    }

    @Override
    public List<String[]> getResult() {
        return result;
    }
}
