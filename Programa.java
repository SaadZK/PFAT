import GeneratedCodeLib.Logic;
import java.util.*;

public class Programa {

	public static void Ejemplo(String arg1, String arg2) {

		int x, y;
		x = Integer.parseInt(arg1);
		y = Integer.parseInt(arg2);
		System.out.println(("Resultado= ") + (Integer.toString((x) + (y))));

	}

	public static void main(String [] args) {
		Ejemplo(args[0], args[1]);
	}
}
