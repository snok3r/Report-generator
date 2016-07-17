package com.kdavidenko;

import com.kdavidenko.interfaces.*;
import com.kdavidenko.implementations.*;

import java.io.File;

public class Generator {
    public static void main(String[] args) throws Exception {

        if (args.length < 3) {
            System.err.println("Not enough arguments: " + args.length + " (needed 3)");
            return;
        }

        ReportBuilder reportBuilder = new ReportBuilderImpl();
        reportBuilder.build(args[0], args[1]);

        Report report = reportBuilder.getReport();
        report.print();

//        report.print(new File(args[2]));
//        System.out.println("Отчёт успешно сохранён в файл '" + args[2] + "'");
    }
}
