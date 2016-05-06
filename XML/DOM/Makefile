J = java
JC = javac
SRC = Films
ARGS = Peliculas.xml
NEW = Modificado.xml

all: films

list: films _list
List: films _List
add: films _add

films:
	$(JC) $(SRC).java

_list:
	$(J) $(SRC) -l $(ARGS)

_List:
	$(J) $(SRC) -L $(ARGS)	

_add:
	$(J) $(SRC) -a $(ARGS)

.PHONY: clean
clean:
	rm -f $(SRC).class
	rm -f $(NEW)
