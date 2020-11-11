pid=`ps -ef | grep betterhy | grep -v grep | awk '{print $2}'`
if [ -n "$pid" ];then
	echo "kill id $pid"
	kill -9 $pid
fi
nohup java  -jar /root/prod/betterhy.jar  --spring.profiles.active=prod >>/root/prod/common.log 2>&1 &
