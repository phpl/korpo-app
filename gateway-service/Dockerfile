FROM openjdk:13-alpine

EXPOSE 8080
ENV APP_FILE gateway-service-0.0.1-SNAPSHOT.jar
COPY build/libs/$APP_FILE ./
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $APP_FILE"]