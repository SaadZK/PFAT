# Prácticas de PFAT #
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
| int 	 	| Integer -> 0 |
| bool 	 	| Integer -> 1 |
| string 	| Integer -> 2 |

### Mapeo de bool ###
| Variable  | Valor        |
| --------- | -------------|
| true 	 	| Integer -> 0 |
| false 	| Integer -> 1 |
| unk 		| Integer -> 2 |

### Comandos para compilar ###
```
#!bash
# Preparamos JLex - Análisis léxico.
java JLex.Main Yylex

# Preparamos CUP - Análisis sintáctico.
java -cp ./CUP java_cup.Main parser

# Compilamos Errors.
javac -d dist Errors/*.java

# Compilamos los AST.
javac -d dist AST/src/AST/*.java

# Unimos los ficheros CUP.
javac -d workspace -cp JLex/:CUP/:classes/ parser.java sym.java

# Compilamos el Main principal.
javac -d workspace -cp JLex/:CUP/:classes/ classes/Main.java

```