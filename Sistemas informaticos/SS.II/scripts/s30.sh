if 

   [ $# -lt 1 ]

then

   echo no hay parametros
   exit 1

else

	TEST=`ps -lp $1`

	if [ $? -eq 0 ]

	then

		PROCESO=$1

		LINEA=`ps -lp $PROCESO | tail -n 1 `

		PPADRE=`echo $LINEA | tr -s [:blank:] | cut -d" " -f5`

		echo el padre del proceso $PROCESO es $PPADRE

		LINEAPADRE=`ps -p $PPADRE | tail -n 1`

		PADRE=`echo $LINEAPADRE | tr -s [:blank:] | cut -d" " -f4`
		
		echo el nombre del padre es $PADRE
	
	else

		echo el proceso no existe
		exit 2

	fi

fi
