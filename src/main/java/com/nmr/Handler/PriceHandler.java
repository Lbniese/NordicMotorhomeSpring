package com.nmr.Handler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.DAYS;


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


    public static double calculateExtraPrice(int bikeRack, int bedLinen, int childSeat, int picnicTable, int chairs, int grill, int lantern, int firstAidKit, int toiletPaper){
        double extraPrice = 0;
        extraPrice += 35 * bikeRack;
        extraPrice += 20 * bedLinen;
        extraPrice += 75 * childSeat;
        extraPrice += 50 * picnicTable;
        extraPrice += 10 * chairs;
        extraPrice += 100 * grill;
        extraPrice += 5 * lantern;
        extraPrice += 250 * firstAidKit;
        extraPrice += 2 * toiletPaper;
        //combined 547 dkk
        return extraPrice;
    }

    public static double calculateCancellationFee(boolean active, LocalDateTime rentalStartDate, double fullPrice){
        double fee = fullPrice;
        if(active) {
            return fee;
        }

        LocalDateTime today = LocalDateTime.now();
        long days = DAYS.between(today, rentalStartDate);
        if(days == 0){
            fee = fullPrice * 0.95;
        }
        if(days < 15 && days >= 1){
            fee = fullPrice * 0.80;
        }
        if(days <= 49 && days >= 15){
            fee = fullPrice * 0.50;
        }
        if(days >= 50){
            fee = fullPrice * 0.20;
            if(fee < 1500){
                fee = 1500;
            }
        }
        return fee;
    }

    public static double calculateCancellationFee(boolean active, LocalDateTime rentalStartDate){
        double fee = 0;
        if(active) {
            return fee;
        }

        LocalDateTime today = LocalDateTime.now();
        long days = DAYS.between(today, rentalStartDate);
        if(days == 0){
            fee = 5;
        }
        if(days < 15 && days >= 1){
            fee = 20;
        }
        if(days <= 49 && days >= 15){
            fee = 50;
        }
        if(days >= 50){
            fee = 20;
            /*
            if(fee < 1500){
                fee = 1500;
            }
             */
        }
        return fee;
    }

}



