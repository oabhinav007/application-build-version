FROM tomcat:8.5-jdk11-corretto-al2

COPY target/*.war /usr/local/tomcat/webapps/

COPY src/main/java/zama/training/controller/build.txt /usr/local/tomcat/

EXPOSE 8080

CMD ["catalina.sh","run"]