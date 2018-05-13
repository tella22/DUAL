<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:msxsl="urn:schemas-microsoft-com:xslt" version="1.0" exclude-result-prefixes="msxsl">
    <xsl:output method="xml" indent="yes"/>

    <xsl:template match="/">
      <html>
        <body>
          <h1>Coleccion de Libros:</h1>
          <table border="1">
            <tr bgcolor="#9acd32">
               <th>Titulo</th>
               <th>Autor</th>
             </tr>
           <xsl:for-each select="biblioteca/libro">
              <tr>
                <td>
                  <xsl:value-of select="titulo"/>
                </td>
                <td>
                    <xsl:value-of select="autor"/>
                </td>
              </tr>
            </xsl:for-each>
          </table>
        </body>
      </html>
    </xsl:template>
</xsl:stylesheet>
