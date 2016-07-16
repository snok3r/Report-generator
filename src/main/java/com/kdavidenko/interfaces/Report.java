package com.kdavidenko.interfaces;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public interface Report {

    void print();

    void print(File file) throws IOException;

    void print(File file, Charset charset) throws IOException;
}
