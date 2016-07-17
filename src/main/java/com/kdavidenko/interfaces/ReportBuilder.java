package com.kdavidenko.interfaces;

public interface ReportBuilder {
    /**
     * Создает объект репорта Report.
     *
     * @param settingPath путь до файла с настройками
     * @param dataPath    путь до файла с данными (UTF-16)
     * @throws Exception
     */
    void build(String settingPath, String dataPath) throws Exception;

    /**
     * Возращает созданный объект репорта.
     *
     * @return созданный объект репорта
     */
    Report getReport();
}
