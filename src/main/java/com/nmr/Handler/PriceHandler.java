package com.nmr.Handler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class PriceHandler {

    public static double calculateFullPrice(LocalDateTime rentalStartDate, LocalDateTime rentalEndDate, int pricePerDay){

        double fullPrice = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime peakSeasonStartDate = LocalDateTime.parse("2020-06-01 00:00", formatter);
        LocalDateTime peakSeasonEndDate = LocalDateTime.parse("2020-08-31 23:59", formatter);

        LocalDateTime midSeasonStartDate = LocalDateTime.parse("2020-03-01 00:00", formatter);
        LocalDateTime midSeasonEndDate = LocalDateTime.parse("2020-05-31 23:59", formatter);
        
        LocalDateTime currentDate = rentalStartDate;
        boolean addPrice = false;

        while(currentDate.isBefore(rentalEndDate) || currentDate.isEqual(rentalEndDate)){
            if(currentDate.getMonthValue() >= peakSeasonStartDate.getMonthValue() && currentDate.getMonthValue() <= peakSeasonEndDate.getMonthValue()){
                addPrice = true;
                if(currentDate.getMonthValue() == peakSeasonStartDate.getMonthValue() && currentDate.getDayOfMonth() < peakSeasonStartDate.getDayOfMonth()){
                    addPrice = false;
                }
                if(currentDate.getMonthValue() == peakSeasonEndDate.getMonthValue() && currentDate.getDayOfMonth() > peakSeasonEndDate.getDayOfMonth()){
                    addPrice = false;
                }
                if(addPrice){
                    fullPrice += pricePerDay * 1.6;
                }
            }
            if(currentDate.getMonthValue() >= midSeasonStartDate.getMonthValue() && currentDate.getMonthValue() <= midSeasonEndDate.getMonthValue()){
                addPrice = true;
                if(currentDate.getMonthValue() == midSeasonStartDate.getMonthValue() && currentDate.getDayOfMonth() < midSeasonStartDate.getDayOfMonth()){
                    addPrice = false;
                }
                if(currentDate.getMonthValue() == midSeasonEndDate.getMonthValue() && currentDate.getDayOfMonth() > midSeasonEndDate.getDayOfMonth()){
                    addPrice = false;
                }
                if(addPrice){
                    fullPrice += pricePerDay * 1.3;
                }
            }
            if(!addPrice){
                fullPrice += pricePerDay * 1.0;
            }
            currentDate = currentDate.plusDays(1);
            addPrice = false;
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
