#!/bin/bash

PLACEHOLDER='##DA IMPOSTARE##';
CONFIG_PROPERTIES_FILE="$WORKSPACE/timnow.resources/config/config.properties"
ANGULARAPP_PROPERTIES_FILE="$WORKSPACE/timnow.resources/config/angularapp.properties"

# Rimozione di tutte le properties relative agli ambienti di sviluppo nel
# file config.properties
CONFIG_PROPERTIES=(
  'rest.client.baseurl' 
  'rest.client.pps.baseurl' 
  'files.manuale.utente.path' 
  'files.manuale.olo.path'
)

echo ''
echo '------------------------------------------------'
echo '--------- RESET PROPERTIES DI AMBIENTE ---------' 
echo '------------------------------------------------'
echo ''

for item in "${CONFIG_PROPERTIES[@]}"; do
	echo $item'='$PLACEHOLDER
	sed -i "s/$item=[^ ]*/$item=$PLACEHOLDER/g" "$CONFIG_PROPERTIES_FILE"
done

# Rimozione di tutte le properties relative alla configurazione SSL nel
# file config.properties
SSL_PROPERTIES=(
  'ws.keyStoreFileLocation' 
  'ws.trustStoreFileLocation' 
  'ws.keyStorePassword' 
  'ws.keyStoreKeyPassword'
  'ws.trustStorePassword'
)

echo ''
echo '------------------------------------------------'
echo '--------- RESET PROPERTIES SSL -----------------' 
echo '------------------------------------------------'
echo ''

echo 'ws.sslPolicy=easy' 
sed -i "s/ws.sslPolicy=[^ ]*/ws.sslPolicy=easy/g" "$CONFIG_PROPERTIES_FILE"

for item in "${SSL_PROPERTIES[@]}"; do
	echo $item'=' 
	sed -i "s/$item=[^ ]*/$item=/g" "$CONFIG_PROPERTIES_FILE"
done

# Rimozione di tutte le properties relative agli ambienti di sviluppo nel
# file angularapp.properties
ANGULAR_PROPERTIES=(
  'catalogGuiURL'
  'userTaskGUIURL'
  'trackingAppURL'
)

echo ''
echo '------------------------------------------------'
echo '--------- RESET PROPERTIES ANGULAR -------------' 
echo '------------------------------------------------'
echo ''

for item in "${ANGULAR_PROPERTIES[@]}"; do
	echo $item'='$PLACEHOLDER
	sed -i "s/$item=[^ ]*/$item=$PLACEHOLDER/g" "$ANGULARAPP_PROPERTIES_FILE"
done

