if 

   [ $# -lt 1 ]

then

   echo no hay parametros
   exit 1

else

	PROCESO=$1
	
	TEST=`ps -le | grep " $PROCESO$"`

	if [ $? -eq 0 ]

	then

		LINEA=`ps -le | grep $PROCESO | tail -n 1`

		PPADRE=`echo $LINEA | tr -s [:blank:] | cut -d" " -f5`

		echo PROCESO: $PROCESO

		LINEAPADRE=`ps -p $PPADRE | tail -n 1`

		PADRE=`echo $LINEAPADRE | tr -s [:blank:] | cut -d" " -f4`
		
		echo PPID: $PPADRE con NOMBRE $PADRE
	
	else

		echo el proceso no existe
		exit 2

	fi

fi
