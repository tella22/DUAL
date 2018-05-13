PROCESO=$1

ps -e | grep " $PROCESO$" | cut -c1-6
