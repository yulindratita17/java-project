package com.project.loanbook.models;

import com.project.loanbook.abstracts.Book;
import com.project.loanbook.interfaces.IPriceLoan;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class BookForLoan extends Book implements IPriceLoan{
    double bookLoanPrice;
    int stock;

    @Override
    public void calculatePriceLoan() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'calculatePriceLoan'");

        double ratesStock = 0;
        
        if (getStock() >= 10) {
            ratesStock = 0.03;
        } else if(getStock() < 10){
            ratesStock = 0.05;
        }

        setBookLoanPrice(ratesStock);
    }
}
