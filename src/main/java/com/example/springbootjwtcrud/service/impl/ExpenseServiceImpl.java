package com.example.springbootjwtcrud.service.impl;


import com.example.springbootjwtcrud.exception.ExpensesException;
import com.example.springbootjwtcrud.model.ExpensesCategories;
import com.example.springbootjwtcrud.service.ExpenseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    //later add a repository to save to database.
    private double sum = 0;
    private ExpensesCategories expensesCategories;
    private final List<Double> TotalExpense = new ArrayList<>();

    public List<Double> GetAllExpenses() throws ExpensesException {
        if(TotalExpense.isEmpty()){
            throw new ExpensesException("Expenses list is empty");
        }
        return TotalExpense;
    }

    public String ListExpense(Double amount, ExpensesCategories expensesCategory) throws ExpensesException{
        if (amount <= 0 || expensesCategory == null) {
            throw new ExpensesException("Please enter a valid amount and category");
        }
        TotalExpense.add(amount);
        sum += amount;
        return "Successfully added expense for: " + expensesCategory + " amounts to: " + amount;
    }

    public String DeleteExpense(Double amount) throws ExpensesException {
        boolean successful = TotalExpense.remove(amount);
       if(!successful){
           throw new ExpensesException("Expenses could not be deleted, it does not exist");
       }
        return "Successfully removed expense amounting to: " + amount + " Current expense is: " + TotalExpense;
    }

    public String UpdateExpensePrice(Double amount, Double newAmount) throws ExpensesException {
        boolean expenseExists = TotalExpense.contains(amount);
        if (!expenseExists) {
            throw new ExpensesException("Expenses could not be updated, it does not exist, current expense list is: " + TotalExpense);
        }
        TotalExpense.remove(amount);
        sum -= amount;
        TotalExpense.add(newAmount);
        sum += newAmount;

        return "Successfully updated expense: " + amount + " To updated amount: " + newAmount;
    }


}
