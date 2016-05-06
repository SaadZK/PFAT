SRC = Films
ARGS = ../XML+DTD/Peliculas.xml

all: films

films:
	javac $(SRC).java
	
list:
	java $(SRC) -l $(ARGS+)

List:
	java $(SRC) -L $(ARGS)	

add:
	java $(SRC) -a $(ARGS)

.PHONY: clean
clean:
	rm -f Films.class
