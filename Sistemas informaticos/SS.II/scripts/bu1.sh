GRP=dua1
LISTA=`seq -f%02g 1 99`
DPADRE=/home/$GRP

for NUM in $LISTA

do

	USUARIO=$GRP$NUM
		
	TRYUSER=`cat /etc/passwd | grep ^$USUARIO:`

	if [ $? -eq 0 ]; then
		
		HOME=`cat /etc/passwd | grep ^$USUARIO: | cut -d":" -f6`

		userdel $USUARIO 2> /dev/null
		rm -r $HOME
		echo $USUARIO eliminado!!

	else 
		echo el usuario $USUARIO no existe.
	fi

done

if cat /etc/group | grep ^$GRP: > /dev/null; then

	groupdel $GRP
	echo "____________________________"
	echo Grupo $GRP eliminado!!
	echo "____________________________"
else
	echo "****************************"
	echo el grupo no existe
	echo "****************************"
fi

if [ -d $DPADRE ]; then

	rm -r $DPADRE
	echo "____________________________"
	echo Directorio padre eliminado!!
	echo "____________________________"
else
	echo "****************************"
	echo Directorio padre no existe
	echo "****************************"
fi
