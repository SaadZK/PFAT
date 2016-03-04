PF2016 Ejemplo(argumento)

vars

int x, y, t;
bool z;

{
x:=Str2Int(argumento);
y:=0;

if (x>0) 
then z:= true;
else if (x=0)
     then z:= unk;
     else z:= false;
     endif
endif

while(x > 0) {
 y:=y+x;
 x:=x-1;
}

print("Resultado= " + Int2Str(y));

if (z) 
then print("Argumento mayor que 0");
thenx print("Argumento igual a 0");
else print("Argumento menor que 0");
endif

}


