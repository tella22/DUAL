if
	[ $# -lt 0 ]
then
	echo [error] no has introducido parametros
	exit 1
fi

if
	[ $# -gt 3 ]
then
	echo [error] has introducido mas de 3 parametros
	exit 1
fi

ARCHIVO=$1
shift
LIMITELINEAS=`cat $ARCHIVO | wc -l`

if
	[ -f $ARCHIVO ]
then
	if 
		[ $# -eq 1 ] 
	then
		if
			[ $1 -lt $LIMITELINEAS ]
		then	
			cat $ARCHIVO -n | cut -c1-50 | tail -n +$1
		else
			echo [error] has introducido mas lineas en el parametro dos de las que hay en el archivo
		fi
	elif
		[ $# -eq 2 ]
	then	
		if
			[ $2 -gt $1 ]
		then
			if
				[ $1 -lt $LIMITELINEAS ]
			then
				if
					[ $2 -lt $LIMITELINEAS ]
				then
					cat $ARCHIVO -n | sed -n $1,$2p | cut -c1-50
				else
					echo [error] uno de los 2 parametros es mayor a las lineas totales del archivo
				fi
			fi
		else
			echo [error] el parametro 3 es menor al parametro 2
		fi
	elif
		[ $# -eq 0 ]
	then	
		cat $ARCHIVO -n | cut -c1-50
fi
else
	echo [error] el archivo no existe
fi
