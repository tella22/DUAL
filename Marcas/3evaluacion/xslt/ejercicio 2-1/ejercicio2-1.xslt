<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:msxsl="urn:schemas-microsoft-com:xslt" version="1.0" exclude-result-prefixes="msxsl">
  <xsl:output method="xml" indent="yes"/>

  <xsl:template match="/">
    <html>
      <body>
        <h1><xsl:value-of select="/ies/@nombre"/></h1>
          <xsl:for-each select="ies/ciclos/ciclo">
            <p><xsl:value-of select="nombre"/></p>
          </xsl:for-each>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
