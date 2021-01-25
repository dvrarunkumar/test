package com.akd.main.controller;

import com.akd.main.model.Status;
import com.akd.main.model.Stock;
import com.akd.main.repository.StockRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.StringReader;

@RestController
public class BasicController {

    @Autowired
    private StockRepository repository;

    @PostMapping(value = "/bulkupload", consumes = "text/csv", produces = "application/json")
    public Status bulkUpload(@RequestBody  String _csv) {
        //repository.deleteAll();//just test

        StockFieldMapper sfm = new StockFieldMapper();
        Stock new_stock;

        try {
            final CSVParser parser = new CSVParser(new StringReader(_csv), CSVFormat.EXCEL.withFirstRecordAsHeader());
            for (final CSVRecord record : parser) {
                new_stock = sfm.mapFieldSet(record);
                repository.save(new_stock);
            }
            return new Status(0, "yayay");

        } catch (IOException e) {
            e.printStackTrace();
            return new Status(-1, e.toString());
        }
    }

/*    @PostMapping(value = "/createStock", consumes = "application/json", produces = "application/json")
    public Stock createStock(@RequestBody Stock _stock) {
//        if(!_stock.isValid())
//            return null;
//        Stock s = repository.save(_stock);
//        repository.findAll().forEach((stock) -> {
//            //logger.info("{}", stock);
//            System.out.println("Stock " + stock);
//        });
//        return s;
        return null;
    }*/

/*    @RequestMapping("/")
    public String hello() {
//        repository.deleteAll();
//
//        repository.save(new Stock("Bratislava", 432000));
//        repository.save(new Stock("Budapest", 1759000));
//        repository.save(new Stock("Prague", 1280000));
//
//        repository.findAll().forEach((stock) -> {
//            //logger.info("{}", stock);
//            System.out.println("Stock " + stock);
//        });

        return "hello";
    }*/
}
