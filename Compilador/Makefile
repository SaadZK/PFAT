# Makefile para agilizar el proceso de compilación

# Definimos variables de compilación
J = java
JC = javac
JLEX = JLex
CUP = CUP
LEXER = Lexer
PARSER = Parser
ERRORS = Errors
COMPILER = Compiler
AST = AST
GENERATED = GeneratedCodeLib
COMPILED = Compiled
CLASSPATH = -cp $(CUP)/:$(COMPILED)/
EJEMPLOS = Ejemplos
PRUEBAS = Pruebas
CWD = ~/Documentos/PFAT

# PHONY, evitando conflicto de nombres
.PHONY: all errors compiler ast clean parser lexer generatedcode main

# Orden de compilación según se pide en la práctica:
# 	1 : Clases del paquete Errors.
#	2 : Clases de GeneratedCodeLib
# 	3 : Clases del paquete Compiler.
# 	4 : Clases del paquete AST.
# 	5 : Clases parser y sym generadas por CUP.
# 	6 : Clase Yylex generada por JLex.
# 	7 : Clase Main que se proporciona.

# Proceso completo!
all: errors generatedcode compiler ast parser lexer main

# Compilamos Errors.
errors:
	mkdir -p $(COMPILED)/$(ERRORS)
	$(JC) -d $(COMPILED) $(ERRORS)/*.java

compiler:
	mkdir -p $(COMPILED)/$(COMPILER)
	$(JC) -d $(COMPILED) $(COMPILER)/*.java

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

# Preparamos librerías de generación de código
generatedcode:
	mkdir -p $(COMPILED)/$(GENERATED)
	$(JC) -d $(COMPILED) $(GENERATED)/*.java

# Compilamos y ejecutamos el Main. GO! Modificar a mano el fichero.
main:
	$(JC) $(CLASSPATH) -d $(COMPILED) Main.java
	#$(J) $(CLASSPATH) Main Ejemplos/Ejem1/ejem1.prg Programa
	#$(JC) Programa.java
	#$(J) Programa

examples:
	mkdir -p $(PRUEBAS)
	cp -r $(GENERATED) $(PRUEBAS)
	for number in 1 2 3 4 5 6 ; do \
        echo $(EJEMPLOS)/Ejem$$number/Ejem$$number.prg ; \
        $(J) $(CLASSPATH) Main $(EJEMPLOS)/Ejem$$number/ejem$$number.prg Ejem$$number; \
        mv -f $(CWD)/Ejem$$number.java $(CWD)/$(PRUEBAS); \
        $(JC) $(PRUEBAS)/Ejem$$number.java; \
    done
    #$(J) Pruebas/Ejem1 1

# RM is a predefined macro in make (RM = rm -f)
clean:
	#$(RM) *.class
	$(RM) $(PARSER)/parser.java $(PARSER)/sym.java
	$(RM) $(LEXER)/Yylex.java
	$(RM) -r $(COMPILED)
	$(RM) Programa.java Programa.class
	# Cuando compilamos los ejemplos se recompila GeneratedCodeLib (no tiene Classpath)
	$(RM) $(GENERATED)/*.class
	$(RM) -r $(PRUEBAS)

# [EXTRA] Compilamos JLex solo la primera vez porque nos descargamos solo el código fuente.
#init:
#	mkdir -p $(JLEX)
#	$(JC) $(JLEX)/Main.java
