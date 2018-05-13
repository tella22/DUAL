for PAR
	do
	find / -name $PAR -type f > fichero 2>/dev/null
	if
		[ -s fichero ]
	then
 		VAR=`cat fichero | wc -l`
		echo $PAR existe y hay $VAR
	else
		echo $PAR no existe
	fi
done
