# java -cp CUP/:Compiled/ Main Ejemplos/Ejem1/ejem1.prg

# Definimos variables de compilación
J = java
JC = javac
JLEX = JLex
CUP = CUP
LEXER = Lexer
PARSER = Parser
ERRORS = Errors
AST = AST
COMPILED = Compiled
CLASSPATH = -cp $(CUP)/:$(COMPILED)/
EJEMPLOS = Ejemplos

# PHONY, evitando conflicto de nombres
.PHONY: all errors ast clean parser lexer

# Orden de compilación según se pide en la práctica:
# 	1 : Clases del paquete Errors.
# 	2 : Clases del paquete AST que usted debe desarrollar.
# 	3 : Clases parser y sym generadas por CUP.
# 	4 : Clase Yylex generada por JLex.
# 	5 : Clase Main que se proporciona.

# Proceso completo!
all: errors ast parser lexer main

# Compilamos Errors.
errors:
	mkdir -p $(COMPILED)/$(ERRORS)
	$(JC) -d $(COMPILED) $(ERRORS)/*.java

ast:
	$(JC) -d $(COMPILED) $(AST)/*.java

# Preparamos CUP - Análisis sintáctico.
parser:
	mkdir -p $(COMPILED)/$(PARSER)
	$(J) $(CLASSPATH) java_cup.Main Parser/parser
	mv parser.java sym.java $(PARSER)
	$(JC) $(CLASSPATH) -d $(COMPILED) $(PARSER)/parser.java $(PARSER)/sym.java

# Preparamos JLex - Análisis léxico.
lexer:
	$(J) $(JLEX).Main $(LEXER)/Yylex
	$(JC) $(CLASSPATH) -d $(COMPILED) $(LEXER)/Yylex.java

# Compilamos y ejecutamos el Main. GO! Modificar a mano el fichero.
main:
	$(JC) $(CLASSPATH) -d $(COMPILED) Main.java
	#$(J) $(CLASSPATH) Main Ejemplos/Ejem1/ejem1.prg

# RM is a predefined macro in make (RM = rm -f)
clean:
	#$(RM) *.class
	$(RM) $(PARSER)/parser.java $(PARSER)/sym.java
	$(RM) $(LEXER)/Yylex.java
	$(RM) -r $(COMPILED)

# [EXTRA] Compilamos JLex solo la primera vez porque nos descargamos solo el código fuente.
#init:
#	$(JC) $(JLEX)/Main.java