package sd3.com.main;

import java.util.List;
import sd3.com.model.Name;

/**
 *
 * @author Rhys Quilter <https://github.com/RhysQuilter>
 */
public class PrintRunnable implements Runnable {

	private final List<Name> list;

	private final String pattern;

	public PrintRunnable(List<Name> list, String pattern) {
		this.list = list;
		this.pattern = pattern.toUpperCase();
	}

	@Override
	public void run() {
		for (Name name : list) {
			if (name.getName().toUpperCase().startsWith(pattern)) {
				System.out.println(name);
			}
		}
	}

}
