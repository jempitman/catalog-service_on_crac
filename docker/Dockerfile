FROM ubuntu:20.04

ENV JAVA_HOME =/usr/lib/jvm


RUN apt-get update

ADD "https://github.com/CRaC/openjdk-builds/releases/download/17-crac%2B3/openjdk-17-crac+3_linux-x64.tar.gz" $JAVA_HOME/openjdk.tar.gz
RUN apt-get install -y \
  git \
  tar --extract --file $JAVA_HOME/openjdk.tar.gz --directory "$JAVA_HOME" --strip-components 1 \
  rm $JAVA_HOME/openjdk.tar.gz \
  mkdir -p /home/crac-files


ENV PATH $JAVA_HOME/bin:$PATH

#COPY build/libs/catalog-service-0.0.1-SNAPSHOT.jar /opt/app/catalog-service-0.0.1-SNAPSHOT.jar

#CMD ["/bin/bash"]