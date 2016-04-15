PF2016 Ejemplo(argumento)

vars

bool x;

{
x:= not unk;

if (x = unk) 
then print("Resultado 1 correcto");
else print("Resultado 1 incorrecto");
endif

x:= true or unk;

if (x = true) 
then print("Resultado 2 correcto");
else print("Resultado 2 incorrecto");
endif

x:= unk or true;

if (x = true) 
then print("Resultado 3 correcto");
else print("Resultado 3 incorrecto");
endif


x:= unk or unk;

if (x = unk) 
then print("Resultado 4 correcto");
else print("Resultado 4 incorrecto");
endif


x:= unk or false;

if (x = unk) 
then print("Resultado 5 correcto");
else print("Resultado 5 incorrecto");
endif


x:= false or unk;

if (x = unk) 
then print("Resultado 6 correcto");
else print("Resultado 6 incorrecto");
endif

x:= true and unk;

if (x = unk) 
then print("Resultado 7 correcto");
else print("Resultado 7 incorrecto");
endif

x:= unk and true;

if (x = unk) 
then print("Resultado 8 correcto");
else print("Resultado 8 incorrecto");
endif


x:= unk and unk;

if (x = unk) 
then print("Resultado 9 correcto");
else print("Resultado 9 incorrecto");
endif


x:= unk and false;

if (x = false) 
then print("Resultado 10 correcto");
else print("Resultado 10 incorrecto");
endif


x:= false and unk;

if (x = false) 
then print("Resultado 11 correcto");
else print("Resultado 11 incorrecto");
endif

}


