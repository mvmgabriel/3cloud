FROM openjdk:17
LABEL Description="FMS Instruments" Version="0.0.1"
ARG VERSION=0.0.1
VOLUME /tmp
ADD ./target/fms-instruments-${VERSION}-SNAPSHOT.jar fms-instruments.jar
ENTRYPOINT ["java","-jar","/fms-instruments.jar"]