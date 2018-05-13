if 
  [ $# -eq 0 ]
then
  echo error, no hay ningun parametro
  exit 1
fi

PROCESO=$1

ps -el | grep " $PROCESO$" > proccess

LINEA=`ps -el | grep " $PROCESO$" | head -1`
shift
if
[ ! -s proccess ]
then 
  echo el, proceso no existe
  exit 2
else
    while
    	read LINEA
    do

      PID=`echo $LINEA | tr -s " " | cut -d" " -f4`
      PPADRE=`echo $LINEA | tr -s " " | cut -d" " -f5`
  
      if 
        [ $PPADRE -eq 0 ]
      then
        NPADRE="No tiene padre"
      else
        NPADRE=`ps -p $PPADRE | tail -1 | sed 's/^ *//' | tr -s " " | cut -d" " -f4`
      fi

      echo ____________________________________
      echo proceso: PID: $PID NOMBRE: $PROCESO
      echo padre: PPID: $PPADRE NOMBRE: $NPADRE 
      echo ___________________________________
      _
    done < proccess
fi
