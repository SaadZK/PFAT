package Compiler;

import java.util.HashMap;
import Errors.*;

public class SymbolTable {
	/* 	[Key 	-> 	Value] 
		[ident 	-> 	type] */
	private HashMap<String, Integer> table = new HashMap<String, Integer>();

	public static final int INT = 0;
	public static final int BOOL = 1;
	public static final int STRING = 2;

	/* Faltan los tipos de bool? */

	/* Adds a variable to the symbol table */
	public static void newVariableEntry(String ident, int type) throws DoubleVarDefExc {
		if (table.get(ident) == null) {
			table.put(ident, type);
		} else {
			throw DoubleVarDefExc("Variable " + ident + " is already created.");
		}
	}
	/* Returns the type of a variable named name */
	public static int getVariableType(String ident) throws VarNotFoundExc {
		int type;
		if (type = table.get(ident) == null) {
			throw DoubleVarDefExc("Variable " + ident + " doesn't exist.");
		}

		return type;
	}
}