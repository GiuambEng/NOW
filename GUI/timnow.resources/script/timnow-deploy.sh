#!/bin/sh


NOW_TOMCAT_DIR=/opt/tomcat/apache-tomcat-8.0.33/

if [ ! -f 'timnow.war' ]; then
    echo 'il file "timenow.war" non è presente nel path ' $PWD
    exit 1
fi

if [ ! -d $NOW_TOMCAT_DIR ]; then
    echo 'il path indicato come NOW_TOMCAT_DIR non esiste ' $NOW_TOMCAT_DIR
    exit 1
fi


# stop tomcat
sh $NOW_TOMCAT_DIR/bin/shutdown.sh

# clean webapps
rm -rf $NOW_TOMCAT_DIR/webapps/timnow
rm -rf $NOW_TOMCAT_DIR/webapps/timnow.war

# move war
mv timnow.war $NOW_TOMCAT_DIR/webapps/timnow.war

# start tomcat
sh $NOW_TOMCAT_DIR/bin/startup.sh