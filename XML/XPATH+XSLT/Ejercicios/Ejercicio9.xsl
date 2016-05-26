<?xml version="1.0"?>

<!--

Apartado 1

<?xml version="1.0" encoding="UTF-8"?>

	<Elecciones tipo="europeas" año="2014">
	  <Provincia nombre="A Coruña">
	    <Partido nombre="Partido Popular" 
	             siglas="PP">129814</Partido>
	    <Partido nombre="Partido Socialista Obrero Español" 
	             siglas="PSOE">85117</Partido>
	  </Provincia>
	  <Provincia nombre="Álava">
	    <Partido nombre="Partido Popular" 
	             siglas="PP">16978</Partido>
	    <Partido nombre="Partido Socialista Obrero Español" 
	             siglas="PSOE">16115</Partido>
	  </Provincia>
	  <Provincia nombre="Albacete">
	    <Partido nombre="Partido Popular" 
	             siglas="PP">50549</Partido>
	    <Partido nombre="Partido Socialista Obrero Español" 
	             siglas="PSOE">41017</Partido>
	  </Provincia>
	</Elecciones>


<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  version="1.0">
  
  <xsl:output method="xml" indent="yes" encoding="UTF-8" />

  <xsl:strip-space elements="*"/>

  <xsl:template match="/Elecciones">
	<xsl:copy>
        <xsl:apply-templates select="@*" />
        <xsl:apply-templates select="*[position()=1]/*" />
	</xsl:copy>
  </xsl:template>

  <xsl:template match="Provincia">
	<xsl:copy>
	    <xsl:apply-templates select="@*" />
		<xsl:apply-templates select="/*/Partido">
			<xsl:with-param name="provincia" select="@nombre"/>
		</xsl:apply-templates>
	</xsl:copy>
  </xsl:template>

  <xsl:template match="Partido">
	<xsl:param name="provincia"/>
	<xsl:copy>
	    <xsl:apply-templates select="@*" />
	    <xsl:value-of select="Provincia[@nombre = $provincia]"/>
	</xsl:copy>
  </xsl:template>

  <xsl:template match="@*">
	<xsl:copy/>
  </xsl:template>

</xsl:stylesheet> -->

<!--

Apartado 2

<?xml version="1.0" encoding="UTF-8"?>

	<Elecciones tipo="europeas" año="2014">
	  <Partido nombre="Partido Popular" 
	           siglas="PP">197341</Partido>
	  <Partido nombre="Partido Socialista Obrero Español" 
	           siglas="PSOE">142249</Partido>
	</Elecciones>

-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns="ejercicio9"
  version="1.0">
  
  <xsl:output method="xml" indent="yes" encoding="UTF-8" />

  <xsl:template match="/Elecciones">
	<xsl:copy>
        <xsl:apply-templates select="child::*" />
	</xsl:copy>
  </xsl:template>

  <xsl:template match="*">
  	<xsl:copy>
  		<xsl:copy-of select="@*"/>
  		<xsl:value-of select="sum(./Provincia)"/>
  	</xsl:copy>
  </xsl:template>

</xsl:stylesheet>
