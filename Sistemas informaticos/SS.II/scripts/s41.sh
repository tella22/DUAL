OPCION=$1
shift
USUARIO=$1

test -r /etc/shadow

if [ $? -eq 0 ]; then
	echo root ha ejecutado este script
	
	case $OPCION in
	u)
		while
			[ $# -gt 0 ]
		do
		MOSTRAR=`cat /etc/shadow | grep ^$USUARIO: | cut -d":" -f2`
		CARACTERES=`echo $MOSTRAR | cut -c1,2`
		
		if [ $CARACTERES = !! ]; then
			echo "usuario $USUARIO (BLOQUEADO)"
		else
			echo "usuario $USUARIO"
		fi
		shift
		USUARIO=$1
		done
	;;
	
	esac
else

	case $OPCION in
        u)
		while 
			[ $# -gt 0 ]
		do
		test `cat /etc/passwd | grep ^$USUARIO:`

		if [ $? -eq 0 ]; then
			GRUPOUSUARIO
		else
			echo el usuario no existe
		fi
		shift
		USUARIO=$1
		done
        ;;      
        
        esac


fi
