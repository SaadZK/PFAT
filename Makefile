# Definimos variables de compilación
J = java
JC = javac
JFLAGS = -g -d
JLEX = JLex
CUP = CUP
LEXER = Lexer
PARSER = Parser
CLASSPATH = -cp $(PWD)/:$(JLEX)/:$(CUP)/:Compiled/
LEXER_CREATED = Yylex.java
PARSER_CREATED = parser.java sym.java

# Declaramos classpath si no está definido.
#ifndef CLASSPATH
#export CLASSPATH = $(PWD)
#endif

# PHONY, evitando conflicto de nombres
.PHONY: all clean parser

# Suffixes for Java compilation
.SUFFIXES: .java .class

# Here is our target entry for creating .class files from .java files 
# This is a target entry that uses the suffix rule syntax:
#	DSTS:
#		rule
#  'TS' is the suffix of the target file, 'DS' is the suffix of the dependency 
#  file, and 'rule'  is the rule for building a target	
# '$*' is a built-in macro that gets the basename of the current target 
# Remember that there must be a < tab > before the command line ('rule') 
#
.java.class:
	$(JC) $(JFLAGS) $*.java

# CLASSES is a macro consisting of multiple words (one for each java source file) using '\'.
CLASSES = Main.java

# the default make target entry
default: classes

# This target entry uses Suffix Replacement within a macro: 
# $(name:string1=string2)
# 	In the words in the macro named 'name' replace 'string1' with 'string2'
# Below we are replacing the suffix .java of all words in the macro CLASSES 
# with the .class suffix
classes: $(CLASSES:.java=.class)

# Preparamos JLex - Análisis léxico.
lexer:
	$(J) $(JLEX).Main Lexer/Yylex
	mv $(LEXER_CREATED) $(LEXER)

# Preparamos CUP - Análisis sintáctico.
parser:
	$(J) -cp ./CUP java_cup.Main Parser/parser
	mv $(PARSER_CREATED) $(PARSER)

main:
	$(JC) $(CLASSPATH) Main.java

# RM is a predefined macro in make (RM = rm -f)
clean:
	#$(RM) *.class
	$(RM) $(PARSER)/$(PARSER_CREATED)