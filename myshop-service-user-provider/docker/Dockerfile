FROM openjdk:8-jre


ENV APP_VERSION 1.0.0-SNAPSHOT
ENV DOCKERIZE_VERSION v0.6.1
RUN wget http://192.168.219.149/x-power/tools/raw/master/dockerize-linux-amd64-v0.6.1.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && rm dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz

RUN mkdir /app

COPY myshop-service-user-provider-$APP_VERSION.jar /app/app.jar

ENTRYPOINT ["dockerize", "-timeout", "5m", "-wait", "tcp://192.168.219.149:3306", "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar"]
EXPOSE 8501 22222 20881