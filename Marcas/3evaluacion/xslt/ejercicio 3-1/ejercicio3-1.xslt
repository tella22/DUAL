<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:msxsl="urn:schemas-microsoft-com:xslt" version="1.0" exclude-result-prefixes="msxsl">
  <xsl:output method="xml" indent="yes"/>

  <xsl:template match="/">
    <html>
      <body>
        <h1>Ciclos fortmativos del <xsl:value-of select="/ies/@nombre"/></h1>
        <ul>
          <xsl:for-each select="ies/ciclos/ciclo">
            <li>
              <xsl:value-of select="@id"/>
              <br/>
              <xsl:value-of select="nombre"/>, ciclo <xsl:value-of select="grado"/> creado en <xsl:value-of select="decretoTitulo/@año"/>
            </li>
          </xsl:for-each>
        </ul>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
