<?xml version="1.0"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns="letras"
  version="1.0">

  <xsl:output method="xml" indent="yes" encoding="ISO-8859-1"/>
  <!--  cree un documento XML que se componga de dos copias del documento fuente,
        la primera rodeada de la etiqueta uno y la segunda de la etiqueta dos.
        El elemento raiz del documento destino se llamará raiz.

        Al igual que el apartado anterior, habría otra alternativa menos clara.
  -->
  <xsl:template match="/">
    <xsl:element name="raiz">
      <xsl:element name="uno">
        <xsl:apply-templates select="child::*"/>
      </xsl:element>
      <xsl:element name="dos">
        <xsl:apply-templates select="child::*"/>
      </xsl:element>
    </xsl:element>
  </xsl:template>

  <xsl:template match="*">
    <xsl:copy>
      <xsl:apply-templates select="child::*"/>
    </xsl:copy>
  </xsl:template>
</xsl:stylesheet>
