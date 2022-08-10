FROM fmes/openjdk11:latest

# label for the image
LABEL Description="Api Gateway" Version="0.0.1"

# the version of the archive
ARG VERSION=0.0.1

# mount the temp volume
VOLUME /tmp

# Add the service as app.jar
ADD target/gateway-${VERSION}-SNAPSHOT.jar app.jar
ADD entrypoint.sh .

# touch the archive for timestamp
RUN sh -c 'touch /app.jar'

EXPOSE 9000

# entrypoint to the image on run
ENTRYPOINT ["./entrypoint.sh"]