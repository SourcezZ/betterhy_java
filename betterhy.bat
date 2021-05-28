set sourcefolder=D:\develop\betterhy\
set targetfolder=D:\Subject\betterhy\betterhy_java\
set setting=D:\develop\betterhy\maven_repositories\setting_myself.xml

D:

echo "正在编译BetterHy============================================="
cd %sourcefolder%\betterhy_java
call mvn clean package -Dmaven.test.skip=true --settings %setting%
move /y %sourcefolder%\betterhy_java\target\betterhy.jar %targetfolder%
echo "编译BetterHy完成============================================="

pause
