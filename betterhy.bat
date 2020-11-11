set sourcefolder=D:\Subject\betterhy\
set targetfolder=D:\Subject\betterhy\betterhy\
set setting=D:\Subject\betterhy\betterhy_maven_repository\setting_myself.xml

D:

echo "正在编译BetterHy============================================="
cd %sourcefolder%\betterhy
call mvn clean package -Dmaven.test.skip=true --settings %setting%
move /y %sourcefolder%\betterhy\target\betterhy.jar %targetfolder%
echo "编译BetterHy完成============================================="

pause
