cd /home/tibco/timnow-deploy

NOW_TOMCAT_DIR=/product/app/tomcat/
NOW_CONFIG_DIR=/home/tibco/timnow/config

if [ ! -f 'timnow_L2_${BUILD_NUMBER}_${BUILD_TIMESTAMP}.war' ]; then
    echo 'il file timnow_L2_${BUILD_NUMBER}_${BUILD_TIMESTAMP}.war non è presente nel path ' $PWD
    exit 1
fi

# remove old files
if [ -f 'config.properties'] ; then
    rm 'config.properties'
fi

if [ -f 'angularapp.properties'] ; then
    rm 'angularapp.properties'
fi

if [ -f 'config.properties'] ; then
    rm 'timnow.war'
fi

mv timnow_L2_${BUILD_NUMBER}_${BUILD_TIMESTAMP}.war timnow.war

if [ ! -f 'timnow.war' ]; then
    echo 'il file "timnow.war" non è presente nel path ' $PWD
    exit 1
fi

if [ ! -d $NOW_TOMCAT_DIR ]; then
    echo 'il path indicato come NOW_TOMCAT_DIR non esiste ' $NOW_TOMCAT_DIR
    exit 1
fi

# configure env properties
echo "# Properties added automatically by build ${BUILD_NUMBER}"  >> config.properties 
echo "rest.client.baseurl=http://nowsvcas3.telecomitalia.local:8181" >> config.properties 

# move config file
mv config.properties $NOW_CONFIG_DIR
mv angularapp.properties $NOW_CONFIG_DIR

# stop tomcat
sh $NOW_TOMCAT_DIR/bin/shutdown.sh

# clean webapps
rm -rf $NOW_TOMCAT_DIR/webapps/timnow
rm -rf $NOW_TOMCAT_DIR/webapps/timnow.war

# move war
mv timnow.war $NOW_TOMCAT_DIR/webapps/timnow.war

# start tomcat
sh $NOW_TOMCAT_DIR/bin/startup.sh