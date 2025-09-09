package com.example.springbootjwtcrud.service;

import com.example.springbootjwtcrud.exception.ExpensesException;
import com.example.springbootjwtcrud.model.ExpensesCategories;

import java.util.List;

public interface ExpenseService {
    List<Double> GetAllExpenses();
    String ListExpense(Double amount, ExpensesCategories expensesCategory);
    String UpdateExpensePrice(Double amount, Double newAmount);
    String DeleteExpense(Double amount) throws ExpensesException;
}
