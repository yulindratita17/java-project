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

public class Novel extends BookForLoan{
    boolean isSeries;

    @Override
    public void calculatePriceLoan() {
        // TODO Auto-generated method stub
        super.calculatePriceLoan();
        double ratesBook = 0.05;

        setBookLoanPrice(getBookLoanPrice() * ratesBook);
    }
}
