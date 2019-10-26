import java.io.IOException;
import java.util.StringTokenizer;

public class MainThreePlusOne {
	public static void main(String args[]) // entry point from OS
	{
		MainThreePlusOne myWork = new MainThreePlusOne(); // create a dinamic instance
		myWork.Begin(); // the true entry point
	}
	
	static String ReadLn(int maxLg) // utility function to read from stdin
	{
		byte lin[] = new byte[maxLg];
		int lg = 0, car = -1;
		String line = "";

		try {
			while (lg < maxLg) {	
				car = System.in.read();
				if ((car < 0) || (car == '\n'))
					break;
				lin[lg++] += car;
			}
		} catch (IOException e) {
			return (null);
		}

		if ((car < 0) && (lg == 0))
			return (null); // eof
		return (new String(lin, 0, lg));
	}

	void Begin() {
		String input;
		StringTokenizer idata;

		while ((input = MainThreePlusOne.ReadLn(255)) != null) {
			idata = new StringTokenizer(input);
			int a = Integer.parseInt(idata.nextToken());
			int b = Integer.parseInt(idata.nextToken());
			int min;
			int max;
			if (a < b) {
				min = a;
				max = b;
			} else {
				min = b;
				max = a;
			}
			int cyclemax = 0;

			for (int k = min; k <= max; k++)
				cyclemax = Math.max(cyclemax, MainThreePlusOne.algorithm(k));

			System.out.println(a + " " + b + " " + cyclemax);
		}
	}

	private static int algorithm(int k) {
		if (k == 1)
			return 1;

		if (k % 2 == 0) {
			return MainThreePlusOne.algorithm(k / 2) + 1;
		} else {
			return MainThreePlusOne.algorithm(3 * k + 1) + 1;
		}
	}
}
