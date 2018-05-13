<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:msxsl="urn:schemas-microsoft-com:xslt" exclude-result-prefixes="msxsl"
>
    <xsl:output method="xml" indent="yes"/>

    <xsl:template match="/">
      <html>
        <body>
          <table>
            <xsl:for-each select="//autores/autor">
              <xsl:if test="@nacimiento &gt; 1700">
                <tr>
                 <td>
                   <xsl:value-of select="node()"/>
                  </td>
                  <td>
                   <xsl:value-of select="@nacimiento"/>
                  </td>
                </tr>
              </xsl:if>
            </xsl:for-each>
          </table>
        </body>
      </html>
    </xsl:template>
</xsl:stylesheet>
