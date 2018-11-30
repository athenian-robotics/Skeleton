#!/usr/bin/env bash
# Currently just pulls GradleRIO in
export CWD=$(pwd)
git clone https://github.com/wpilibsuite/GradleRIO.git
cd GradleRIO/examples/java
mv gradle $CWD
mv gradlew $CWD
cd $CWD
rm -rf GradleRIO
chmod +x gradlew
./gradlew