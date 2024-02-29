package com.project.loanbook.services;

import java.util.ArrayList;
import java.util.List;

import com.project.loanbook.models.BookForLoan;
import com.project.loanbook.models.LoanBookOrder;
import com.project.loanbook.models.Member;
import com.project.loanbook.repositories.BookForLoanRepository;
import com.project.loanbook.repositories.MemberRepository;

public class MenuService {

    public static void runApp(){
        List<BookForLoan> listBookForLoan = BookForLoanRepository.getAllBookForLoan();
        List<Member> listMember = MemberRepository.getAllMember();
        List<LoanBookOrder> listLoanBook = new ArrayList<>();

        mainMenu(listBookForLoan, listMember, listLoanBook);
        
    }

    public static void mainMenu(List<BookForLoan> listBookForLoan, List<Member> listMember, List<LoanBookOrder> listLoanBook) {
        String[] listMainMenu = { "Data All Book For Loan", "Loan", "Return", "Data All Loan Book Order", "Exit" };
        boolean isLooping = true;
        int optionMenu;

        do {
            PrintService.printMenu("Main Menu", listMainMenu);
            optionMenu = ValidationService.validateNumberWithRange("Choose item: ", "Only number accepted",
                    ValidationService.regexNumber, 0, 4);

            switch (optionMenu) {
                case 1:
                PrintService.printDataBookForLoan("Data Book For Loan", listBookForLoan);

                    break;

                case 2:
                
                PrintService.printDataMember("Data Member", listMember);
                String memberId = ValidationService.validateInput("Enter member id: ", "Wrong member id", ValidationService.regexId);

                PrintService.printDataBookForLoan("Loan Book", listBookForLoan);
                String bookId = ValidationService.validateInput("Enter book id: ", "Wrong book id", ValidationService.regexId);
                int loanDuration = Integer.valueOf(ValidationService.validateInput("Enter loan duration: ", "Only number accepted", ValidationService.regexNumber));

                
                listLoanBook.add(LoanBookServices.createLoanBookOrder(bookId, memberId, bookId, loanDuration, loanDuration, listMember, listBookForLoan));

                PrintService.printDataLoanBook("Data Loan Book", listLoanBook);

                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 0:
                    isLooping = false;

                    break;

            }

        } while (isLooping);
    }
}
