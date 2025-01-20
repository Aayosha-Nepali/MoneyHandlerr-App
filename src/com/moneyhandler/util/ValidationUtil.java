/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.moneyhandler.util;

import java.awt.Color;
import java.util.regex.Pattern;
import javax.swing.JLabel;

/**
 *
 * @author  
 */

public class ValidationUtil {
    // Regular expressions for validation
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+"); // Numeric pattern
    private static final Pattern DATE_PATTERN = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$"); // Date pattern: YYYY-MM-DD
    private static final Pattern ALPHABET_PATTERN = Pattern.compile("^[a-zA-Z\\s]+$"); // Only alphabets and spaces
    private static final Pattern ALPHA_NUMERIC_PATTERN = Pattern.compile("^[a-zA-Z0-9\\s]+$"); // Alphanumeric with spaces
    private static final Pattern PAYMENT_ID_PATTERN = Pattern.compile("^\\d{5}$"); // 5-digit payment ID
    private static final Pattern CATEGORY_PATTERN = Pattern.compile("^[a-zA-Z]+(\\s[a-zA-Z]+)?$"); // Up to 2 words for category
    private static final Pattern INCOME_EXPENSIVE_PATTERN = Pattern.compile("^[a-zA-Z]+(\\s[a-zA-Z]+)?$"); // Up to 2 words for income/expense
    private static final Pattern SOURCE_VENDOR_PATTERN = Pattern.compile("^[a-zA-Z]+(\\s[a-zA-Z]+)?$"); // Up to 2 words for source/vendor
    private static final Pattern REMARKS_PATTERN = Pattern.compile("^[a-zA-Z]+(\\s[a-zA-Z]+)?$"); // Up to 2 words for remarks

    // Helper method to check if a string is null or empty
    private static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    /**
     * Validates the payment ID.
     * It should be numeric and exactly 5 digits.
     *
     * @param paymentId the payment ID to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidPaymentId(String paymentId, JLabel lblError) {
        if (isNullOrEmpty(paymentId)) {
            lblError.setText("Payment ID cannot be empty.");
            lblError.setForeground(Color.RED);
            return false;
        }
        if (!PAYMENT_ID_PATTERN.matcher(paymentId).matches()) {
            lblError.setText("Payment ID must be 5 digits.");
            lblError.setForeground(Color.RED);
            return false;
        }
        return true;
    }

    /**
     * Validates the date.
     * It should be in the format YYYY-MM-DD (e.g., 2024-09-23).
     *
     * @param date the date to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidDate(String date, JLabel lblError) {
        if (isNullOrEmpty(date)) {
            lblError.setText("Date cannot be empty.");
            lblError.setForeground(Color.RED);
            return false;
        }
        if (!DATE_PATTERN.matcher(date).matches()) {
            lblError.setText("Date must be in the format YYYY-MM-DD.");
            lblError.setForeground(Color.RED);
            return false;
        }
        return true;
    }

    /**
     * Validates a string with up to 2 words.
     * This can be used for category, income/expense, and source/vendor.
     *
     * @param value the value to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    private static boolean isValidStringUpToTwoWords(String value, JLabel lblError, String fieldName) {
        if (isNullOrEmpty(value)) {
            lblError.setText(fieldName + " cannot be empty.");
            lblError.setForeground(Color.RED);
            return false;
        }
        if (!ALPHABET_PATTERN.matcher(value).matches() || value.split("\\s+").length > 2) {
            lblError.setText(fieldName + " must be maximum of 2 words.");
            lblError.setForeground(Color.RED);
            return false;
        }
        return true;
    }

    /**
     * Validates the category.
     * It should be a string with a maximum of 2 words.
     *
     * @param category the category to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidCategory(String category, JLabel lblError) {
        return isValidStringUpToTwoWords(category, lblError, "Category");
    }

    /**
     * Validates the income/expense.
     * It should be a string with a maximum of 2 words.
     *
     * @param incomeExpensive the income/expense to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidIncomeExpensive(String incomeExpensive, JLabel lblError) {
        return isValidStringUpToTwoWords(incomeExpensive, lblError, "Income/Expense");
    }

    /**
     * Validates the source/vendor.
     * It should be a string with a maximum of 2 words.
     *
     * @param sourceVender the source/vendor to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidSourceVender(String sourceVender, JLabel lblError) {
        return isValidStringUpToTwoWords(sourceVender, lblError, "Source/Vendor");
    }

    /**
     * Validates the amount.
     * It must be a valid double.
     *
     * @param amount the amount to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidAmount(String amount, JLabel lblError) {
        if (isNullOrEmpty(amount)) {
            lblError.setText("Amount cannot be empty.");
            lblError.setForeground(Color.RED);
            return false;
        }
        try {
            Double.parseDouble(amount);
        } catch (NumberFormatException e) {
            lblError.setText("Amount must be a valid number.");
            lblError.setForeground(Color.RED);
            return false;
        }
        return true;
    }

    /**
     * Validates the remarks.
     * It should be a string with a maximum of 2 words.
     *
     * @param remarks the remarks to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidRemarks(String remarks, JLabel lblError) {
        return isValidStringUpToTwoWords(remarks, lblError, "Remarks");
    }
}
