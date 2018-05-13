TIPO=$1

if
	[ $1 = d -o $1 = f ]
	
then
	while [ $# -gt 1 ]
	do		
           find / -name $2 -type $TIPO > fichero 2>/dev/null
	   if
		[ -s fichero ]
           then
 		VAR=`cat fichero | wc -l`
		echo $2 existe y hay $VAR
	   else
		echo $2 no existe
	   fi
	   shift
done
else if

	[ $1 = t  ]

then
	while [ $# -gt 1 ]
        do  
	   find / -name $2 > fichero 2>/dev/null
	
	   if
                [ -s fichero ]
           then
                VAR=`cat fichero | wc -l`
                echo $2 existe y hay $VAR
           else
                echo $2 no existe
           fi  
           shift
	done

   fi
fi
