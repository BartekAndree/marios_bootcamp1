FROM openjdk:11-jre-slim
EXPOSE 8083
VOLUME /tmp
COPY target/*.jar marios-backend.jar
ENTRYPOINT ["java","-jar","/marios-backend.jar"]