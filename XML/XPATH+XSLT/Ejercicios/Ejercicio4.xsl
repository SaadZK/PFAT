<?xml version="1.0"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns="letras"
  version="1.0">

  <xsl:output method="xml" indent="yes" encoding="ISO-8859-1"/>
  <!--  Copie sólo los elementos que sean el segundo hijo elemento de algún elemento.
        No se copia el contenido de los elementos copiados.
        Suponemos que si un nodo tiene varios hijos, cogemos el segundo siempre.
        Al igual que el apartado 2 (nos basamos en él), habría otra alternativa menos clara.
  -->
  <xsl:template match="/">
    <!-- The position of the node is is 1-based, so the first node returns a position of 1. -->
    <xsl:apply-templates select="descendant::*/child::*[position()=2]"/>
  </xsl:template>

  <xsl:template match="*">
    <xsl:copy/>
  </xsl:template>

</xsl:stylesheet>
