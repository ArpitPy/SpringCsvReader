package com.arpitpandey.My.Sandbox.controller;

import com.arpitpandey.My.Sandbox.model.DataModel;
import com.arpitpandey.My.Sandbox.service.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CsvController {

    @Autowired
    private CsvService csvService;

    @GetMapping("/data")
    public List<DataModel> getData() {
        return csvService.readCsv();
    }
}
