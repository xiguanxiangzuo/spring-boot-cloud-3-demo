FROM openjdk:8-jdk-slim
LABEL maintainer=xiguanxiangzuo

COPY target/*.jar   /sentinel-1.8.7.jar

ENTRYPOINT ["java","-jar","/sentinel-1.8.7.jar"]