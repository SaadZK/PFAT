PF2016 Ejemplo(argumento)

vars

int x, y;
bool z;
string s;

{
x:=1;
y:=2;

s:= "Hola " + argumento;

print(s);

print("Resultado 1= " + Int2Str(-(4 + 1)));
print("Resultado 2= " + Int2Str(-4 + 5));
print("Resultado 3= " + Int2Str(100/20/2));
print("Resultado 4= " + Int2Str((100/20)/2));
print("Resultado 5= " + Int2Str(100-20-2));
print("Resultado 6= " + Int2Str((100-20)-2));
print("Resultado 7= " + Int2Str(100 * 20 / 2));

z:=false and true or false;

if z then
   print("Resultado 8 incorrecto");
else
   print("Resultado 8 correcto");
endif

z:=true and not true or false;

if z then
   print("Resultado 9 incorrecto");
else
   print("Resultado 9 correcto");
endif

z:= true = x = y;

if z then
   print("Resultado 10 incorrecto");
else
   print("Resultado 10 correcto");
endif

z:= (x < y);

if z then
   print("Resultado 11 correcto");
else
   print("Resultado 11 incorrecto");
endif

z:= (x + 2 > y);

if z then
   print("Resultado 12 correcto");
else
   print("Resultado 12 incorrecto");
endif

}


