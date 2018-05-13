#! /bin/bash

echo introduce un nº
read VAR1

echo introduce otro nº
read VAR2

if
	[ $VAR1 -gt $VAR2 ]
then
        echo "$VAR2 es menor"
elif
        [ $VAR1 -lt $VAR2  ]
then
        echo $VAR1 es menor
else
        echo son iguales
fi
