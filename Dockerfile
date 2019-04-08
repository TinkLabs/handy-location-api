FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
RUN mkdir /app
RUN wget -O /app/elastic-apm-agent-1.5.0.jar https://search.maven.org/remotecontent?filepath=co/elastic/apm/elastic-apm-agent/1.5.0/elastic-apm-agent-1.5.0.jar
COPY target/${JAR_FILE} /app/app.jar
ENTRYPOINT ["java","-javaagent:/app/elastic-apm-agent-1.5.0.jar","-Djava.security.egd=file:/dev/./urandom","-jar","/app/app.jar"]