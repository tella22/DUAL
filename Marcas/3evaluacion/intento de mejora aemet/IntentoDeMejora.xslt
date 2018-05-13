<?xml version="1.0" encoding="utf-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:msxsl="urn:schemas-microsoft-com:xslt" exclude-result-prefixes="msxsl"
>

  <xsl:output method="xml" indent="yes"/>
  <xsl:template match="/">
         
    <html>
      <head>
          <link rel="stylesheet" type="text/css" href="aemet.css"/>
      </head>
      <body>
        <h1>Localidad: <xsl:value-of select="//nombre"/></h1>
        <div class="viernesDiv">
        <xsl:for-each select="//dia">
            <div>
              <xsl:choose>
                <xsl:when test="@fecha = '2018-04-20'">
                  <h4 class="dayweek">VIERNES</h4>
                </xsl:when>
              </xsl:choose>
              <h5 class="day">2018-04-20</h5>
              <hr/>
              <h5 class="hour">18-24 h</h5>
              <p class="temp">
                <img class="status" src="icos/atardecer.png" alt="tarde"/>25/10 Cº
              </p>
              <p class="info">Precipitacion:  0%</p>
              <p class="info">Max/Min Cº:  0</p>
              <p class="info">Humedad Min/Max:  0</p>
              <p class="info">Direccion y Velocidad Viento:  0</p>
              <p class="info">Sensacion Termica Cº:  0</p>
              <p class="info">Racha Maxima:  0</p>
              <p class="info">Indice Ultravioleta:  0</p>
            </div>
        </xsl:for-each>
        </div>
        
        <table>
          <tr class="dias">
            <td><p>VIERNES</p></td>
            <td colspan="4"><p>SABADO</p></td>
            <td colspan="2"><p>DOMINGO</p></td>
            <td colspan="2"><p>LUNES</p></td>
            <td><p>MARTES</p></td>
            <td><p>MIERCOLES</p></td>
            <td><p>JUEVES</p></td>
          </tr>
          <tr class="fechas">
            <xsl:for-each select="//dia">
              <xsl:variable name="span">
                  <xsl:value-of select="count(prob_precipitacion/@periodo)"/>
              </xsl:variable>
              <td colspan="{$span}"><xsl:value-of select="@fecha"/></td>
            </xsl:for-each>
          </tr>
          <tr class="data">
          <xsl:for-each select="//dia">
            <xsl:for-each select="prob_precipitacion">
              <xsl:if test='@periodo'> 
                <td>
                <xsl:choose>
                  <xsl:when test="@periodo = '00-06'"><img class="status" src="icos/luna.png" alt="noche"><br/></img></xsl:when>
                  <xsl:when test="@periodo = '06-12'"><img class="status" src="icos/amanecer.png" alt="mañana"><br/></img></xsl:when>
                  <xsl:when test="@periodo = '12-18'"><img class="status" src="icos/sol.png" alt="dia"></img><br/></xsl:when>
                  <xsl:when test="@periodo = '18-24'"><img class="status" src="icos/atardecer.png" alt="tarde"><br/></img></xsl:when>
                  <xsl:when test="@periodo = '00-12'"><img class="status" src="icos/amanecer.png" alt="amanecer"><br/></img></xsl:when>
                  <xsl:when test="@periodo = '12-24'"><img class="status" src="icos/atardecer.png" alt="atardecer"><br/></img></xsl:when>
                </xsl:choose>
                <xsl:value-of select="@periodo"/> h
                </td>
              </xsl:if>
              <xsl:if test='not(@periodo)'>
                <td> </td>
              </xsl:if>
            </xsl:for-each>
          </xsl:for-each>
          </tr>
          <tr><td colspan="12" class="menu">Probabilidad de precipitacion</td></tr>
          <tr class="data">
            <xsl:for-each select="//dia">
              <xsl:for-each select="prob_precipitacion">
                  <td><xsl:value-of select="node()"/> %</td>
              </xsl:for-each>
            </xsl:for-each>
          </tr>
          <tr><td colspan="12" class="menu">Cota de nieve a nivel de provincia (m)</td></tr>
          <tr class="data">
            <xsl:for-each select="//dia">
              <xsl:for-each select="cota_nieve_prov">
                  <xsl:if test="not(cota_nieve_prov)">
                    <td>0</td>
                  </xsl:if>
              </xsl:for-each>
            </xsl:for-each>
          </tr>
          <tr><td colspan="12" class="menu">Temperatura mínima y máxima (°C)</td></tr>
          <tr class="data">
            <xsl:for-each select="//dia">
              <xsl:variable name="span">
                    <xsl:value-of select="count(prob_precipitacion/@periodo)"/>
                </xsl:variable>
              <xsl:for-each select="temperatura">
                    <td colspan="{$span}">
                      <xsl:value-of select="maxima"/>/<xsl:value-of select="minima"/>
                    </td>
              </xsl:for-each>
            </xsl:for-each>
          </tr>
          <tr><td colspan="12" class="menu">Sensación térmica mínima y máxima (°C)</td></tr>
          <tr class="data">
            <xsl:for-each select="//dia">
              <xsl:variable name="span">
                    <xsl:value-of select="count(prob_precipitacion/@periodo)"/>
                </xsl:variable>
              <xsl:for-each select="sens_termica">
                    <td colspan="{$span}">
                      <xsl:value-of select="maxima"/>/<xsl:value-of select="minima"/>
                    </td>
              </xsl:for-each>
            </xsl:for-each>
          </tr>
          <tr><td colspan="12" class="menu">Humedad relativa mínima y máxima (%)</td></tr>
          <tr class="data">
            <xsl:for-each select="//dia">
              <xsl:variable name="span">
                    <xsl:value-of select="count(prob_precipitacion/@periodo)"/>
                </xsl:variable>
              <xsl:for-each select="humedad_relativa">
                    <td colspan="{$span}">
                      <xsl:value-of select="maxima"/>/<xsl:value-of select="minima"/>
                    </td>
              </xsl:for-each>
            </xsl:for-each>
          </tr>
          <tr><td colspan="12" class="menu">Dirección y velocidad del viento (km/h)</td></tr>
          <tr class="data">
            <xsl:for-each select="//dia">
              <xsl:for-each select="viento">
                <td>
                  <xsl:value-of select="velocidad"/>
                  <xsl:choose>
                    <xsl:when test="direccion = 'SE'"><img class="viento" src="icos/seste.png" alt="seste"></img></xsl:when>
                    <xsl:when test="direccion = 'E'"><img class="viento" src="icos/este.png" alt="este"></img></xsl:when>
                    <xsl:when test="direccion = 'NE'"><img class="viento" src="icos/neste.png" alt="neste"></img></xsl:when>
                    <xsl:when test="direccion = 'N'"><img class="viento" src="icos/norte.png" alt="norte"></img></xsl:when>
                    <xsl:when test="direccion = 'NO'"><img class="viento" src="icos/noeste.png" alt="noeste"></img></xsl:when>
                    <xsl:when test="direccion = 'O'"><img class="viento" src="icos/oeste.png" alt="oeste"></img></xsl:when>
                    <xsl:when test="direccion = 'S'"><img class="viento" src="icos/sur.png" alt="sur"></img></xsl:when>
                    <xsl:when test="direccion = 'SO'"><img class="viento" src="icos/soeste.png" alt="soeste"></img></xsl:when>
                    <xsl:when test="direccion = 'C'"><img class="viento" src="icos/c.png" alt="no viento"></img></xsl:when>
                  </xsl:choose>
                </td>
              </xsl:for-each>
            </xsl:for-each>
          </tr>
          <tr><td colspan="12" class="menu">Sensación térmica (°C)</td></tr>
          <tr class="data">
            <xsl:for-each select="//dia">
              <xsl:for-each select="temperatura">
               <xsl:for-each select="dato">
                    <td><xsl:value-of select="node()"/></td>
               </xsl:for-each>
              </xsl:for-each>
            </xsl:for-each>
          </tr>
          <tr><td colspan="12" class="menu">Racha máxima (km/h)</td></tr>
          <tr class="data">
            <xsl:for-each select="//dia">
                <xsl:variable name="span">
                    <xsl:value-of select="count(prob_precipitacion/@periodo)"/>
                </xsl:variable>
                <xsl:if test="racha_max = ''">
                <td colspan="{$span}">0</td>
                </xsl:if>
                <xsl:if test="racha_max != ''">
                <td colspan="{$span}"><xsl:value-of select="racha_max"/></td>
                </xsl:if>
            </xsl:for-each>
          </tr>
          <tr><td colspan="12" class="menu">Indice ultravioleta máximo</td></tr>
          <tr class="data">
            <xsl:for-each select="//dia">
                <xsl:variable name="span">
                    <xsl:value-of select="count(prob_precipitacion/@periodo)"/>
                </xsl:variable>
                <xsl:if test="not(uv_max)">
                  <td colspan="{$span}">0</td>
                </xsl:if>
                <xsl:if test="uv_max">
                <td colspan="{$span}"><xsl:value-of select="uv_max"/></td>
                </xsl:if>
            </xsl:for-each>
          </tr>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>

