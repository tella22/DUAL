<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:msxsl="urn:schemas-microsoft-com:xslt" exclude-result-prefixes="msxsl"
>
  <xsl:output method="xml" indent="yes"/>
  <xsl:template match="/">
    <xsl:for-each select="//Miembro">
      <xsl:choose>
        <xsl:when test='@nivel = "basica"'>
           <xsl:value-of select='Nombre'/>
                 Le recordamos que si asciende su membresía a "premier" obtiene...
        </xsl:when>
        <xsl:when test='@nivel = "premier"'>
           <xsl:value-of select='Nombre'/>
                 Por ser miembro especial le ofrecemos lo siguiente...
        </xsl:when>
      </xsl:choose>
    </xsl:for-each>
  </xsl:template>
</xsl:stylesheet>