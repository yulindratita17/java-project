package bookproject.model;

import java.util.List;

import bookproject.abstracts.CommercialBook;

public class PrintData {
	

	public static void printMenu(String title, String[] listMenu) {
		int number = 1;
		String formatTabel = "| %-4s | %-30s |%n";
		System.out.println("=========" + title + "=========");

		for (String menu : listMenu) {
			if (number == listMenu.length) {
				System.out.printf(formatTabel, 0, menu);
			} else {
				System.out.printf(formatTabel, number, menu);
			}
			number++;
		}
	}

	public static void printDataBook(String tittle, List<CommercialBook> listData) {
		int num = 1;
		String formatTabel = "| %-4s | %-12s | %-55s | %-25s | %-22s | %-5s | %n";
		System.out.println("\n==============================================================================================================================================");
		System.out.printf("| %-138s |%n", tittle);
		System.out.println("==============================================================================================================================================");
		System.out.printf(formatTabel, "No", "Book Code", "Tittle", "Author", "Publisher", "Price");
		System.out.println("==============================================================================================================================================");

		for (CommercialBook data : listData) {
			System.out.printf(formatTabel, num, data.getBookCode(), data.getTittle(), data.getAuthor().getFullName(),
					data.getPublisher().getPublisherName(), String.format("%.2f",data.getPrice()));
			num++;
		}
		System.out.println("==============================================================================================================================================\n");
	}

	public static void printDataAuthor(String tittle, List<Author> listData) {
		int num = 1;
		String formatTabel = "| %-4s | %-10s | %-10s | %-20s | %-15s | %-5s |%n";
		System.out.println("\n===================================================================================");
		System.out.printf("| %-79s |%n", tittle);
		System.out.println("===================================================================================");
		System.out.printf(formatTabel, "No", "First Name", "Last Name", "Full Name", "Country", "Age");
		System.out.println("===================================================================================");

		for (Author data : listData) {
			System.out.printf(formatTabel, num, data.getFirstName(), data.getLastName(), data.getFullName(),data.getCountry(), data.getAge());
			num++;
		}

		System.out.println("===================================================================================\n");
	}

	public static void printDataPublisher(String tittle, List<Publisher> listData) {
		int num = 1;
		String formatTabel = "| %-4s | %-25s | %-15s | %-15s | %n";
		System.out.println("\n===================================================================================");
		System.out.printf("| %-79s |%n", tittle);
		System.out.println("===================================================================================");
		System.out.printf(formatTabel, "No", "Publisher Name", "Country", "Production Cost");
		System.out.println("===================================================================================");

		for (Publisher data : listData) {
			System.out.printf(formatTabel, num, data.getPublisherName(), data.getCountry(), data.getProductionCost());
			num++;
		}

		System.out.println("===================================================================================\n");
	}
}
