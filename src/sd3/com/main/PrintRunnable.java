package sd3.com.main;

import java.util.List;
import sd3.com.model.Name;

/**
 *
 * @author Rhys Quilter <https://github.com/RhysQuilter>
 */

/*
	Write and execute a Runnable that will accept a pattern/prefix as an argument. The runnable will
	then print all the names (that begin with the pattern) along with their rank.
	For example, if the pattern/prefix is “alva”, the following are the matching names along with their
	rank.
*/
public class PrintRunnable implements Runnable {

	private final List<Name> list;

	private final String pattern; // this is used as its asking for the pattern

	public PrintRunnable(List<Name> list, String pattern) { // filling the runnable with the info
		this.list = list;
		this.pattern = pattern.toUpperCase(); //uppercase is used since the file document is using capitals
	}

	@Override
	public void run() {
		for (Name name : list) {
			if (name.getName().toUpperCase().startsWith(pattern)) { // uppercase is also used here for overkill purposes
				System.out.println(name);							// Startswith is used as the spec says StartsWith in it.
			}
		}
	}

}
