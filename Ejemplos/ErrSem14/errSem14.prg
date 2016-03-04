PF2016 Ejemplo(argumento)

vars

int x, y;

{
x:=Str2Int(argumento);
y:=0;

while(x) {
 y:=y+x;
 x:=x-1;
}

print("Resultado= " + Int2Str(y));

}


