<?xml version="1.0" encoding="utf-8"?>
<?xml-stylesheet type="text/xsl" href="ejercicio3-1.xslt"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:msxsl="urn:schemas-microsoft-com:xslt" exclude-result-prefixes="msxsl"
>
    <xsl:output method="xml" indent="yes"/>

    <xsl:template match="/">
      <museos>
        <xsl:for-each select="/museos/museo">
          <museo>
              <xsl:attribute name="nombre">
                <xsl:value-of select="/museos/museo/nombre"/>
              </xsl:attribute>
              <xsl:attribute name="ciudad">
                <xsl:value-of select="/museos/museo/ciudad"/>
              </xsl:attribute>
              <xsl:attribute name="pais">
                <xsl:value-of select="/museos/museo/pais"/>
              </xsl:attribute>
          </museo>
        </xsl:for-each>
      </museos>
    </xsl:template>
</xsl:stylesheet>
