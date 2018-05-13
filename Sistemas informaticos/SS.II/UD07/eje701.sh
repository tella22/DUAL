echo numero de parametros introducidos: $#

CONTADOR=1

while
	[ $# -gt 0 ]; do
		echo Parametro $CONTADOR: $1
		shift
		CONTADOR=`expr $CONTADOR + 1`
done
