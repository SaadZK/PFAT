J = java
JC = javac
SRC = Validate
XML = Peliculas.xml

all: peliculas

peliculas:
	$(JC) $(SRC).java
	$(J) $(SRC) $(XML)

.PHONY: clean

clean:
	rm -f *.class
