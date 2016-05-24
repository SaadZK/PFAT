<?xml version="1.0"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns="peliculas"
  version="1.0">
  
  <xsl:output method="html" indent="yes" encoding="UTF-8"/>

  <!-- 
    The <xsl:element> element is used to create an element node in the output document.
    The <xsl:attribute> element is used to add attributes to elements.
  -->
  
  <!-- Apartado 8
  <xsl:template match="/">

    <html>
      <head>
        <title>Directores</title>
      </head>
      <body>

        <xsl:element name="directores">
          <xsl:apply-templates select="descendant::*/director"/>
        </xsl:element>

      </body>
    </html>

  </xsl:template>
  
  <xsl:template match="director">
    <director>
      <xsl:value-of select="." disable-output-escaping="yes"/>
    </director>
  </xsl:template>
  -->

  <!-- Apartado 9
  <xsl:template match="/">

    <html>
      <head>
        <title>Pelis</title>
      </head>
      <body>

        <xsl:element name="pelis">
          <xsl:apply-templates select="descendant::*/pelicula"/>
        </xsl:element>

      </body>
    </html>

  </xsl:template>
  
  <xsl:template match="pelicula">
    <xsl:element name="peli">
      <xsl:attribute name="director">
        <xsl:value-of select="child::director" disable-output-escaping="yes"/>
      </xsl:attribute>
      <xsl:value-of select="child::titulo" disable-output-escaping="yes"/>
    </xsl:element>
  </xsl:template>
  -->
  <!-- Apartado 10 (todo igual menos el select con condición)
  <xsl:element name="pelis">
    <xsl:apply-templates select="descendant::*/pelicula[@anio=2010]"/>
  </xsl:element>
  -->

  <!-- 
  <?xml version="1.0" encoding="utf-8"?>
<html>
  <head>
    <title>Películas</title>
  </head>
  <body>
    <h1>Listado de Películas</h1>
    <ul>
      <li><i>La lista de Schindler</i>, de Steven Spielberg</li>
      <li><i>Con la muerte en los talones</i>, de Alfred Hitchcock</li>
    </ul>
  </body>
</html>
  -->

  <!-- Apartado 11 -->
  <xsl:template match="/">

    <html>
      <head>
        <title>Películas</title>
      </head>
      <body>
        <h1>Listado de Películas</h1>
        <ul>
          <xsl:apply-templates select="descendant::pelicula"/>
        </ul>
      </body>
    </html>

  </xsl:template>
  
  <xsl:template match="pelicula">
    <li>
      <i><xsl:value-of select="child::titulo" disable-output-escaping="yes"/></i>, de <xsl:value-of select="child::director" disable-output-escaping="yes"/>
    </li>
  </xsl:template>

</xsl:stylesheet>