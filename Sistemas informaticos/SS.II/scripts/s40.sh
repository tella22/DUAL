OPCION=$1	
shift
PARAMETROS=$*

	OPCION=`echo $OPCION | tr "[[:lower:]]" "[[:upper:]]"`
	test "$OPCION" = UNO && OPCION=1
	test "$OPCION" = DOS && OPCION=2
	test "$OPCION" = TRES && OPCION=3

	case $OPCION in

	1)
		echo lista de parametros
		while
			 [ $# -gt 0 ]
		do
			echo $1
			shift
		done
	;;

	2)
		echo lista de parametros por parejas
                while
                         [ $# -gt 0 ]
                do
                        echo $1 $2
			if [ $# -eq 1 ]; then
				shift
			else if [ $# -gt 2 ]; then
				shift 2
			fi 
			fi
		done
	;;

	3)
		echo lista de parametros por trios
                while
                        [ $# -gt 0 ]
                do
                        echo $1 $2 $3
                        if [ $# -eq 1 ]; then
                        	shift
			else if [ $# -eq 2 ]; then 
			 	shift 2
			else 
				shift 3
			fi
                        fi
                done
	;;

	*)
		echo no has introducido una opcion valida
	;;

	esac
