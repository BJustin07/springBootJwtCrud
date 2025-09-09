package com.example.springbootjwtcrud.service.impl;


import com.example.springbootjwtcrud.exception.ExpensesException;
import com.example.springbootjwtcrud.model.ExpensesCategories;
import com.example.springbootjwtcrud.service.ExpenseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    //later add a repository to save to database.
    private double sum = 0;
    private ExpensesCategories expensesCategories;
    private List<Double> TotalExpense;

    public List<Double> GetAllExpenses(){
        return TotalExpense;
    }

    public String ListExpense(Double amount, ExpensesCategories expensesCategory){
        TotalExpense.add(amount);
        sum += amount;
        return "Successfully added expense for: " + expensesCategory + " amounts to: " + amount;
    }

    public String DeleteExpense(Double amount) throws ExpensesException {
        boolean successful = TotalExpense.remove(amount);
       if(!successful){
           throw new ExpensesException("Expenses could not be deleted, it does not exist");
       }
        return "Successfully removed expense amounting to: " + amount;
    }

    public String UpdateExpensePrice(Double amount, Double newAmount){
        boolean expenseExists = TotalExpense.contains(amount);
        if (!expenseExists) {
            throw new ExpensesException("Expenses could not be updated, it does not exist");
        }
        TotalExpense.remove(amount);
        sum -= amount;
        TotalExpense.add(newAmount);
        sum += newAmount;

        return "Successfully updated expense: " + amount + " To updated amount: " + newAmount;
    }


}
