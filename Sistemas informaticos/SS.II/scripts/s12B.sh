if 
	[ $# -ne 1  ]
then
	echo introduce solo un parametro
else
	find $1 -type f > fichero 2>/dev/null
	if
		[ -s fichero ]
	then
	 	VAR=`cat fichero | wc -l`
		echo $1 existe y hay $VAR
	else
		echo $1 no existe
	fi
fi
