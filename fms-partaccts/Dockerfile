FROM fmes/openjdk17:latest

# label for the image
LABEL Description="Participant / Account Service" Version="0.0.1"

# the version of the archive
ARG VERSION=0.0.1

WORKDIR /opt/soft/

ENV PATH_LOG /opt/log/

# Add the service as app.jar
ADD target/fms-partaccts-${VERSION}-SNAPSHOT.jar app.jar
ADD entrypoint.sh .

# touch the archive for timestamp
RUN sh -c 'touch app.jar'

EXPOSE 8080

# entrypoint to the image on run
ENTRYPOINT ["./entrypoint.sh"]