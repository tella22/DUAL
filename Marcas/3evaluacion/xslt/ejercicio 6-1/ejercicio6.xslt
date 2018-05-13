﻿<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:msxsl="urn:schemas-microsoft-com:xslt" exclude-result-prefixes="msxsl"
>
    <xsl:output method="xml" indent="yes"/>

    <xsl:template match="/">
      <html>
        <body>
          <h2>Productos edificio B</h2>
            <xsl:for-each select="inventario/producto">
              <xsl:if test='lugar/@edificio="B"'>
                <p>
                  <xsl:copy-of select='.'/>
                </p>
              </xsl:if>
            </xsl:for-each>
        </body>
      </html>
    </xsl:template>
</xsl:stylesheet>
