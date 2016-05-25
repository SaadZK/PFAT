<?xml version="1.0"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns="letras"
  version="1.0">

  <xsl:output method="xml" indent="yes" encoding="ISO-8859-1"/>
  <!--  Obtenga un documento destino compuesto por los mismos elementos que el documento
        fuente. En cada elemento del documento destino habrá un atributo, llamado
        descendientes, cuyo valor es el número de elementos que contiene el elemento.
        -format-number(....,'#00.0'): permite dar formato a un número antes de ser
          escrito en el documento destino. El primer argumento es el número al
          que se le va a dar formato. El segundo argumento especifica el formato.
          Los caracteres # indican un dígito, pero si no es necesario no se escribirá
          nada. Los carácteres 0 indican un dígito, pero en el caso de que el dígito
          no sea necesario, se escribirá el dígito 0. El . separa la parte entera
          de la parte decimal. Por ejemplo, con el formato indicado, el 7 se
          representará como 07.0.
        -count(node-set): indica el número de nodos que contiene un node-set.
  -->
  <xsl:template match="/R">
    <xsl:element name="{name()}">
      <xsl:apply-templates select="descendant::*"/>
    </xsl:element>
  </xsl:template>

  <xsl:template match="*">
    <xsl:copy>
      <xsl:attribute name="descendientes">
        <xsl:value-of select="format-number(count(descendant::*), '#0')"/>
      </xsl:attribute>
    </xsl:copy>
  </xsl:template>

</xsl:stylesheet>
