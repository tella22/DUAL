for FICH
	do
		if
			[ ! -s $FICH ]
		then
			echo algun fichero no existe
			exit 1
		fi
	done

rm -f trabajadores

while
	[ $# -gt 0 ]
do
	while
		read LINEA
	do
		echo $LINEA:$1>>trabajadores
	done <$1
	shift
done
