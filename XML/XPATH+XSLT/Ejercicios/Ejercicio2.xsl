<?xml version="1.0"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns="letras"
  version="1.0">

  <xsl:output method="xml" indent="yes" encoding="ISO-8859-1"/>
  <!--  Copie el contenido de cualquier documento XML a uno nuevo, utilizando xsl:copy.
        Hay una alternativa que sería hacer:

        <xsl:template match="/R">
          <xsl:element name="R">
            <xsl:apply-templates select="descendant::*"/>
          </xsl:element>
        </xsl:template>

        <xsl:template match="*">
          <xsl:copy/>
        </xsl:template>

        El problema que tiene es que copia el nodo cerrado, es decir, crea <R/> siempre,
        en lugar de hacer <R> ... </R>.
        Con el siguiente código se copia tal cual.
  -->
  <xsl:template match="/R">
    <xsl:element name="R">
      <xsl:apply-templates select="child::*"/>
    </xsl:element>
  </xsl:template>

  <xsl:template match="*">
    <xsl:copy>
      <xsl:apply-templates select="child::*"/>
    </xsl:copy>
  </xsl:template>

</xsl:stylesheet>
