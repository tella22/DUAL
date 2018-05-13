<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:msxsl="urn:schemas-microsoft-com:xslt" version="1.0" exclude-result-prefixes="msxsl">
  <xsl:output method="xml" indent="yes"/>

  <xsl:template match="/">
    <html>
      <body>
        <h1><xsl:value-of select="/ies/@nombre"/></h1>
        <p>Pagina web:<a>
                            <xsl:attribute name="href">
                              <xsl:value-of select="/ies/@web"/>
                            </xsl:attribute>
                             <xsl:value-of select="/ies/@web"/>
                       </a>
      </p>
        <ul>
          <xsl:for-each select="ies/ciclos/ciclo">
            <li><xsl:value-of select="nombre"/></li>
          </xsl:for-each>
        </ul>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
