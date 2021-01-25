package com.akd.main.controller;

import com.akd.main.model.Stock;
import org.apache.commons.csv.CSVRecord;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StockFieldMapper {

    public com.akd.main.model.Stock mapFieldSet(CSVRecord record) {

/*
        private enum Industries {
            Healthcare,
            Paints,
            Retail,
            Finance,
            Undefined
        }
*/
        Stock stock = new Stock();
        String str;

        try {
            stock.setStockSymbol(record.get(0));
        } catch (Exception e) {
            stock.setStockSymbol("abc");
        }

        try {
            stock.setCompanyName(record.get(1));
        } catch (Exception e) {
            stock.setCompanyName("abc");
        }

        try {
            stock.setIsinCode(record.get(2));
        } catch (Exception e) {
            stock.setIsinCode("abc");
        }

        final int intVal = Integer.parseInt(record.get(3));
        try {
            stock.setQty(intVal);
        } catch (Exception e) {
            stock.setQty(-1);
        }

        // -----------------------
        float floatVal = Float.parseFloat(record.get(4));
        try {
            stock.setAverageCostPrice(floatVal);
        } catch (Exception e) {
            stock.setAverageCostPrice((float) (-1.0));
        }

        floatVal = Float.parseFloat(record.get(5));
        try {
            stock.setCurrentMarketPrice(floatVal);
        } catch (Exception e) {
            stock.setCurrentMarketPrice((float) (-1.0));
        }

        floatVal = Float.parseFloat(record.get(6));
        try {
            stock.setPercChangeOverPrevClose(floatVal);
        } catch (Exception e) {
            stock.setPercChangeOverPrevClose((float) (-1.0));
        }

        floatVal = Float.parseFloat(record.get(7));
        try {
            stock.setValueAtCost(floatVal);
        } catch (Exception e) {
            stock.setValueAtCost((float) (-1.0));
        }

        floatVal = Float.parseFloat(record.get(8));
        try {
            stock.setValueAtMarketPrice(floatVal);
        } catch (Exception e) {
            stock.setValueAtMarketPrice((float) (-1.0));
        }

        floatVal = Float.parseFloat(record.get(9));
        try {
            stock.setDaysGain(floatVal);
        } catch (Exception e) {
            stock.setDaysGain((float) (-1.0));
        }

        floatVal = Float.parseFloat(record.get(10));
        try {
            stock.setDaysGainPerc(floatVal);
        } catch (Exception e) {
            stock.setDaysGainPerc((float) (-1.0));
        }

        floatVal = Float.parseFloat(record.get(11));
        try {
            stock.setRealizedProfitLoss(floatVal);
        } catch (Exception e) {
            stock.setRealizedProfitLoss((float) (-1.0));
        }

        floatVal = Float.parseFloat(record.get(12));
        try {
            stock.setUnrealizedProfileLoss(floatVal);
        } catch (Exception e) {
            stock.setUnrealizedProfileLoss((float) (-1.0));
        }

        double doubleVal = Float.parseFloat(record.get(13));
        try {
            stock.setUnrealizedProfitLossPerc(doubleVal);
        } catch (Exception e) {
            stock.setUnrealizedProfitLossPerc((double) (-1.0));
        }

        /*Date now = new Date();
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String mysqlDateString = formatter.format(now);
        stock.setDateLoaded(now);*/
        stock.setDateLoaded(new java.sql.Timestamp(new Date().getTime()));

/*        Industries ind = Stock.Industries.Undefined;*/
        String ind = "Undefined";
        if (stock.getStockSymbol().equals("APOHOS")) {
            ind = "Healthcare";
        } else if (stock.getStockSymbol().equals("ASIPAI")) {
            ind = "Paints";
        } else if (stock.getStockSymbol().equals("AVESUP")) {
            ind = "Retail";
        } else if (stock.getStockSymbol().equals("AXIBAN")) {
            ind = "Finance";
        }

        try {
            stock.setIndustry(ind);
        } catch (Exception e) {
            stock.setIndustry("abc");
        }

        return stock;
    }
}
