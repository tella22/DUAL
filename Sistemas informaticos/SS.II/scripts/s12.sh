if 
	[ $# -ne 1  ]
then
	echo introduce solo un parametro
else
	if
		[ -d $1 ]
	then
		echo $1 existe
	else
		echo $1 no existe
	fi
fi
