package com.kdavidenko.interfaces.util;

import java.nio.charset.Charset;
import java.util.List;

public interface Processor {

    /**
     * Сохраняет настройки в класс Setting.
     *
     * @param settingsPath путь до файла настроек
     */
    void processSetting(String settingsPath);

    /**
     * Возвращает массив с наименованием столбцов репорта.
     *
     * @return массив с наименованием стобцов репорта
     */
    String[] getColumnsNames();

    /**
     * Возвращает лист массивов, где каждый массив
     * это строка из файла (с кодировкой UTF-16),
     * но без разделительных знаков.
     *
     * @param dataPath путь до файла с данными
     * @return лист массивов, где каждый массив это строка из файла (с кодировкой UTF-16)
     * без разделительных знаков
     * @throws Exception
     */
    List<String[]> processDataFile(String dataPath) throws Exception;

    /**
     * Возвращает лист массивов, где каждый массив
     * это строка из файла с указаной кодировкой <tt>charset</tt>,
     * но без разделительных знаков.
     *
     * @param dataPath путь до файла с данными
     * @param charset  кодировка файла
     * @return лист массивов, где каждый массив
     * это строка из файла с указаной кодировкой <tt>charset</tt>, без разделительных знаков.
     * @throws Exception
     */
    List<String[]> processDataFile(String dataPath, Charset charset) throws Exception;
}
