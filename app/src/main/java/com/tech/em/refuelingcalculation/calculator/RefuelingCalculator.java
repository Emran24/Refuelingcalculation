package com.tech.em.refuelingcalculation.calculator;

/**
 * Class intended for calculating aircraft refueling
 */

public class RefuelingCalculator {

    private final double COEFFICIENT_OF_CONVERTING_POUNDS_IN_KILOGRAMS = 0.4536;
    private double leftTankRemainder;
    private double rightTankRemainder;
    private double centerTankRemainder;
    private double totalRefueling;
    private double fuelDencity;

    public void setLeftTankRemainder(double leftTankRemainder) {
        this.leftTankRemainder = leftTankRemainder;
    }

    public void setRightTankRemainder(double rightTankRemainder) {
        this.rightTankRemainder = rightTankRemainder;
    }

    public void setCenterTankRemainder(double centerTankRemainder) {
        this.centerTankRemainder = centerTankRemainder;
    }

    public void setTotalRefueling(double totalRefueling) {
        this.totalRefueling = totalRefueling;
    }

    public void setFuelDencity(double fuelDencity) {
        this.fuelDencity = fuelDencity;
    }

    private double calculateSumOfRemainsOnTanks(){
        return this.leftTankRemainder +
                this.centerTankRemainder +
                this.rightTankRemainder;
    }

    public double calculateRefueldFuelAmountInLiters(){
        double refueldFuelAmount;
        if(isFuelAmountInPounds()) {
            refueldFuelAmount =( this.totalRefueling - ( calculateSumOfRemainsOnTanks() * COEFFICIENT_OF_CONVERTING_POUNDS_IN_KILOGRAMS ) ) / this.fuelDencity;
        } else {
            refueldFuelAmount = (this.totalRefueling - calculateSumOfRemainsOnTanks()) / this.fuelDencity;
        }
        return refueldFuelAmount;
    }

    public double calculateFuelRemainderInKilograms(){
        double fuelRemainder;
        if(isFuelAmountInPounds()){
            fuelRemainder = (this.totalRefueling - calculateSumOfRemainsOnTanks() * COEFFICIENT_OF_CONVERTING_POUNDS_IN_KILOGRAMS);
        }else {
            fuelRemainder = (this.totalRefueling - calculateSumOfRemainsOnTanks());

        }
        return fuelRemainder;
    }

    public boolean isFuelAmountInPounds(){
        return true;
    }
}