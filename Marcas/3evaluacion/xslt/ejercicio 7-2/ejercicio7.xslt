<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:msxsl="urn:schemas-microsoft-com:xslt" exclude-result-prefixes="msxsl"
>
    <xsl:output method="xml" indent="yes"/>

    <xsl:template match="/">
      <html>
        <body>
          <ol>
              <xsl:for-each select="//autores/autor">
                <xsl:sort select="node()" order="descending"/>
                <li>
                  <xsl:value-of select="node()"/>
                </li>
              </xsl:for-each>
          </ol>
        </body>
      </html>
    </xsl:template>
</xsl:stylesheet>
