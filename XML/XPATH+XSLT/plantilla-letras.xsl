<?xml version="1.0"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns="letras"
  version="1.0">
  
  <xsl:output method="xml" indent="yes" encoding="ISO-8859-1"/>
  
  <!-- 
      Apartado 2: Seleccione todos los elementos e y d hijos de a.
        <xsl:apply-templates select="descendant::e|descendant::d"/> 
      Apartado 4: Seleccione sólo los elementos d que sean hijo directo de un elemento e.
        <xsl:apply-templates select="descendant::e/d"/>
      Apartado 5: Seleccione sólo los elementos e que sean padres de elementos f que posean un atributo tipo con valor "terminal". Entre corchetes se pone la condición XPATH.
        <xsl:apply-templates select="descendant::e[f/@tipo='terminal']"/>
        NOTA: Es interesante saber que para seleccionar los e, buscamos a partir de a (descendant::e) pero ponemos entre corchetes la condición XPATH (es condición, no selección)
      Apartado 6: Seleccione sólo los elementos que sean hijo único de algún elemento (utilizando la función count()).
        <xsl:apply-templates select="descendant::*[count(child::*)=1]/*"/>
        NOTA: Da igual poner al final * o node(), con node() sale indentado y con * obtenemos todos los elementos que en este caso sabemos que es 1 (lo hemos comprobado antes)
      Apartado 7: Seleccione sólo los elementos que sean hijo en segundo grado del elemento raíz.
        <xsl:apply-templates select="child::*/child::*"/>
      
      NOTA: descendant contiene todos los nodos del elemento hacia abajo (todo el árbol), mientras que child sólo contiene el hijo directo (o hijos si ponemos *)
  -->
  <xsl:template match="/a">	
    <xsl:element name="a" >
      <xsl:apply-templates select="child::*/child::*"/>
    </xsl:element>
  </xsl:template>

  <!--
    value-of select="@*": todos los atributos
    value-of select=".": texto, es igual a text()
    <xsl:template match="*[@id='b4']">
        <xsl:value-of select="text()"/>
    </xsl:template>
  -->
  
  <!-- Apartado 3: xsl:copy sólo copia el nodo actual, pero no sus atributos. Cree un template que copie los atributos de los elementos. -->
  <xsl:template match="*">
    <xsl:copy>
      <!-- Con xsl:copy, copiamos el nodo (etiqueta nada más). Si quisiésemos imprimir todos los atributos con la estructura clave="valor", deberíamos poner aquí select="@*" (en este caso cogemos solo el "@id") y luego el siguiente template con match="@*". Si en otro caso queremos imprimir el atributo únicamente, deberíamos dejar el select con "@id" pero no hacer un match en el siguiente template de "@*"." -->
      <xsl:apply-templates select="@id"/>
    </xsl:copy>
  </xsl:template>

  <xsl:template match="@*">
    <xsl:copy/>
  </xsl:template>

</xsl:stylesheet>