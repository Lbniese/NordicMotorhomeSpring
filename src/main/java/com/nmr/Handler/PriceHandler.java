package com.nmr.Handler;

import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.DAYS;

public class PriceHandler {
    public static int calculateFullPrice(LocalDateTime rentalStartDate, LocalDateTime rentalEndDate, int pricePerDay){
        long days = DAYS.between(rentalStartDate, rentalEndDate);
        double fullPrice = days * pricePerDay;
        return (int)fullPrice;
    }
}
