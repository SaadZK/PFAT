<?xml version="1.0"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns="letras"
  version="1.0">

  <xsl:output method="xml" indent="yes" encoding="ISO-8859-1"/>
  <!--  Copie sólo los elementos que sean hijo único (excluidos nodos de texto que
        contengan exclusivamente espacios en blanco, saltos de línea, etc.) de algún elemento.
        No se copia el contenido de los elementos copiados.
  -->
  <xsl:template match="/">
    <!-- The position of the node is is 1-based, so the first node returns a position of 1. -->
    <xsl:apply-templates select="descendant::*[count(child::*)=1]/*"/>
  </xsl:template>

  <xsl:template match="*">
    <xsl:copy/>
  </xsl:template>

</xsl:stylesheet>
