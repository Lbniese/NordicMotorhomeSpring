package com.nmr.Handler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * PriceHandler contains all methods used to calculate prices shown on the contract and invoice page.
 */
public class PriceHandler {

    /**
     * calculateFullPrice() calculates the price for renting a motorhome based on the season it is in.
     *
     * @param rentalStartDate
     * @param rentalEndDate
     * @param pricePerDay
     * @return
     */
    public static double calculateFullPrice(LocalDateTime rentalStartDate, LocalDateTime rentalEndDate, int pricePerDay) {

        double fullPrice = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime peakSeasonStartDate = LocalDateTime.parse("2020-06-01 00:00", formatter);
        LocalDateTime peakSeasonEndDate = LocalDateTime.parse("2020-08-31 23:59", formatter);

        LocalDateTime midSeasonStartDate = LocalDateTime.parse("2020-03-01 00:00", formatter);
        LocalDateTime midSeasonEndDate = LocalDateTime.parse("2020-05-31 23:59", formatter);

        LocalDateTime currentDate = rentalStartDate;
        boolean addPrice = false;

        while (currentDate.isBefore(rentalEndDate) || currentDate.isEqual(rentalEndDate)) {
            if (currentDate.getMonthValue() >= peakSeasonStartDate.getMonthValue() && currentDate.getMonthValue() <= peakSeasonEndDate.getMonthValue()) {
                addPrice = currentDate.getMonthValue() != peakSeasonStartDate.getMonthValue() || currentDate.getDayOfMonth() >= peakSeasonStartDate.getDayOfMonth();
                if (currentDate.getMonthValue() == peakSeasonEndDate.getMonthValue() && currentDate.getDayOfMonth() > peakSeasonEndDate.getDayOfMonth()) {
                    addPrice = false;
                }
                if (addPrice) {
                    fullPrice += pricePerDay * 1.6;
                }
            }
            if (currentDate.getMonthValue() >= midSeasonStartDate.getMonthValue() && currentDate.getMonthValue() <= midSeasonEndDate.getMonthValue()) {
                addPrice = currentDate.getMonthValue() != midSeasonStartDate.getMonthValue() || currentDate.getDayOfMonth() >= midSeasonStartDate.getDayOfMonth();
                if (currentDate.getMonthValue() == midSeasonEndDate.getMonthValue() && currentDate.getDayOfMonth() > midSeasonEndDate.getDayOfMonth()) {
                    addPrice = false;
                }
                if (addPrice) {
                    fullPrice += pricePerDay * 1.3;
                }
            }
            if (!addPrice) {
                fullPrice += pricePerDay * 1.0;
            }
            currentDate = currentDate.plusDays(1);
            addPrice = false;
        }
        return fullPrice;
    }

    /**
     * calculatePickUpPrice() calculates the pickUpPrice based on pre-defined pickUpKm values based on pre-defined locations.
     *
     * @param pickUpPoint
     * @return
     */
    public static double calculatePickUpPrice(String pickUpPoint) {
        double pickUpPrice = 0;
        int pickUpKm = 0;
        if (pickUpPoint.equals("Airport")) {
            pickUpKm = 12;
        }
        if (pickUpPoint.equals("NMR - Headquarters")) {
            pickUpKm = 0;
        }
        if (pickUpPoint.equals("Copenhagen Central Station")) {
            pickUpKm = 5;
        }
        pickUpPrice = pickUpKm * 5;
        return pickUpPrice;
    }

    /**
     * calculateDropOffPrice() calculates the dropOffPrice based on pre-defined dropOffKm values based on pre-defined locations.
     *
     * @param dropOffPoint
     * @return
     */
    public static double calculateDropOffPrice(String dropOffPoint) {
        double dropOffPrice = 0;
        int dropOffKm = 0;
        if (dropOffPoint.equals("Airport")) {
            dropOffKm = 12;
        }
        if (dropOffPoint.equals("NMR - Headquarters")) {
            dropOffKm = 0;
        }
        if (dropOffPoint.equals("Copenhagen Central Station")) {
            dropOffKm = 5;
        }
        dropOffPrice = dropOffKm * 5;
        return dropOffPrice;
    }

    /**
     * calculateExtraPrice() calculates the total price for extra purchases for a contract.
     *
     * @param bikeRack
     * @param bedLinen
     * @param childSeat
     * @param picnicTable
     * @param chairs
     * @param grill
     * @param lantern
     * @param firstAidKit
     * @param toiletPaper
     * @return
     */
    public static double calculateExtraPrice(int bikeRack, int bedLinen, int childSeat, int picnicTable, int chairs, int grill, int lantern, int firstAidKit, int toiletPaper) {
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

    /**
     * calculateCancellationFee() is calculating the discount the customer gets upon cancelling an order.
     * In case of cancellation following charges become due:
     * Up to 50 days prior to the start of the term of rental: 20% of the rental price, minimum 200€
     * Between 49 and 15 days prior to the start of the term of rental: 50% of the rental price
     * Less than 15 days prior to the start of the term of rental: 80% of the rental price
     * On the day of renting: 95% of the rental price
     * This method will return the full price deducted by the fee.
     *
     * @param active
     * @param rentalStartDate
     * @param fullPrice
     * @return
     */
    public static double calculateCancellationPrice(boolean active, LocalDateTime rentalStartDate, double fullPrice) {
        double fee = fullPrice;
        if (active) {
            return fee;
        }

        LocalDateTime today = LocalDateTime.now();
        long days = DAYS.between(today, rentalStartDate);
        if (days == 0) {
            fee = fullPrice * 0.95;
        }
        if (days < 15 && days >= 1) {
            fee = fullPrice * 0.80;
        }
        if (days <= 49 && days >= 15) {
            fee = fullPrice * 0.50;
        }
        if (days >= 50) {
            fee = fullPrice * 0.20;
            if (fee < 1500) {
                fee = 1500;
            }
        }
        return fee;
    }

    /**
     * calculateCancellationFee() is calculating the discount the customer gets upon cancelling an order.
     * In case of cancellation following charges become due:
     * Up to 50 days prior to the start of the term of rental: 20% of the rental price, minimum 200€
     * Between 49 and 15 days prior to the start of the term of rental: 50% of the rental price
     * Less than 15 days prior to the start of the term of rental: 80% of the rental price
     * On the day of renting: 95% of the rental price
     * This method will return the discounted amount.
     *
     * @param active
     * @param rentalStartDate
     * @return
     */
    public static double calculateCancellationFee(boolean active, LocalDateTime rentalStartDate) {
        double fee = 0;
        if (active) {
            return fee;
        }

        LocalDateTime today = LocalDateTime.now();
        long days = DAYS.between(today, rentalStartDate);
        if (days == 0) {
            fee = 5;
        }
        if (days < 15 && days >= 1) {
            fee = 20;
        }
        if (days <= 49 && days >= 15) {
            fee = 50;
        }
        if (days >= 50) {
            fee = 20;
        }
        return fee;
    }

}



