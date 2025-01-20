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
public class SelectionSort {
    
    List<TransactionModel> transactionSortList;

    public SelectionSort() {
        transactionSortList = new ArrayList<>();
    }

    
    public List<TransactionModel> sortByPaymentID(List<TransactionModel> paymentList, boolean isDesc) {
        this.transactionSortList.clear();
        this.transactionSortList.addAll(paymentList);

        if (transactionSortList == null || transactionSortList.isEmpty()) {
            throw new IllegalArgumentException("Transaction list cannot be null or empty.");
        }

        // Selection sort algorithm
        for (int i = 0; i < transactionSortList.size() - 1; i++) {
            int extremumIndex = findExtremumIndex(transactionSortList, i, isDesc);
            if (i != extremumIndex) {
                swap(transactionSortList, i, extremumIndex);
            }
        }

        return transactionSortList;
    }

   
    private int findExtremumIndex(List<TransactionModel> transactionSortList, int startIndex, boolean isDesc) {
        int extremumIndex = startIndex;

        for (int j = startIndex + 1; j < transactionSortList.size(); j++) {
            if (shouldSwap(transactionSortList.get(j).getPaymentID(), transactionSortList.get(extremumIndex).getPaymentID(), isDesc)) {
                extremumIndex = j;
            }
        }

        return extremumIndex;
    }

   
    private boolean shouldSwap(int current, int extremum, boolean isDesc) {
        return isDesc ? current > extremum : current < extremum;
    }

    
    private void swap(List<TransactionModel> transactionSortList, int i, int j) {
        TransactionModel temp = transactionSortList.get(i);
        transactionSortList.set(i, transactionSortList.get(j));
        transactionSortList.set(j, temp);
    }
    
}
