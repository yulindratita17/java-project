package bookproject.model;

import java.util.List;

import bookproject.abstracts.Book;
import bookproject.abstracts.CommercialBook;
import bookproject.repositories.BookRepository;

public class BookCaseMenu {

    public static void runApp() {

        BookRepository bookRepo = new BookRepository();
        List<CommercialBook> listAllBook = bookRepo.getAllBook();

        mainMenu(listAllBook);

    }

    public static void mainMenu(List<CommercialBook> listAllBook) {
        String[] mainMenu = { "Book", "Author", "Publisher", "Exit" };
        int optionMainMenu;
        boolean isLooping = true;

        do {
            PrintData.printMenu("Main Menu", mainMenu);

            optionMainMenu = Integer
                    .valueOf(Validation.validateNumberWithRange("Choose item: ", "Only number accepted",
                            Validation.regexNumber, 0, 3));
            switch (optionMainMenu) {
                case 1:
                    // panggil menu book
                    bookMenu(listAllBook);
                    break;
                case 2:
                    // panggil menu author
                    authorMenu(listAllBook);
                    break;
                case 3:
                    publisherMenu(listAllBook);
                    // panggil menu publisher
                    break;
                case 0:
                    // menu exit
                    isLooping = false;

                    break;

            }
        } while (isLooping);

    }

    public static void bookMenu(List<CommercialBook> listAllBook) {
        String[] bookMenu = { "Find cheapest book", "Find most expensive book", "Find book by range price",
                "Find comic by mangaka rating", "Find book by publisher country", "Find book by author country",
                "Find most expensive comic", "Back to main menu" };
        int optionMenu;
        boolean isLooping = true;

        do {
            PrintData.printMenu("Book Menu Searching", bookMenu);
            optionMenu = Validation.validateNumberWithRange("Choose item: ", "Only number accepted",
                    Validation.regexNumber, 0, 7);
            switch (optionMenu) {
                case 1:
                    PrintData.printDataBook("Cheapest Book", BookCaseAction.findBookByPrice("cheap", listAllBook));
                    // isLooping = true;
                    break;
                case 2:
                    PrintData.printDataBook("Most Expensive Book",
                            BookCaseAction.findBookByPrice("expensive", listAllBook));
                    // isLooping = false;
                    break;
                case 3:
                    double price = Double.valueOf(
                            Validation.validateInput("Enter price: ", "Only number accepted", Validation.regexNumber));
                    PrintData.printDataBook("Book By Range Price " + price,
                            BookCaseAction.findBookByRangePrice(price, listAllBook));
                    // isLooping = false;
                    break;
                case 4:
                    String rating = Validation.validateInput("Enter rating: ", "Only alphabet accepted",
                            Validation.regexWord);
                    PrintData.printDataBook("Book By Rating Mangaka " + rating,
                            BookCaseAction.findBookByMangakaRating(rating, listAllBook));

                    break;
                case 5:
                    String countryPublisher = Validation.validateInput("Enter publisher country: ",
                            "Only alphabet accepted", Validation.regexWord);
                    PrintData.printDataBook("Book By Publisher Country " + countryPublisher,
                            BookCaseAction.findBookByCountry("publisher", countryPublisher, listAllBook));

                    break;
                case 6:
                    String countryAuthor = Validation.validateInput("Enter author country: ", "Only alphabet accepted",
                            Validation.regexWord);
                    PrintData.printDataBook("Book By Publisher Country " + countryAuthor,
                            BookCaseAction.findBookByCountry("author", countryAuthor, listAllBook));

                    break;
                case 7:
                    PrintData.printDataBook("Most expensive comic", BookCaseAction.findMostExpensiveComic(listAllBook));

                    break;

                case 0:

                    isLooping = false;

                    break;

            }
        } while (isLooping);

    }

    public static void authorMenu(List<CommercialBook> listAllBook) {
        String[] menuAuthor = { "Find all mangaka", "Find all author", "Find all novelis", "Find author by range age",
                "Find author by country", "Back to main menu" };
        int chooseMenu;
        boolean isLooping = true;

        do {
            PrintData.printMenu("Author Menu Searching", menuAuthor);
            chooseMenu = Integer.valueOf(Validation.validateNumberWithRange("Choose item: ", "Only number accepted",
                    Validation.regexNumber, 0, 5));

            switch (chooseMenu) {
                case 1:
                    PrintData.printDataAuthor("Data Mangaka", BookCaseAction.findAuthorByType("mangaka", listAllBook));

                    break;

                case 2:
                    PrintData.printDataAuthor("Data Author", BookCaseAction.findAllAuthor(listAllBook));

                    break;

                case 3:
                    PrintData.printDataAuthor("Data Novelis", BookCaseAction.findAuthorByType("novelis", listAllBook));

                    break;

                case 4:
                    int age1 = Integer.valueOf(Validation.validateInput("Enter age range 1: ", "Only number accepted",
                            Validation.regexNumber));
                    int age2 = Integer.valueOf(Validation.validateInput("Enter age range 2: ", "Only number accepted",
                            Validation.regexNumber));
                    PrintData.printDataAuthor("Data Author By Range Age " + age1 + " to " + age2,
                            BookCaseAction.findAuthorByRangeAge(age1, age2, listAllBook));

                    break;

                case 5:
                    String authorCountry = Validation.validateInput("Enter author country: ", "Only alphabet accepted",
                            Validation.regexWord);
                    PrintData.printDataAuthor("Data Author By Country " + authorCountry,
                            BookCaseAction.findAuthorByCountry(authorCountry, listAllBook));

                    break;

                case 0:
                    isLooping = false;
                    break;
            }
        } while (isLooping);

    }

    public static void publisherMenu(List<CommercialBook> listAllBook) {

        String[] publisherMenu = { "Most Expensive Production Cost", "Cheapest Production Cost", "Back To Main Menu" };
        int chooseMenu;
        boolean isLooping = true;

        do {
            PrintData.printMenu("Publisher Menu Searching", publisherMenu);
            chooseMenu = Integer.valueOf(Validation.validateNumberWithRange("Choose item: ", "Only number accepted",
                    Validation.regexNumber, 0, 2));

            switch (chooseMenu) {
                case 1:
                    PrintData.printDataPublisher("Most Expensive Production Cost",
                            BookCaseAction.findPubsliherProductionCost("expensive", listAllBook));
                    break;

                case 2:
                    PrintData.printDataPublisher("Cheapest Production Cost",
                            BookCaseAction.findPubsliherProductionCost("cheap", listAllBook));
                    break;

                case 0:
                    isLooping = false;
                    break;
            }
        } while (isLooping);

    }

}
