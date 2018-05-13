<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:msxsl="urn:schemas-microsoft-com:xslt" exclude-result-prefixes="msxsl"
>
    <xsl:output method="xml" indent="yes"/>

    <xsl:template match="/">
      <html>
        <head></head>
        <body>
        <h1>Los miembros del centro son:</h1>
          <xsl:for-each select="//Miembro">
            <p>Nombre: <xsl:value-of select="Nombre"/></p>
            <p>Membresía: <xsl:value-of select="@nivel"/></p>
          </xsl:for-each>
        </body>  
      </html>
    </xsl:template>
</xsl:stylesheet>
