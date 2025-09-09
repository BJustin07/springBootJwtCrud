package com.example.springbootjwtcrud.service;

import com.example.springbootjwtcrud.exception.ExpensesException;
import com.example.springbootjwtcrud.model.ExpensesCategories;

import java.util.List;

public interface ExpenseService {
    List<Double> GetAllExpenses() throws ExpensesException ;
    String ListExpense(Double amount, ExpensesCategories expensesCategory) throws ExpensesException;
    String UpdateExpensePrice(Double amount, Double newAmount) throws ExpensesException;
    String DeleteExpense(Double amount) throws ExpensesException;
}
