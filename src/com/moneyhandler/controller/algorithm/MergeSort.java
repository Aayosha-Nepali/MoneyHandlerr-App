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
public class MergeSort {
    
  
    // Sort a list of TransactionModel objects based on Location (String) in ascending or descending order
    public List<TransactionModel> sortBySourceVendor(List<TransactionModel> paymentList, boolean isDesc) {
        if (paymentList == null || paymentList.isEmpty()) {
            throw new IllegalArgumentException("Transaction list cannot be null or empty.");
        }
        // Convert the List to an array for merge sort (MergeSort works with arrays)
        List<TransactionModel> sortedList = new ArrayList<>(paymentList);
        mergeSort(sortedList, 0, sortedList.size() - 1, isDesc);
        return sortedList;
    }

   
    // The mergeSort function recursively splits the list and merges it back
    private void mergeSort(List<TransactionModel> list, int left, int right, boolean isDesc) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(list, left, mid, isDesc);   // Sort the left half
            mergeSort(list, mid + 1, right, isDesc); // Sort the right half

            merge(list, left, mid, right, isDesc); // Merge the sorted halves
        }
    }

   
    
    // The merge function combines two sorted halves of the list
    private void merge(List<TransactionModel> list, int left, int mid, int right, boolean isDesc) {
        // Temporary arrays for the two halves
        List<TransactionModel> leftList = new ArrayList<>(list.subList(left, mid + 1));
        List<TransactionModel> rightList = new ArrayList<>(list.subList(mid + 1, right + 1));

        int i = 0, j = 0, k = left;

        // Merge the two halves based on Source/Vendor (String comparison)
        while (i < leftList.size() && j < rightList.size()) {
            if (shouldSwap(leftList.get(i).getSourceVendor(), rightList.get(j).getSourceVendor(), isDesc)) {
                list.set(k++, leftList.get(i++));
            } else {
                list.set(k++, rightList.get(j++));
            }
        }

        // Copy any remaining elements from the left half
        while (i < leftList.size()) {
            list.set(k++, leftList.get(i++));
        }

        // Copy any remaining elements from the right half
        while (j < rightList.size()) {
            list.set(k++, rightList.get(j++));
        }
    }

    
    private boolean shouldSwap(String leftSource, String rightLocation, boolean isDesc) {
        return isDesc ? leftSource.compareTo(rightLocation) > 0 : leftSource.compareTo(rightLocation) < 0;
    }
}
