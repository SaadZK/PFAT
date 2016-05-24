J = java
JC = javac
SRC = XSLTProcess
XML_LETRAS = letras.xml
XSL_LETRAS = plantilla-letras.xsl
XML_PELICULAS = Peliculas.xml
XSL_PELICULAS = Peliculas.xsl

all: peliculas

letras:
	$(JC) $(SRC).java
	$(J) $(SRC) $(XSL_LETRAS) $(XML_LETRAS)

peliculas:
	$(JC) $(SRC).java
	$(J) $(SRC) $(XSL_PELICULAS) $(XML_PELICULAS)

.PHONY: clean

clean:
	rm -f $(SRC).class
