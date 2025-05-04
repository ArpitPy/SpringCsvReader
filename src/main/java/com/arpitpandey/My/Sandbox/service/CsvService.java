package com.arpitpandey.My.Sandbox.service;

import com.arpitpandey.My.Sandbox.exception.CsvException;
import com.arpitpandey.My.Sandbox.model.DataModel;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvService {

    private static final String CSV_FILE_PATH = "/data.csv";

    public List<DataModel> readCsv() {
        List<DataModel> dataModels = new ArrayList<>();

        CsvParserSettings settings = new CsvParserSettings();
        settings.setSkipEmptyLines(true);
        settings.setHeaderExtractionEnabled(true);

        CsvParser parser = new CsvParser(settings);

        try (InputStream inputStream = getClass().getResourceAsStream(CSV_FILE_PATH);
             InputStreamReader reader = new InputStreamReader(inputStream)) {

            List<String[]> allRows = parser.parseAll(reader);

            for (String[] row : allRows) {
                try {
                    String name = row[0];
                    String city = row[1];
                    int age = Integer.parseInt(row[2]);
                    dataModels.add(new DataModel(name, city, age));
                } catch (Exception e) {
                    throw new CsvException("Error parsing row: " + String.join(",", row), e);
                }
            }

        } catch (Exception e) {
            throw new CsvException("Error reading the CSV file", e);
        }

        return dataModels;
    }
}
