package com.kdavidenko.interfaces;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public interface Report {

    /**
     * Печатает репорт в консоль.
     */
    void print();

    /**
     * Печатает репорт в указанный файл <tt>file</tt>
     * (с кодировкой UTF-16).
     *
     * @param file файл для сохранения репорта (с кодировкой UTF-16)
     * @throws IOException
     */
    void print(File file) throws IOException;

    /**
     * Печатает репорт в указанный файл <tt>file</tt>
     * с указанной кодировкой <tt>charset</tt>.
     *
     * @param file    файл для сохранения репорта
     * @param charset кодировка файла
     * @throws IOException
     */
    void print(File file, Charset charset) throws IOException;
}
