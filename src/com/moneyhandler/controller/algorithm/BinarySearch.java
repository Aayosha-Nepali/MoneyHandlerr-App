/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.moneyhandler.controller.algorithm;

import com.moneyhandler.model.TransactionModel;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class BinarySearch {
    
    public TransactionModel searchByPaymentID(String searchValue, String searchColumn, List<TransactionModel> paymentList, int left, int right) {
        if (right < left) {
            return null; // Element not found
        }

        int mid = (left + right) / 2;

        // Get the value based on the selected column
        String midValue = getFieldValue(paymentList.get(mid), searchColumn);

        // Handle numeric comparisons for Paymeny ID
        if (searchColumn.equals("Payment ID")) {
            try {
                int searchInt = Integer.parseInt(searchValue); // Convert the search value to an integer
                int midInt = Integer.parseInt(midValue); // Convert mid value (Payment ID) to integer

                if (searchInt == midInt) { // Match found
                    return paymentList.get(mid);
                } else if (searchInt < midInt) { // Search left half
                    return searchByPaymentID(searchValue, searchColumn, paymentList, left, mid - 1);
                } else { // Search right half
                    return searchByPaymentID(searchValue, searchColumn, paymentList, mid + 1, right);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input for Payment ID. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }

    
        // Default case (string comparison for other fields, if needed)
        int comparison = searchValue.compareToIgnoreCase(midValue);
        if (comparison == 0) { // Match found
            return paymentList.get(mid);
        } else if (comparison < 0) { // Search left half
            return searchByPaymentID(searchValue, searchColumn, paymentList, left, mid - 1);
        } else { // Search right half
            return searchByPaymentID(searchValue, searchColumn, paymentList, mid + 1, right);
        }
    }

   
    private String getFieldValue(TransactionModel payment, String columnName) {
        switch (columnName) {
            case "Payment ID":
                return String.valueOf(payment.getPaymentID()); // Convert integer to string
            case "Date":
                return payment.getDate();
            case "Category":
                return payment.getCategory();
            case "IncomeExpense":
                return payment.getIncomeExpense();
            case "SourceVendor":
                return payment.getSourceVendor();
            case "Amount":
                return String.valueOf(payment.getAmount());
            case "Mode":
                return payment.getMode();
            case "Remarks":
                return payment.getRemarks();
            default:
                return ""; // Default case for unsupported columns
        }
    }
}
