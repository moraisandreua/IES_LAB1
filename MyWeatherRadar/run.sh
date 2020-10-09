mvn clean package
if [ -z "$1" ]
  then
    mvn exec:java -Dexec.mainClass="com.labpremier.WeatherStarter"
  else
    mvn exec:java -Dexec.mainClass="com.labpremier.WeatherStarter" -Dexec.args="$1"
fi

