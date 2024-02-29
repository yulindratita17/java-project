package com.project.loanbook.services;

import java.util.List;
import com.project.loanbook.models.BookForLoan;
import com.project.loanbook.models.LoanBookOrder;
import com.project.loanbook.models.Member;


public class LoanBookServices {
    public static String generateLoanId() {
        String result = "";

        int number = 1;

        if (number < 10) {
            result = "Ord-00" + number;
        } else {
            result = "Ord-0" + number;
        }

        number++;

        return result;
    }

    public static LoanBookOrder createLoanBookOrder(String loanId, String memberId, String bookId, int loanDuration, double loanFee, List<Member> listMember, List<BookForLoan> listBookForLoan){
        Member member = getMemberById(memberId, listMember);
        BookForLoan book = getBookForLoanById(bookId, listBookForLoan);


        LoanBookOrder loanBookOrder = new LoanBookOrder(generateLoanId(), member, book, loanDuration, loanFee);

        loanBookOrder.setLoanFee(book.getBookLoanPrice() * loanDuration);

        return loanBookOrder;

    }

    public static Member getMemberById(String memberId, List<Member> listMember) {
        Member result = new Member();

        for (Member member : listMember) {
            if (member.getMemberID().equals(memberId)) {
                result = member;
            }
        }

        return result;
    }

    public static BookForLoan getBookForLoanById(String bookId, List<BookForLoan> listBookForLoan){
        BookForLoan result = new BookForLoan();

        for (BookForLoan bookForLoan : listBookForLoan) {
            if (bookForLoan.getBookID().equals(bookId)) {
                result = bookForLoan;
            }
        }

        return result;
    }

    // public static Comic getComicById(String bookId, List<BookForLoan> listBookForLoan) {
    //     //List<Comic> result = new ArrayList<>();
    //     Comic comic = new Comic();

    //     for (BookForLoan bookForLoan : listBookForLoan) {
    //         if (bookForLoan instanceof Comic) {
    //             if (((Comic)bookForLoan).getBookID().equals(bookId)) {
    //                 //if (!result.contains(((Comic)bookForLoan).getBookID())) {
    //                     comic = (((Comic)bookForLoan));
    //                // }
    //             }

    //         }
    //     }

    //     return comic;
    // }

    // public static Novel getNovelById(String bookId, List<BookForLoan> listBookForLoan) {
    //     //List<Comic> result = new ArrayList<>();
    //     Novel novel = new Novel();

    //     for (BookForLoan bookForLoan : listBookForLoan) {
    //         if (bookForLoan instanceof Novel) {
    //             if (((Novel)bookForLoan).getBookID().equals(bookId)) {
    //                 //if (!result.contains(((Comic)bookForLoan).getBookID())) {
    //                     novel = (((Novel)bookForLoan));
    //                // }
    //             }

    //         }
    //     }

    //     return novel;
    // }

    
}
