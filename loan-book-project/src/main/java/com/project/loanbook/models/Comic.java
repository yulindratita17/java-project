package com.project.loanbook.models;

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

public class Comic extends BookForLoan{
    String genre;

    @Override
    public void calculatePriceLoan() {
        // TODO Auto-generated method stub
        super.calculatePriceLoan();
        double ratesBook = 0.1;

        setBookLoanPrice(getBookLoanPrice() * ratesBook);
    }

}
