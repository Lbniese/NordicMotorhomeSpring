package com.nmr.handler;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.DAYS;
import static org.junit.jupiter.api.Assertions.*;

class PriceHandlerTest {


    @Test
    void calculateFullPrice() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime fromDate = LocalDateTime.parse("2020-05-05 16:30", formatter);
        LocalDateTime toDate = LocalDateTime.parse("2020-05-20 20:30", formatter);
        int price = 22;
        System.out.print(PriceHandler.calculateFullPrice(fromDate, toDate, price));
        assertEquals(330.0, PriceHandler.calculateFullPrice(fromDate, toDate, price));
    }

    @Test
    void calculateCancellationFee() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime fromDate = LocalDateTime.parse("2020-05-05 16:30", formatter);
        LocalDateTime toDate = LocalDateTime.parse("2020-05-20 20:30", formatter);
        assertEquals(15, DAYS.between(fromDate, toDate));
        assertEquals(15, DAYS.between(toDate, fromDate));
    }
}