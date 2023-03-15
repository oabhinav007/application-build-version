FROM tomcat:8.5-jdk11-corretto-al2

COPY target/*.war /usr/local/tomcat/webapps/

COPY build.txt /usr/local/tomcat/

EXPOSE 8080

CMD ["catalina.sh","run"]