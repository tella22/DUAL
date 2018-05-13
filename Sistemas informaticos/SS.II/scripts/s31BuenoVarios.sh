if 
  [ $# -eq 0 ]
then
  echo error, no hay ningun parametro introducido
  exit 1
fi

while
	[ $# -gt 0 ]
do

	PROCESO=$1

	ps -el | grep " $PROCESO$" > misprocesos

	if
  	  [ -s misprocesos ]
	then 
		while
			read LINEA
		do
			PID=`echo $LINEA | tr -s " " | cut -d" " -f4`
			PIDPADRE=`echo $LINEA | tr -s " " | cut -d" " -f5`
			if
				[ $PIDPADRE -eq 0 ]
			then
				NOMPADRE="No tiene padre"
			else
				NOMPADRE=`ps -p $PIDPADRE | tail -1 | sed 's/^*//' | tr -s " " | cut -d" " -f5`
			fi
		echo PROCESO NOMBRE $PROCESO
		echo PROCESO NUMERO $PID
		echo PROCESO PADRE NUMERO $PIDPADRE
		echo PROCESO PADRE NOMBRE $NOMPADRE
		echo __________________________________
		done < misprocesos
	else
		echo El proceso $PROCESO no existe
	fi
	shift
done
exit 0
