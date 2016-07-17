package com.kdavidenko.interfaces.util;

import java.nio.charset.Charset;
import java.util.List;

public interface DataFileParser {

    /**
     * Парсит файл с данными <tt>fileName</tt> с указанной
     * кодировкой <tt>charset</tt>.
     *
     * @param fileName путь до файла с данными
     * @param charset  кодировка файла <tt>fileName</tt>
     * @throws Exception
     */
    void parse(String fileName, Charset charset) throws Exception;

    /**
     * Парсит файл с данными <tt>fileName</tt>
     * (c кодировкой UTF-16).
     *
     * @param fileName путь до файла с данными (с кодировкой UTF-16)
     * @throws Exception
     */
    void parse(String fileName) throws Exception;

    /**
     * Возвращает лист массивов, где каждый массив
     * это строка без разделительных знаков.
     *
     * @return лист массивов, где каждый массив
     * это строка без разделительных знаков
     */
    List<String[]> getResult();
}
