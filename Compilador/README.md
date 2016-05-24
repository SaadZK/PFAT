# Compilador #

## Definición del lenguaje ##

### Gramática
```
#!text
G = <ET, EN, S, P>

ET = {PC, ASOP, IF, THEN, ELSE, ENDIF, WHILE, PRINT, INT2STR, STR2INT, THENX, NOT, MENORQUE, MAS, MENOS, UMENOS, POR, DIV, AND, OR, IGUALQUE, MAYORQUE, PAREN, TESIS, PROG, ABRELLAVE, CIERRALLAVE, COMA, VARS, TIPO, CENT, CLOG, CST, IDENT}

EN = { S, <VDef>, <Decl>, <LVar>, <Body>, <Sent>, <SentSimp>, <SentList>, <Print>, <Asign>, <Cond>, <Repet>, <Exp> }

S = S

P = {
	S -> PROG IDENT PAREN <LVar> TESIS <Body> 
	    | PROG IDENT <Body>
	    | PROG IDENT VARS <VDef> <Body>
	    | PROG IDENT PAREN <LVar> TESIS VARS <VDef> <Body>

	<VDef> -> <Decl> PC 
	    | <Decl> PC <VDef>

	<Decl> -> TIPO <LVar>

	<LVar> -> IDENT
	    |   IDENT COMA <LVar>

	<Body> -> <Sent>

	<Sent> -> <SentSimp>
		|	ABRELLAVE <SentList> CIERRALLAVE

	<SentSimp> -> <Asign> PC
		|   <Cond>
		|   <Repet>
	    |   <Print> PC

	<SentList> -> <SentSimp>
		|	<SentList> <SentSimp>

	<Print>-> PRINT PAREN <Exp> TESIS

	<Asign>-> IDENT ASOP <Exp>

	<Cond>-> IF <Exp> THEN <Sent> ENDIF 
	    |   IF <Exp> THEN <Sent> ELSE <Sent> ENDIF 
	    |   IF <Exp> THEN <Sent> THENX <Sent> ELSE <Sent> ENDIF 

	<Repet>-> WHILE <Exp> <Sent>

	<Exp> -> CENT
		|	CST
		|	CLOG
		|	IDENT
		| 	PAREN <Exp> TESIS
		| 	<Exp> MAS <Exp>
		| 	<Exp> MENOS <Exp>
		| 	<Exp> POR <Exp>
		| 	<Exp> DIV <Exp>
		| 	MENOS <Exp>
		| 	STR2INT PAREN <Exp> TESIS
		| 	INT2STR PAREN <Exp> TESIS
		| 	<Exp> OR <Exp>
		| 	<Exp> AND <Exp>
		| 	NOT <Exp>
		| 	<Exp> IGUALQUE <Exp>
		| 	<Exp> MENORQUE <Exp>
		| 	<Exp> MAYORQUE <Exp>
}
```

### Mapeo de variables ###
| Variable  | Valor        |
| --------- | -------------|
| int 	 	| Integer(**0**) |
| bool 	 	| Integer(**1**) |
| string 	| Integer(**2**) |

### Mapeo de bool ###
| Variable  | Valor        |
| --------- | -------------|
| true 	 	| Integer(**0**) |
| false 	| Integer(**1**) |
| unk 		| Integer(**2**) |


## Desarrollo del compilador ##

### Comandos para compilar ###
```
#!bash
# Errors
mkdir -p Compiled/Errors
javac -d Compiled Errors/*.java

# GeneratedCodeLib
mkdir -p Compiled/GeneratedCodeLib
javac -d Compiled GeneratedCodeLib/*.java

# Compiler
mkdir -p Compiled/Compiler
javac -d Compiled Compiler/*.java

# ASTs
javac -d Compiled AST/*.java

# Parser
mkdir -p Compiled/Parser
java -cp CUP/:Compiled/ java_cup.Main Parser/parser
mv parser.java sym.java Parser
javac -cp CUP/:Compiled/ -d Compiled Parser/parser.java Parser/sym.java

# Lexer
java JLex.Main Lexer/Yylex
javac -cp CUP/:Compiled/ -d Compiled Lexer/Yylex.java

# Main
javac -cp CUP/:Compiled/ -d Compiled Main.java

# Examples (6 times for each file)
java -cp CUP/:Compiled/ Main Ejemplos/Ejem1/ejem1.prg Programa
javac Programa.java
java Programa <args>

```

### Comandos Makefile ###
```
#!bash
# Compilar JLex la primera vez
make init

# Compilar el principal
make

# Compilar ejemplos
make examples

# Probar ejemplos
cd Pruebas
java Ejem1 5
java Ejem2 10
java Ejem3 -2
java Ejem4 Luis
java Ejem5 Hola
java Ejem6 1 1

# Eliminar ficheros
make clean
```