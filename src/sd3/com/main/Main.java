package sd3.com.main;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import static sd3.com.io.FileIO.parseFile;
import sd3.com.model.Name;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		System.out.println("Main begins at:" + new Date());

		var list = parseFile("TX.txt");

		ExecutorService executorService = Executors.newCachedThreadPool();

		System.out.printf("Starting Program with %d records.%n", list.size());
		/*Task 1*/
		var city = "Dallas";
		var lowerLimit = 3.757D;
				var upperLimit = 6.245D;

		SearchCallable searchCallable = new SearchCallable(list, city, lowerLimit, upperLimit);
		Future<List<Name>> searchFuture = executorService.submit(searchCallable);

		List<Name> results = searchFuture.get();

		if (results.isEmpty()) {
			System.out.printf("no records found for %s, %d, %d .%n", city, lowerLimit, upperLimit);
		} else {
			for (Name name : results) {
				System.out.println(name);
			}
		}
		try ( var scanner = new Scanner(System.in);) {
			System.out.println("Press any key to quit.");
			scanner.next();
		}

		executorService.shutdownNow();
		System.out.println("Goodbye.");
	}
}
