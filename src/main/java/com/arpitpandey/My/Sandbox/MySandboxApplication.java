package com.arpitpandey.My.Sandbox;

import com.arpitpandey.My.Sandbox.model.DataModel;
import com.arpitpandey.My.Sandbox.service.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MySandboxApplication implements CommandLineRunner {
    @Autowired
    private CsvService csvService;

    public static void main(String[] args) {
        SpringApplication.run(MySandboxApplication.class, args);
    }

    @Override
    public void run(String... args) {
        List<DataModel> dataModels = csvService.readCsv();
        dataModels.forEach(System.out::println);
    }
}
