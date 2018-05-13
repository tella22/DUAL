FICHERO=trabajadores
while
	read LINEA
do
	NOMBRE=`echo $LINEA | cut -d: -f1`
	APELLIDO1=`echo $LINEA | cut -d: -f2`
	APELLIDO2=`echo $LINEA | cut -d: -f3`

	USU1=`echo $NOMBRE | cut -c1 | tr "[[:upper:]]" "[[:lower:]]"`
	USU2=`echo $APELLIDO1 | cut -c1-3 | tr "[[:upper:]]" "[[:lower:]]"`
	INTLONGLAST=`expr length $APELLIDO2`
	LONGLASTSTART=`expr $INTLONGLAST - 2`
	LONGLASTFIN=$INTLONGLAST

	USU3=`echo $APELLIDO2 | cut -c $LONGLASTSTART-$LONGLASTFIN | tr "[[:upper:]]" "[[:lower:]]"`

	USUARIO=$USU1$USU2$USU3

	echo Creando usuario para $NOMBRE $APELLIDO1 $APELLIDO2 "($USUARIO)"

done<$FICHERO
