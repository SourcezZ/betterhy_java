set sourcefolder=D:\Subject\betterhy\
set targetfolder=D:\Subject\betterhy\betterhy\
set setting=D:\Subject\betterhy\betterhy_maven_repository\setting_myself.xml

D:

echo "���ڱ���BetterHy============================================="
cd %sourcefolder%\betterhy
call mvn clean package -Dmaven.test.skip=true --settings %setting%
move /y %sourcefolder%\betterhy\target\betterhy.jar %targetfolder%
echo "����BetterHy���============================================="

pause
