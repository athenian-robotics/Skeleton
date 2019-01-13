#!/bin/bash

# ONLY WORKS ON LINUX MACHINES WITH NMCLI
# variables here can be altered
NAME=852_testBot
LOCAL=TASGUEST
LOCAL_KEY=2100owlDiablo


# don't change stuff below here unless you know what you are doing please
RED='\033[0;31m'
GREEN='\033[0;42m'
NC='\033[0;m'

m_reset=0

if [[ $EUID -eq 0 ]]; then
    echo -e "${RED}RESETTING WIFI INTERFACES${NC}"
    m_reset=1
fi


if [[ m_reset -ne 0 ]]; then
    ifconfig wlo1 down
    ifconfig wlo1 up
fi


echo -e "Establishing connection to 852_testBot"
nmcli device wifi connect ${NAME}
if [[ "$?" != "0" ]]; then
    echo -e "${RED}Could not find network ${NAME}, exiting...${NC}"
    exit 1
fi
echo -e "${GREEN}Connection Established${NC}"

echo -e "Building robot code..."
./gradlew build
if [[ "$?" != "0" ]]; then
    echo -e "${RED}Build failed, exiting...${NC}"
    exit 1
fi
echo -e "${GREEN}Robot code built${NC}"


echo -e "Deploying robot code..."
./gradlew deploy
if [[ "$?" != "0" ]]; then
    echo -e "${RED}Could not deploy robot code! Exiting...${NC}"
    exit 1
fi
echo -e "Robot code deployed"


if [[ m_reset -ne 0 ]]; then
    ifconfig wlo1 down
    ifconfig wlo1 up
fi


echo -e "Connecting back to ${LOCAL}"
nmcli device wifi connect ${LOCAL} password ${LOCAL_KEY}
if [[ "$?" != "0" ]]; then
    echo -e "${RED}Could not find network ${LOCAL}, exiting...${NC}"
    exit 1
fi
echo -e "${GREEN}Success!${NC}"
