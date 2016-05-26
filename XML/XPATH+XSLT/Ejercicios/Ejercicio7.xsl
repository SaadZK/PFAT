<?xml version="1.0"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns="letras"
  version="1.0">

  <xsl:output method="xml" indent="yes" encoding="ISO-8859-1"/>
  <!--  Cree un documento HTML que contenga una lista. Esta lista sigue la estructura
        del documento XML, de manera que el texto de un item es el nombre de un elemento
        del documento fuente, y los subitems se corresponden con el contenido de dicho elemento.
        Puede utilizar la función XPath local-name(node-set?) que devuelve la parte local
        del nombre del primer elemento del node-set que se pasa como argumento o la
        del current nodo si no se pasa ningún argumento.

        Similar a:

        <html>
        <head>
        <title> Estructura de un documento XML </title>
        </head>
        <body>
          <ul>
            <li>R</li>
            <ul>
              <li>D</li>
              <li>E</li>
              <ul>
                  <li>E</li>
                <ul>
                  <li>A</li>
                  <li>A</li>
                </ul>
                <li>E</li>
                <ul>
                  <li>A</li>
                  <li>A</li>
                </ul>
              </ul>
            </ul>
          </ul>
        </body>
        </html>
  -->
  <xsl:template match="/">
    <html>
    <head>
    <title> Estructura de un documento XML </title>
    </head>
    <body>
      <ul>
        <xsl:apply-templates select="child::*"/>
      </ul>
    </body>
    </html>
  </xsl:template>

  <xsl:template match="*[count(child::*)>0]">
    <li><xsl:value-of select="local-name()"/></li>
    <ul>
      <xsl:apply-templates select="child::*"/>
    </ul>
  </xsl:template>

  <xsl:template match="child::*">
    <li><xsl:value-of select="local-name()"/></li>
  </xsl:template>

</xsl:stylesheet>
