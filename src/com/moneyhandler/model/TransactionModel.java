/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.moneyhandler.model;

/**
 *
 * @author linux
 */
public class TransactionModel {
    private int paymentID;
    private String date;
    private String category;
    private String incomeExpense;
    private String sourceVendor;
    private double amount;
    private String mode;
    private String remarks;

    public TransactionModel(int paymentID, String date, String category, String incomeExpense, String sourceVendor, double amount, String mode, String remarks) {
        this.paymentID = paymentID;
        this.date = date;
        this.category = category;
        this.incomeExpense = incomeExpense;
        this.sourceVendor = sourceVendor;
        this.amount = amount;
        this.mode = mode;
        this.remarks = remarks;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public String getIncomeExpense() {
        return incomeExpense;
    }

    public String getSourceVendor() {
        return sourceVendor;
    }

    public double getAmount() {
        return amount;
    }

    public String getMode() {
        return mode;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setIncomeExpense(String incomeExpense) {
        this.incomeExpense = incomeExpense;
    }

    public void setSourceVendor(String sourceVendor) {
        this.sourceVendor = sourceVendor;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    }
    

