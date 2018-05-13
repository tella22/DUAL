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
            <xsl:for-each select="//dia"> <!--con este for each vamos a recorrer todos los dias-->
              <xsl:variable name="span">
                  <xsl:value-of select="count(estado_cielo/@periodo)"/><!--aqui vamos a conseguir el span que vamos a establecer para cada dia, a partir de los periodos horarios que tengan-->
              </xsl:variable>
              <td colspan="{$span}"><xsl:value-of select="@fecha"/></td>
            </xsl:for-each>
          </tr>
          <tr class="data">
          <xsl:for-each select="//dia">
            <xsl:for-each select="estado_cielo">
              <xsl:if test='@periodo'> 
                <td>
                <xsl:choose><!--aqui, con un case, vamos a controlar la imagen que vamos a establecer segun el periodo horario que tengan-->
                  <xsl:when test="(@periodo = '00-06') and (@descripcion = 'Nubes Altas')"><img class="status" src="icos/nubesaltasNoche.png" alt="nubesaltasNoche"><br/></img> </xsl:when>
                  <xsl:when test="(@periodo = '00-06') and (@descripcion = 'Despejado')"><img class="status" src="icos/despejadoNoche.png" alt="despejado"><br/></img></xsl:when>
                  <xsl:when test="(@periodo = '00-06') and (@descripcion = 'Intervalos nubosos')"><img class="status" src="icos/intervalosnubososNoche.png" alt="intervalosnubososNoche"><br/></img></xsl:when>
                  <xsl:when test="(@periodo = '00-06') and (@descripcion = 'Poco nuboso')"><img class="status" src="icos/poconubosoNoche.png" alt="poconubosoNoche"><br/></img></xsl:when>
                  <xsl:when test="(@periodo = '00-06') and (@descripcion = 'Muy nuboso con lluvia')"><img class="status" src="icos/nubosolluviasNoche.png" alt="nubosolluviasNoche"><br/></img></xsl:when>
                  <xsl:when test="(@periodo = '06-12') and (@descripcion = 'Nubes Altas')"><img class="status" src="icos/nubesaltas.png" alt="nubesaltasNoche"><br/></img> </xsl:when>
                  <xsl:when test="(@periodo = '06-12') and (@descripcion = 'Despejado')"><img class="status" src="icos/despejado.png" alt="despejado"><br/></img></xsl:when>
                  <xsl:when test="(@periodo = '06-12') and (@descripcion = 'Intervalos nubosos')"><img class="status" src="icos/intervalosnubosos.png" alt="intervalosnubososNoche"><br/></img></xsl:when>
                  <xsl:when test="(@periodo = '06-12') and (@descripcion = 'Poco nuboso')"><img class="status" src="icos/poconuboso.png" alt="poconubosoNoche"><br/></img></xsl:when>
                  <xsl:when test="(@periodo = '06-12') and (@descripcion = 'Muy nuboso con lluvia')"><img class="status" src="icos/nubosolluvias.png" alt="nubosolluviasNoche"><br/></img></xsl:when>
                  <xsl:when test="(@periodo = '12-18') and (@descripcion = 'Nubes Altas')"><img class="status" src="icos/nubesaltas.png" alt="nubesaltasNoche"><br/></img> </xsl:when>
                  <xsl:when test="(@periodo = '12-18') and (@descripcion = 'Despejado')"><img class="status" src="icos/despejado.png" alt="despejado"><br/></img></xsl:when>
                  <xsl:when test="(@periodo = '12-18') and (@descripcion = 'Intervalos nubosos')"><img class="status" src="icos/intervalosnubosos.png" alt="intervalosnubososNoche"><br/></img></xsl:when>
                  <xsl:when test="(@periodo = '12-18') and (@descripcion = 'Poco nuboso')"><img class="status" src="icos/poconuboso.png" alt="poconubosoNoche"><br/></img></xsl:when>
                  <xsl:when test="(@periodo = '12-18') and (@descripcion = 'Muy nuboso con lluvia')"><img class="status" src="icos/nubosolluvias.png" alt="nubosolluviasNoche"><br/></img></xsl:when>
                  <xsl:when test="(@periodo = '18-24') and (@descripcion = 'Nubes Altas')"><img class="status" src="icos/nubesaltas.png" alt="nubesaltasNoche"><br/></img> </xsl:when>
                  <xsl:when test="(@periodo = '18-24') and (@descripcion = 'Despejado')"><img class="status" src="icos/despejado.png" alt="despejado"><br/></img></xsl:when>
                  <xsl:when test="(@periodo = '18-24') and (@descripcion = 'Intervalos nubosos')"><img class="status" src="icos/intervalosnubosos.png" alt="intervalosnubososNoche"><br/></img></xsl:when>
                  <xsl:when test="(@periodo = '18-24') and (@descripcion = 'Poco nuboso')"><img class="status" src="icos/poconuboso.png" alt="poconubosoNoche"><br/></img></xsl:when>
                  <xsl:when test="(@periodo = '18-24') and (@descripcion = 'Muy nuboso con lluvia')"><img class="status" src="icos/nubosolluvias.png" alt="nubosolluviasNoche"><br/></img></xsl:when>
                  <xsl:when test="(@periodo = '00-12') and (@descripcion = 'Nubes altas')"><img class="status" src="icos/nubesaltasNoche.png" alt="nubesaltasNoche"><br/></img> </xsl:when>
                  <xsl:when test="(@periodo = '00-12') and (@descripcion = 'Despejado')"><img class="status" src="icos/despejadoNoche.png" alt="despejado"><br/></img></xsl:when>
                  <xsl:when test="(@periodo = '00-12') and (@descripcion = 'Intervalos nubosos')"><img class="status" src="icos/intervalosnubososNoche.png" alt="intervalosnubososNoche"><br/></img></xsl:when>
                  <xsl:when test="(@periodo = '00-12') and (@descripcion = 'Poco nuboso')"><img class="status" src="icos/poconubosoNoche.png" alt="poconubosoNoche"><br/></img></xsl:when>
                  <xsl:when test="(@periodo = '00-12') and (@descripcion = 'Muy nuboso con lluvia')"><img class="status" src="icos/nubosolluviasNoche.png" alt="nubosolluviasNoche"><br/></img></xsl:when>
                  <xsl:when test="(@periodo = '12-24') and (@descripcion = 'Nubes altas')"><img class="status" src="icos/nubesaltas.png" alt="nubesaltasNoche"><br/></img> </xsl:when>
                  <xsl:when test="(@periodo = '12-24') and (@descripcion = 'Despejado')"><img class="status" src="icos/despejado.png" alt="despejado"><br/></img></xsl:when>
                  <xsl:when test="(@periodo = '12-24') and (@descripcion = 'Intervalos nubosos')"><img class="status" src="icos/intervalosnubosos.png" alt="intervalosnubososNoche"><br/></img></xsl:when>
                  <xsl:when test="(@periodo = '12-24') and (@descripcion = 'Poco nuboso')"><img class="status" src="icos/poconuboso.png" alt="poconubosoNoche"><br/></img></xsl:when>
                  <xsl:when test="(@periodo = '12-24') and (@descripcion = 'Muy nuboso con lluvia')"><img class="status" src="icos/nubosolluvias.png" alt="nubosolluviasNoche"><br/></img></xsl:when>
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
            <xsl:for-each select="//dia"><!--calculamos la probabilidad establecida por dia-->
              <xsl:for-each select="prob_precipitacion">
                  <td><xsl:value-of select="node()"/> %</td>
              </xsl:for-each>
            </xsl:for-each>
          </tr>
          <tr><td colspan="12" class="menu">Cota de nieve a nivel de provincia (m)</td></tr>
          <tr class="data">
            <xsl:for-each select="//dia"><!--calculamos la cota de nieve establecida por dia-->
              <xsl:for-each select="cota_nieve_prov">
                  <xsl:if test="not(cota_nieve_prov)">
                    <td>0</td>
                  </xsl:if>
              </xsl:for-each>
            </xsl:for-each>
          </tr>
          <tr><td colspan="12" class="menu">Temperatura mínima y máxima (°C)</td></tr>
          <tr class="data">
            <xsl:for-each select="//dia"><!--calculamos las temperaturas establecidas por dia-->
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
            <xsl:for-each select="//dia"><!--calculamos la sensacion termica por dia-->
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
            <xsl:for-each select="//dia"><!--calculamos la humedad establecida por dia-->
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
            <xsl:for-each select="//dia"><!--calculamos la direccion y velocidad del viento por dia-->
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
            <xsl:for-each select="//dia"><!--calculamos la sensacion termica total por dia-->
              <xsl:for-each select="temperatura">
               <xsl:for-each select="dato">
                    <td><xsl:value-of select="node()"/></td>
               </xsl:for-each>
              </xsl:for-each>
            </xsl:for-each>
          </tr>
          <tr><td colspan="12" class="menu">Racha máxima (km/h)</td></tr>
          <tr class="data">
            <xsl:for-each select="//dia"><!--calculamos la racha de viento por dia-->
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
            <xsl:for-each select="//dia"><!--calculamos el indice ultravioleta por dia-->
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