<?xml version="1.0"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns="letras"
  version="1.0">

  <xsl:output method="xml" indent="yes" encoding="ISO-8859-1"/>
  <!--  Copie el contenido de cualquier documento XML a uno nuevo, utilizando xsl:copy-of.
        También se podría hacer con match="*", pero así queda más explícito.
  -->
  <xsl:template match="/">
    <xsl:copy-of select="."/>
  </xsl:template>

</xsl:stylesheet>
