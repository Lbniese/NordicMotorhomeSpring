package com.nmr.Handler;

import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.DAYS;

public class PriceHandler {

    public static double calculateFullPrice(LocalDateTime rentalStartDate, LocalDateTime rentalEndDate, int pricePerDay){
        long days = DAYS.between(rentalStartDate, rentalEndDate);
        double fullPrice = days * pricePerDay;
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
