<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:msxsl="urn:schemas-microsoft-com:xslt" exclude-result-prefixes="msxsl"
>
    <xsl:output method="xml" indent="yes"/>

    <xsl:template match="/">
      <museos>
        <xsl:for-each select="/museos/museo">
          <museo>
            <nombre>
              <xsl:value-of select="nombre"/>
            </nombre>
            <ubicacion>
              <xsl:attribute name="ciudad">
                <xsl:value-of select="/museos/museo/ciudad"/>
              </xsl:attribute>
              <xsl:attribute name="pais">
                <xsl:value-of select="/museos/museo/pais"/>
              </xsl:attribute>
            </ubicacion>
          </museo>
        </xsl:for-each>
      </museos>
    </xsl:template>
</xsl:stylesheet>
