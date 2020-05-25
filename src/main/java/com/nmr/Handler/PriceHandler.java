package com.nmr.Handler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.DAYS;

public class PriceHandler {

    public static double calculateFullPrice(LocalDateTime rentalStartDate, LocalDateTime rentalEndDate, int pricePerDay){
        long days = DAYS.between(rentalStartDate, rentalEndDate);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        LocalDateTime peakSeasonStartDate = LocalDateTime.parse("2020-06-01 00:00", formatter);
        LocalDateTime peakSeasonEndDate = LocalDateTime.parse("2020-08-31 00:00",formatter);

        LocalDateTime midSeasonStartDate = LocalDateTime.parse("2021-03-01 00:00", formatter);
        LocalDateTime midSeasonEndDate = LocalDateTime.parse("2021-05-31 00:00", formatter);

        LocalDateTime lowSeasonStartDate = LocalDateTime.parse("2020-09-01 00:00", formatter);
        LocalDateTime lowSeasonEndDate = LocalDateTime.parse("2021-02-29 00:00", formatter);

        double fullPrice = 0;

        if(!rentalStartDate.isBefore(peakSeasonStartDate) && !rentalEndDate.isAfter(peakSeasonEndDate)){
            fullPrice = days * (pricePerDay * 1.6);
        }
        if(!rentalStartDate.isBefore(midSeasonStartDate) && !rentalEndDate.isAfter(midSeasonEndDate)){
            fullPrice = days * (pricePerDay * 1.3);
        }
        if(!rentalStartDate.isBefore(lowSeasonStartDate) && !rentalEndDate.isAfter(lowSeasonEndDate)){
            fullPrice = days * (pricePerDay * 1.0);
        }
        return fullPrice;
    }

    public static double calculatePickUpPrice(String pickUpPoint){
        double pickUpPrice = 0;
        int pickUpKm = 0;
        if(pickUpPoint.equals("Airport")){
            pickUpKm = 12;
        }
        if(pickUpPoint.equals("NMR - Headquarters")){
            pickUpKm = 0;
        }
        if(pickUpPoint.equals("Copenhagen Central Station")){
            pickUpKm = 5;
        }
        pickUpPrice = pickUpKm * 5;
        return pickUpPrice;
    }

    public static double calculateDropOffPrice(String dropOffPoint){
        double dropOffPrice = 0;
        int dropOffKm = 0;
        if(dropOffPoint.equals("Airport")){
            dropOffKm = 12;
        }
        if(dropOffPoint.equals("NMR - Headquarters")){
            dropOffKm = 0;
        }
        if(dropOffPoint.equals("Copenhagen Central Station")){
            dropOffKm = 5;
        }
        dropOffPrice = dropOffKm * 5;
        return dropOffPrice;
    }
}
