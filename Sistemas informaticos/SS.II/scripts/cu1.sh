GRP=dua1
SHELL=/bin/bash
LISTA=`seq -f%02g 1 99`
DPADRE=/home/$GRP

if [ -d $DPADRE ]

then
	echo Directorio $DPADRE ya existe
else
	echo Creando direcorio $DPADRE
	mkdir -p $DPADRE
fi

if
	cat /etc/group | grep ^$GRP: > /dev/null
then
	echo El grupo $GRP ya existe
else
	echo Creando grupo $GRP
	groupadd $GRP
fi

for NUM in $LISTA

do

USUARIO=$GRP$NUM
HOME=/home/$GRP/$USUARIO

	useradd -d $HOME -m -g $GRP -s $SHELL $USUARIO 2> /dev/null
	echo "usuario $USUARIO creado"

	if 
		[ $? -eq 0 ] 
	then

		(echo $USUARIO ; echo $USUARIO) | passwd $USUARIO > /dev/null 2> /dev/null
	else 
		echo el usuario existe, no se va a cambiar la contraseña
	fi

done
