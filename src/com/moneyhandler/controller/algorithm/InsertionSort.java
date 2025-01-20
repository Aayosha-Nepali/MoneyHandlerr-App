/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.moneyhandler.controller.algorithm;

import com.moneyhandler.model.TransactionModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class InsertionSort {
    
    List<TransactionModel> transactionSortList;

    public InsertionSort() {
        transactionSortList = new ArrayList<>();
    }

    
    public List<TransactionModel> sortByCategory(List<TransactionModel> paymentList, boolean isDesc) {
        this.transactionSortList.clear();
        this.transactionSortList.addAll(paymentList);

        if (transactionSortList == null || transactionSortList.isEmpty()) {
            throw new IllegalArgumentException("Transaction list cannot be null or empty.");
        }

        // Insertion sort algorithm
        for (int i = 1; i < transactionSortList.size(); i++) {
            TransactionModel currentPayment = transactionSortList.get(i);
            int j = i - 1;

            // Move elements that are greater than currentPayment (or less, based on order)
            while (j >= 0 && shouldSwap(currentPayment.getCategory(), transactionSortList.get(j).getCategory(), isDesc)) {
                transactionSortList.set(j + 1, transactionSortList.get(j));
                j = j - 1;
            }
            transactionSortList.set(j + 1, currentPayment);
        }

        return transactionSortList;
    }

    
    private boolean shouldSwap(String current, String other, boolean isDesc) {
        int comparisonResult = current.compareTo(other);//lexicographical comparison
        return isDesc ? comparisonResult > 0 : comparisonResult < 0;
    }
    
}
