package Compiler;

import java.util.HashMap;
import Errors.*;

public class SymbolTable {
	/* 	[ key 	-> 	value ] 
		[ ident -> 	type  ] */
	private static HashMap <String, Integer> table = new HashMap<String, Integer>();

	public static final int INT = 0;
	public static final int BOOL = 1;
	public static final int STRING = 2;
	public static final int OTHER = -1;
	/* Other types are -1 */

	/* Adds a variable to the symbol table */
	public static void newVariableEntry(String ident, int type) throws DoubleVarDefExc {
		System.out.println("Added: " + ident + " : " + (type == 0 ? "int" : type == 1 ? "bool" : type == 2 ? "string" : "programa"));
		if (table.get(ident) == null) {
			table.put(ident, type);
		} else {
			throw new DoubleVarDefExc("Variable '" + ident + "' is already created.");
		}
	}
	
	/* Returns the type of a variable named name */
	public static int getVariableType(String ident) throws VarNotFoundExc {
		Integer type;
		System.out.println("Busqueda: " + table.get(ident));
		if ((type = table.get(ident)) == null) {
			throw new VarNotFoundExc("Variable '" + ident + "' doesn't exist.");
		}

		return type.intValue();
	}
}