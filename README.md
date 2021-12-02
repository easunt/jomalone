
# jomalone
smart home emulator server
#최초 1회만 실행
docker run --name jomalone-mysql -e MYSQL_ROOT_PASSWORD=1234qwer -e MYSQL_DATABASE=jomalone -d -p 3309:3306 mysql:5.7
#서버 띄우고 싶으면 실행
./gradlew bootRun
