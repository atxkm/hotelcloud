APP=hotelcloud.jar
PID=$(ps -ef | grep $APP | grep -v grep | awk '{ print $2 }')
if [ -z "$PID" ]
then
    echo Application is already stopped
else
    echo kill $PID
    kill $PID
    echo $APP is shutdown success!
fi
