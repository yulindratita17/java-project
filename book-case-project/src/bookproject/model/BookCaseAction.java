package bookproject.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bookproject.abstracts.CommercialBook;

public class BookCaseAction {
    public static List<CommercialBook> findBookByPrice(String type, List<CommercialBook> listAllBooks) {
        List<CommercialBook> result = new ArrayList<>();
        List<Double> priceTemp = new ArrayList<>();

        for (CommercialBook commercialBook : listAllBooks) {
            priceTemp.add(commercialBook.getPrice());
        }

        double min = Collections.min(priceTemp);
        double max = Collections.max(priceTemp);

        for (CommercialBook commercialBook : listAllBooks) {
            if (type.equalsIgnoreCase("expensive")) {
                if (commercialBook.getPrice() == max) {
                    result.add(commercialBook);
                }
            } else if (type.equalsIgnoreCase("cheap")) {
                if (commercialBook.getPrice() == min) {
                    result.add(commercialBook);
                }
            }

        }

        return result;
    }

    public static List<CommercialBook> findBookByRangePrice(double price, List<CommercialBook> listAllBooks) {
        List<CommercialBook> result = new ArrayList<>();
        for (CommercialBook commercialBook : listAllBooks) {
            if (commercialBook.getPrice() <= price) {
                result.add(commercialBook);
            }
        }
        return result;
    }

    public static List<CommercialBook> findBookByMangakaRating(String rating, List<CommercialBook> listAllBook) {
        List<CommercialBook> result = new ArrayList<>();
        List<Author> listAllAuthor = new ArrayList<>();

        for (CommercialBook commercialBook : listAllBook) {
            if (commercialBook.getAuthor() instanceof Mangaka) {
                listAllAuthor.add(commercialBook.getAuthor());
                for (Author author : listAllAuthor) {
                    if (author instanceof Mangaka) {
                        if (((Mangaka) author).getRating().equalsIgnoreCase(rating)) {
                            if (!result.contains(commercialBook)) {
                                result.add(commercialBook);
                            }

                        }
                    }
                }

            }
        }
        return result;
    }

    public static List<CommercialBook> findBookByCountry(String type, String country,
            List<CommercialBook> listAllBook) {
        List<CommercialBook> result = new ArrayList<>();

        for (CommercialBook commercialBook : listAllBook) {
            if (type.equalsIgnoreCase("publisher")) {
                if (commercialBook.getPublisher().getCountry().equalsIgnoreCase(country)) {
                    result.add(commercialBook);
                }
            } else if (type.equalsIgnoreCase("author")) {
                if (commercialBook.getAuthor().getCountry().equalsIgnoreCase(country)) {
                    result.add(commercialBook);
                }

            }

        }
        return result;
    }

    public static List<CommercialBook> findMostExpensiveComic(List<CommercialBook> listAllBook) {
        List<CommercialBook> result = new ArrayList<>();
        List<Double> tempPrice = new ArrayList<>();

        for (CommercialBook commercialBook : listAllBook) {
            if (commercialBook instanceof Comic) {
                tempPrice.add(commercialBook.getPrice());
                double max = Collections.max(tempPrice);
                if (commercialBook.getPrice() == max) {
                    result.add(commercialBook);
                }
            }
        }

        return result;
    }

    // ================== menu author

    public static List<Author> findAllAuthor(List<CommercialBook> listAllBook) {
        List<Author> result = new ArrayList<>();

        for (CommercialBook commercialBook : listAllBook) {
            if (!result.contains(commercialBook.getAuthor())) {
                result.add(commercialBook.getAuthor());
            }

        }

        return result;
    }

    public static List<Author> findAuthorByType(String type, List<CommercialBook> listAllBook) {
        List<Author> listAuthor = findAllAuthor(listAllBook);
        List<Author> result = new ArrayList<>();

        for (Author author : listAuthor) {
            if (type.equalsIgnoreCase("mangaka")) {
                if (author instanceof Mangaka) {
                    if (!result.contains(author)) {
                        result.add(author);
                    }
                }
            } else if (type.equalsIgnoreCase("novelis")) {
                if (author instanceof Novelis) {
                    if (!result.contains(author)) {
                        result.add(author);
                    }
                }
            }

        }

        return result;
    }

    public static List<Author> findAuthorByRangeAge(int age1, int age2, List<CommercialBook> listAllBook) {
        List<Author> listAuthor = findAllAuthor(listAllBook);
        List<Author> result = new ArrayList<>();

        for (Author author : listAuthor) {
            if (author.getAge() >= age1 && author.getAge() <= age2) {
                if (!result.contains(author)) {
                    result.add(author);
                }
            }
        }
        return result;
    }

    public static List<Author> findAuthorByCountry(String country, List<CommercialBook> listAllBook) {
        List<Author> listAuthor = findAllAuthor(listAllBook);
        List<Author> result = new ArrayList<>();

        for (Author author : listAuthor) {
            if (author.getCountry().equalsIgnoreCase(country)) {
                if (!result.contains(author)) {
                    result.add(author);
                }
            }
        }
        return result;
    }

    public static List<Publisher> findPubsliherProductionCost(String type, List<CommercialBook> listAllBook) {
        List<Publisher> result = new ArrayList<>();
        List<Double> tempCost = new ArrayList<>();

        for (CommercialBook commercialBook : listAllBook) {
            tempCost.add(commercialBook.getPublisher().getProductionCost());
        }

        double min = Collections.min(tempCost);
        double max = Collections.max(tempCost);

        for (CommercialBook commercialBook : listAllBook) {

            if (type.equalsIgnoreCase("expensive")) {

                if (commercialBook.getPublisher().getProductionCost() == max) {
                    if (!result.contains(commercialBook.getPublisher())) {
                        result.add(commercialBook.getPublisher());
                    }

                }
            } else if (type.equalsIgnoreCase("cheap")) {

                if (commercialBook.getPublisher().getProductionCost() == min) {
                    if (!result.contains(commercialBook.getPublisher())) {
                        result.add(commercialBook.getPublisher());
                    }

                }
            }
        }

        return result;
    }

}
