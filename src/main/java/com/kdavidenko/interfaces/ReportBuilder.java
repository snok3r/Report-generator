package com.kdavidenko.interfaces;

public interface ReportBuilder {
    /**
     * Создает репорт Report.
     *
     * @param settingPath путь до файла с настройками
     * @param dataPath    путь до файла с данными (UTF-16)
     * @throws Exception
     */
    void build(String settingPath, String dataPath) throws Exception;

    /**
     * Возращает созданный файл репорта.
     *
     * @return созданный файл репорта
     */
    Report getReport();
}
