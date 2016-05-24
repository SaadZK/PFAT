# Prácticas de PFAT #

## Estructura de ficheros ##
```
#!text
.
├── Compilador
│   ├── AST
│   │   ├── Asign.java
│   │   ├── Body.java
│   │   ├── Cond1.java
│   │   ├── Cond2.java
│   │   ├── Cond3.java
│   │   ├── Cond.java
│   │   ├── Decl.java
│   │   ├── Exp10_Opuesto.java
│   │   ├── Exp11_Str2Int.java
│   │   ├── Exp12_Int2Str.java
│   │   ├── Exp13_Or.java
│   │   ├── Exp14_And.java
│   │   ├── Exp15_Not.java
│   │   ├── Exp16_Igual.java
│   │   ├── Exp17_Menor.java
│   │   ├── Exp18_Mayor.java
│   │   ├── Exp1_Entero.java
│   │   ├── Exp2_String.java
│   │   ├── Exp3_Boolean.java
│   │   ├── Exp4_Ident.java
│   │   ├── Exp5_Parentesis.java
│   │   ├── Exp6_Suma.java
│   │   ├── Exp7_Resta.java
│   │   ├── Exp8_Multiplicacion.java
│   │   ├── Exp9_Division.java
│   │   ├── Exp.java
│   │   ├── LVar1.java
│   │   ├── LVar2.java
│   │   ├── LVar.java
│   │   ├── Print.java
│   │   ├── Repet.java
│   │   ├── S1.java
│   │   ├── S2.java
│   │   ├── S3.java
│   │   ├── S4.java
│   │   ├── Sent1.java
│   │   ├── Sent2.java
│   │   ├── Sent.java
│   │   ├── SentList1.java
│   │   ├── SentList2.java
│   │   ├── SentList.java
│   │   ├── SentSimp1.java
│   │   ├── SentSimp2.java
│   │   ├── SentSimp3.java
│   │   ├── SentSimp4.java
│   │   ├── SentSimp.java
│   │   ├── S.java
│   │   ├── VDef1.java
│   │   ├── VDef2.java
│   │   └── VDef.java
│   ├── Compiler
│   │   └── SymbolTable.java
│   ├── CUP
│   │   ...
│   ├── Ejemplos
│   │   ├── Ejem1
│   │   │   ├── ejecucion.txt
│   │   │   └── ejem1.prg
│   │   ├── Ejem2
│   │   │   ├── ejecucion.txt
│   │   │   └── ejem2.prg
│   │   ├── Ejem3
│   │   │   ├── ejecucion.txt
│   │   │   └── ejem3.prg
│   │   ├── Ejem4
│   │   │   ├── ejecucion.txt
│   │   │   └── ejem4.prg
│   │   ├── Ejem5
│   │   │   ├── ejecucion.txt
│   │   │   └── ejem5.prg
│   │   ├── Ejem6
│   │   │   ├── ejecucion.txt
│   │   │   └── ejem6.prg
│   │   ├── ErrLex1
│   │   │   └── errLex1.prg
│   │   ├── ErrLex2
│   │   │   └── errLex2.prg
│   │   ├── ErrSem1
│   │   │   └── errSem1.prg
│   │   ├── ErrSem10
│   │   │   └── errSem10.prg
│   │   ├── ErrSem11
│   │   │   └── errSem11.prg
│   │   ├── ErrSem12
│   │   │   └── errSem12.prg
│   │   ├── ErrSem13
│   │   │   └── errSem13.prg
│   │   ├── ErrSem14
│   │   │   └── errSem14.prg
│   │   ├── ErrSem2
│   │   │   └── errSem2.prg
│   │   ├── ErrSem3
│   │   │   ├── errSem3.pf2011
│   │   │   └── errSem3.prg
│   │   ├── ErrSem4
│   │   │   └── errSem4.prg
│   │   ├── ErrSem5
│   │   │   └── errSem5.prg
│   │   ├── ErrSem6
│   │   │   └── errSem6.prg
│   │   ├── ErrSem7
│   │   │   └── errSem7.prg
│   │   ├── ErrSem8
│   │   │   └── errSem8.prg
│   │   ├── ErrSem9
│   │   │   └── errSem9.prg
│   │   ├── ErrSint1
│   │   │   └── errSint1.prg
│   │   ├── ErrSint2
│   │   │   └── errSint2.prg
│   │   ├── ErrSint3
│   │   │   └── errSint3.prg
│   │   └── ErrSint4
│   │       └── errSint4.prg
│   ├── Enunciados
│   │   ├── IntroduccionCUP.pdf
│   │   ├── IntroduccionJLex.pdf
│   │   ├── Practica0.pdf
│   │   ├── Practica1.pdf
│   │   ├── Practica2.pdf
│   │   └── Practica3.pdf
│   ├── Errors
│   │   ├── CompilerExc.java
│   │   ├── DoubleVarDefExc.java
│   │   ├── IncorrectConditionExc.java
│   │   ├── IncorrectTypesExc.java
│   │   ├── LexerException.java
│   │   └── VarNotFoundExc.java
│   ├── GeneratedCodeLib
│   │   └── Logic.java
│   ├── JLex
│   │   ...
│   ├── Lexer
│   │   └── Yylex
│   ├── Main.java
│   ├── Makefile
│   └── Parser
│       └── parser
├── README.md
├── SJS.xml
└── XML
    ├── DOM
    │   └── Practica6.pdf
    ├── XML+DTD
    │   ├── Peliculas.dtd
    │   ├── Peliculas.xml
    │   ├── Practica4.pdf
    │   └── Validate.java
    └── XPATH+XLTS
        └── Practica5.pdf

46 directories, 229 files
```
