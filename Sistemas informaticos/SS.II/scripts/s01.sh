#!/bin/sh

#Prueba con variables

echo "introduce algo por teclado"

read VAR
MINUS=`echo $VAR | tr [:upper:] [:lower:]` 
MAYUS=`echo $VAR | tr [:lower:] [:upper:]`

echo has introducido $VAR

echo "en minusculas " $MINUS " en mayusculas " $MAYUS
