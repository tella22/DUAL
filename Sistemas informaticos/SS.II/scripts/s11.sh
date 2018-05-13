CONT=1  
CONT2=2 
VAR=$#

echo __________________________________________________________
echo numeros de parametros $#
echo lista de parametros $*
echo __________________________________________________________

if 	
	[ $# -eq 0  ]
then	
	echo no has introducido parametros
	exit 1
else	
	while 
	        [ $# -gt 0  ]
	do		
		if ! [ `expr $# % 2` -eq 0 ];then
			echo parametro $CONT y $CONT2: $1 y $2
			shift 2
		else
			echo parametro $CONT: $1
			shift
		fi
		
                CONT=`expr $CONT + 2`
                CONT2=`expr $CONT2 + 2`
	done
	
	echo __________________________________________________________
	echo numeros de parametros $# 
	echo lista de parametros $*
	echo __________________________________________________________
	
fi	
