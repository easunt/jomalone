
# jomalone
smart home emulator server

docker run --name jomalone-mysql -e MYSQL_ROOT_PASSWORD=1234qwer -e MYSQL_DATABASE=jomalone -d -p 3309:3306 mysql:5.7
./gradlew bootRun
