FROM fmes/openjdk17:latest
# label for the image
LABEL Description="Eureka Server" Version="0.0.1"
# the version of the archive
ARG VERSION=0.0.1
# mount the temp volume
WORKDIR /tmp
# Add the service as app.jar
ADD target/fms-eureka-server-${VERSION}-SNAPSHOT.jar app.jar
ADD entrypoint.sh .
RUN chmod 755 entrypoint.sh
# touch the archive for timestamp
RUN sh -c 'touch /app.jar'
EXPOSE 8761
# entrypoint to the image on run
ENTRYPOINT ["./entrypoint.sh"]