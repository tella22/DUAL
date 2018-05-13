TIPO=$1

if
	[ $1 = d -o $1 = f ]
	
then
	find / -name $2 -type $TIPO > fichero 2>/dev/null
	if
		[ -s fichero ]
	then
 		VAR=`cat fichero | wc -l`
		echo $2 existe y hay $VAR
	else
		echo $2 no existe
	fi
else if

	[ $1 = t  ]

then

	find / -name $2 > fichero 2>/dev/null
	
	if
                [ -s fichero ]
        then
                VAR=`cat fichero | wc -l`
                echo $2 existe y hay $VAR
        else
                echo $2 no existe
        fi 
fi
fi
