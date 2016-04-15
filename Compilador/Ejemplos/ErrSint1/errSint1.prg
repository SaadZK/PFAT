PF2016 Ejemplo(argumento)

vars

int x, y, i;
bool b1, b2;
string res;

int tmp1, cota;

{
x:=Str2Int(argumento);

res:="";

b1:= true;

y:= 1;

if (x > 0) 
then y:= x;
endif

while(b1) {
  tmp1:= y/2;
  if (tmp1 * 2 = y) 
  then {
    y:= tmp1;
    if (res="")
    then res:= "2";
    else res:= res + "; 2";
    endif;
    print("2 es factor primo de " + argumento);
  } else b1:= unk;
  endif
}

b1:= true;

i:=3;

while(b1) {
  cota:=10;
  while (cota*cota < y) {
    cota:= cota * 10;
  }
  b2:= true;
  while (((i< cota) or (i = cota)) and b2) {
    tmp1:=y/i;
    if (tmp1*i = y)
    then {
      y:= tmp1;
      b2:= false;
      if (res="")
      then res:= Int2Str(i);
      else res:= res + "; " + Int2Str(i);
      endif
      print(Int2Str(i) + " es factor primo de " + argumento);
    } else i:=i + 2;
    endif  
  }  
  if (i > cota)
  then b1:= false;
  endif
}

if (y>1) then 
  if (res="")
  then res:= argumento;
  else res:=res + "; " + Int2Str(y);
  endif
endif

print("Los factores primos de " + argumento + " son: " + res);

}


