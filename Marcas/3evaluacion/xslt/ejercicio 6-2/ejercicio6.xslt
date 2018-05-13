<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:msxsl="urn:schemas-microsoft-com:xslt" exclude-result-prefixes="msxsl"
>
    <xsl:output method="xml" indent="yes"/>

    <xsl:template match="/">
      <html>
        <body>
          <table>
            <xsl:for-each select="inventario/producto">
              <xsl:if test='lugar/@edificio="A"'>
                 <tr>
                  <td><xsl:value-of select='./nombre'/></td>
                  <td><xsl:value-of select='./peso'/><xsl:value-of select='./peso/@unidad'/></td>
                  <td><xsl:value-of select='./lugar/@edificio'/><xsl:value-of select='./lugar/aula'/></td>
                </tr>
              </xsl:if>
            </xsl:for-each> 
            <xsl:for-each select="inventario/producto">
              <xsl:if test='lugar/@edificio="B"'>
                <tr>
                  <td><xsl:value-of select='./nombre'/></td>
                  <td><xsl:value-of select='./peso'/><xsl:value-of select='./peso/@unidad'/></td>
                  <td><xsl:value-of select='./lugar/@edificio'/><xsl:value-of select='./lugar/aula'/></td>
                </tr>
              </xsl:if>
            </xsl:for-each>   
          </table>  
        </body>
      </html>
    </xsl:template>
</xsl:stylesheet>
