package com.project.loanbook.repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.project.loanbook.models.BookForLoan;
import com.project.loanbook.models.Comic;
import com.project.loanbook.models.Novel;

public class BookForLoanRepository {
    public static List<BookForLoan> getAllBookForLoan(){
        List<BookForLoan> listBookForLoan = new ArrayList<>() ;

        BookForLoan comic1 = Comic.builder()
        .bookID("Comic-001")
        .tittle("Uzumaki Naruto")
        .author("Masashi Kisimoto")
        .bookPrice(55000)
        .stock(10)
        .genre("Shounen")
        .build();

        BookForLoan comic2 = Comic.builder()
        .bookID("Comic-002")
        .tittle("The Worst Client")
        .author("Masashi Kisimoto")
        .bookPrice(35000)
        .stock(20)
        .genre("Shounen")
        .build();

        BookForLoan comic3 = Comic.builder()
        .bookID("Comic-003")
        .tittle("For the Sake of Dreams...!!")
        .author("Masashi Kisimoto")
        .bookPrice(35000)
        .stock(15)
        .genre("Shounen")
        .build();
        
        BookForLoan comic4 = Comic.builder()
        .bookID("Comic-004")
        .tittle("Hunter X Hunter : The Day of Departure")
        .author("Yoshihiro Togashi")
        .bookPrice(50000)
        .stock(15)
        .genre("Fantasy")
        .build();

        BookForLoan comic5 = Comic.builder()
        .bookID("Comic-005")
        .tittle("Hunter X Hunter : A Struggle in the Mist")
        .author("Yoshihiro Togashi")
        .bookPrice(80000)
        .stock(25)
        .genre("Fantasy")
        .build();

        // novel
        BookForLoan novel1 = Novel.builder()
        .bookID("Novel-001")
        .tittle("Harry Potter and the Philosopher's Stone")
        .author("J.K Rowling")
        .bookPrice(150000)
        .stock(10)
        .isSeries(true)
        .build();

        BookForLoan novel2 = Novel.builder()
        .bookID("Novel-002")
        .tittle("Harry Potter and the Chamber of Secrets")
        .author("J.K Rowling")
        .bookPrice(150000)
        .stock(10)
        .isSeries(true)
        .build();

        BookForLoan novel3 = Novel.builder()
        .bookID("Novel-003")
        .tittle("Harry Potter and the Prisoner of Azkaban")
        .author("J.K Rowling")
        .bookPrice(200000)
        .stock(15)
        .isSeries(true)
        .build();

        BookForLoan novel4 = Novel.builder()
        .bookID("Novel-004")
        .tittle("Ayah Aku Berbeda")
        .author("Tere Liye")
        .bookPrice(35000)
        .stock(15)
        .isSeries(false)
        .build();

        BookForLoan novel5 = Novel.builder()
        .bookID("Novel-005")
        .tittle("Madre")
        .author("Dee Lestari")
        .bookPrice(80000)
        .stock(10)
        .isSeries(false)
        .build();

        listBookForLoan.addAll(Arrays.asList(comic1, comic2, comic3, comic4, comic5, novel1, novel2, novel3, novel4, novel5));

        return listBookForLoan;
    }
}
