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
# Errors
mkdir -p Compiled/Errors
javac -d Compiled Errors/*.java

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

# Main: IMPORTANTE!
javac -cp CUP/:Compiled/ -d Compiled Main.java
java -cp CUP/:Compiled/ Main Ejemplos/Ejem1/ejem1.prg
```

### Estructura de ficheros ###
```
#!text
.
├── AST
│   ├── Asign.java
│   ├── Body.java
│   ├── Cond1.java
│   ├── Cond2.java
│   ├── Cond3.java
│   ├── Cond.java
│   ├── Decl.java
│   ├── Exp10_Opuesto.java
│   ├── Exp11_Str2Int.java
│   ├── Exp12_Int2Str.java
│   ├── Exp13_Or.java
│   ├── Exp14_And.java
│   ├── Exp15_Not.java
│   ├── Exp16_Igual.java
│   ├── Exp17_Menor.java
│   ├── Exp18_Mayor.java
│   ├── Exp1_Entero.java
│   ├── Exp2_String.java
│   ├── Exp3_Boolean.java
│   ├── Exp4_Ident.java
│   ├── Exp5_Parentesis.java
│   ├── Exp6_Suma.java
│   ├── Exp7_Resta.java
│   ├── Exp8_Multiplicacion.java
│   ├── Exp9_Division.java
│   ├── Exp.java
│   ├── LVar1.java
│   ├── LVar2.java
│   ├── LVar.java
│   ├── Print.java
│   ├── Repet.java
│   ├── S1.java
│   ├── S2.java
│   ├── S3.java
│   ├── S4.java
│   ├── Sent1.java
│   ├── Sent2.java
│   ├── Sent.java
│   ├── SentList1.java
│   ├── SentList2.java
│   ├── SentList.java
│   ├── SentSimp1.java
│   ├── SentSimp2.java
│   ├── SentSimp3.java
│   ├── SentSimp4.java
│   ├── SentSimp.java
│   ├── S.java
│   ├── VDef1.java
│   ├── VDef2.java
│   └── VDef.java
├── Compiled
│   ├── AST
		...
│   ├── Errors
│   │   ...
│   ├── Lexer
│   │   └── Yylex.class
│   ├── Main.class
│   └── Parser
│       ├── CUP$parser$actions.class
│       ├── parser.class
│       └── sym.class
├── CUP
│	...
├── Ejemplos
│   ├── Ejem1
│   │   └── ejem1.prg
│   ├── Ejem2
│   │   └── ejem2.prg
│   ├── Ejem3
│   │   └── ejem3.prg
│   ├── Ejem4
│   │   └── ejem4.prg
│   ├── Ejem5
│   │   └── ejem5.prg
│   ├── ErrLex1
│   │   └── errLex1.prg
│   ├── ErrLex2
│   │   └── errLex2.prg
│   ├── ErrSem1
│   │   └── errSem1.prg
│   ├── ErrSem10
│   │   └── errSem10.prg
│   ├── ErrSem11
│   │   └── errSem11.prg
│   ├── ErrSem12
│   │   └── errSem12.prg
│   ├── ErrSem13
│   │   └── errSem13.prg
│   ├── ErrSem14
│   │   └── errSem14.prg
│   ├── ErrSem2
│   │   └── errSem2.prg
│   ├── ErrSem3
│   │   └── errSem3.prg
│   ├── ErrSem4
│   │   └── errSem4.prg
│   ├── ErrSem5
│   │   └── errSem5.prg
│   ├── ErrSem6
│   │   └── errSem6.prg
│   ├── ErrSem7
│   │   └── errSem7.prg
│   ├── ErrSem8
│   │   └── errSem8.prg
│   ├── ErrSem9
│   │   └── errSem9.prg
│   ├── ErrSint1
│   │   └── errSint1.prg
│   ├── ErrSint2
│   │   └── errSint2.prg
│   ├── ErrSint3
│   │   └── errSint3.prg
│   └── ErrSint4
│       └── errSint4.prg
├── Enunciados
│   ├── IntroduccionCUP.pdf
│   ├── IntroduccionJLex.pdf
│   ├── Practica0.pdf
│   ├── Practica1.pdf
│   ├── Practica2.pdf
│   └── Practica4.pdf
├── Errors
│   ├── CompilerExc.java
│   └── LexerException.java
├── JLex
│	...
├── Lexer
│   ├── Yylex
│   └── Yylex.java
├── Main.java
├── Makefile
├── Parser
│   ├── parser
│   ├── parser.java
│   └── sym.java
└── README.md

43 directories, 268 files
```