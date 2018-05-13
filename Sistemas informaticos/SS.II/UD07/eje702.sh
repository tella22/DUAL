#!/bin/sh
if 
	[ $# -eq 0 ]
then
	echo [error]: no has introducido parametros
	exit 1
elif 
	[ $# -gt 2 ]
then
	echo has introducido mas de 2 parametros
	exit 2
fi


if 
	[ $1 == "f" ]
then
	if 
		[ $# -eq 1 ]
	then
		find / -type f -user `id -un` 2>/dev/null
	else
		find / -type f -user `id -un` -name $2 2>/dev/null
	fi
elif
	[ $1 == "d" ]
then
	if
		[ $# -eq 1 ]
	then
		find / -type d -user `id -un` 2>/dev/null
	else
		find / -type d -user `id -un` -name $2 2>/dev/null
	fi
elif
	[ $1 == "t" ]
then
	if
		[ $# -eq 1 ]
	then
		find / -user `id -un` 2>/dev/null
	else
		find / -user `id -un` -name $2 2>/dev/null
	fi	
else
	echo el primer parametro no es f, d o t
	exit 3
fi
