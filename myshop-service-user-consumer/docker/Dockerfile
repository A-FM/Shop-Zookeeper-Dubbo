FROM openjdk:8-jre


ENV APP_VERSION 1.0.0-SNAPSHOT
ENV DOCKERIZE_VERSION v0.6.1
RUN wget http://192.168.219.149/x-power/tools/raw/master/dockerize-linux-amd64-v0.6.1.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && rm dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz

RUN mkdir /app

COPY myshop-service-user-consumer-$APP_VERSION.jar /app/app.jar
#  监听 dubbo的 数据传输端口   ---  20881
ENTRYPOINT ["dockerize", "-timeout", "5m", "-wait", "tcp://192.168.219.151:20881", "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar"]
EXPOSE 8601 8701