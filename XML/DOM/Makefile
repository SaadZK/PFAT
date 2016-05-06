SRC = Films
ARGS = ../XML+DTD/Peliculas.xml

all: films

films:
	javac $(SRC).java

list: films _list
List: films _List
add: films _add

_list:
	java $(SRC) -l $(ARGS)

_List:
	java $(SRC) -L $(ARGS)	

_add:
	java $(SRC) -a $(ARGS)

.PHONY: clean
clean:
	rm -f Films.class
