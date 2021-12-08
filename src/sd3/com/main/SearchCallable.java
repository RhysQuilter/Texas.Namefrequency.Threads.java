package sd3.com.main;

import java.util.List;
import java.util.concurrent.Callable;
import sd3.com.model.Name;

/**
 *
 * @author Rhys Quilter <https://github.com/RhysQuilter>
 */
public class SearchCallable implements Callable<List<Name>> {

	private final List<Name> namesList;
	private final String city;
	private final double lowerLimit;
	private final double upperLimit;

	public SearchCallable(List<Name> namesList, String city, double lowerLimit, double upperLimit) {
		this.namesList = namesList;
		this.city = city;
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
	}

	@Override
	public List<Name> call() throws Exception {
		return namesList.stream()
				.filter(name -> name.getCity().equalsIgnoreCase(city))
				.filter(name -> name.getCumulativeFrequency() <= lowerLimit)
				.filter(name -> name.getCumulativeFrequency() >= upperLimit)
				.toList();
	}
}
