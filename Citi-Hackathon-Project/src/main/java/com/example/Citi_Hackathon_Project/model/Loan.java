package com.example.Citi_Hackathon_Project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Loan {

    private double currentAmountBorrowed;
    private int loanTerm;
    private double interestRatePerMonth;
    private int amountOfLoans;
    private double maximumLoanAmount;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userID;

    public Loan(){

    }

    public Loan(double currentAmountBorrowed, int loanTerm, double interestRatePerMonth, int amountOfLoans, double maximumLoanAmount) {
        this.currentAmountBorrowed = currentAmountBorrowed;
        this.loanTerm = loanTerm;
        this.interestRatePerMonth = interestRatePerMonth;
        this.amountOfLoans = amountOfLoans;
        this.maximumLoanAmount = maximumLoanAmount;
    }

    // Returns all the details of the loan
    public String checkStatement(){
        return "UserID: " + userID + "\tCurrent Amount Borrowed: " + currentAmountBorrowed + "\n";
    }

    public void borrowLoan(double loanAmount){
        if(!validateLoanRequest(loanAmount)){
            return;
        } 
        else {
            currentAmountBorrowed += loanAmount;
        }
    }

    public void returnLoan(double returnAmount){
        if(returnAmount < 0){
            return;
        }
        else {
            currentAmountBorrowed -= returnAmount; 
        }
    }

    public double calculateMonthlyPayments(){
        double monthlyPayment = currentAmountBorrowed*interestRatePerMonth/(1-Math.pow(1+interestRatePerMonth,-1*(loanTerm)));
        return monthlyPayment;
    }

    public boolean validateLoanRequest(double loanAmount){
        if(loanAmount < 0 || (currentAmountBorrowed + loanAmount) > maximumLoanAmount){
            return false;
        }
        return true;
    }

    public void setCurrentAmountBorrowed(double currentAmountBorrowed){
        this.currentAmountBorrowed = currentAmountBorrowed;
    }

    public double getCurrentAmountBorrowed(){
        return currentAmountBorrowed;
    }

    public void setLoanTerm(int loanTerm){
        this.loanTerm = loanTerm;
    }

    public int getLoanTerm(){
        return this.loanTerm;
    }

    public void setInterestRatePerMonth(double interestRatePerMonth){
        this.interestRatePerMonth = interestRatePerMonth;
    }

    public double getInterestRatePerMonth(){
        return this.interestRatePerMonth;
    }

    public void setAmountOfLoans(int amountOfLoans){
        this.amountOfLoans = amountOfLoans;
    }

    public int getAmountOfLoans(){
        return this.amountOfLoans;
    }

    public void setMaximumLoanAmount(double maximumLoanAmount){
        this.maximumLoanAmount = maximumLoanAmount;
    }

    public double getMaximumLoanAmount(){
        return this.maximumLoanAmount;
    }

    public void setUserID(Long userID){
        this.userID = userID;
    }

    public Long getUserID(){
        return this.userID;
    }





}
