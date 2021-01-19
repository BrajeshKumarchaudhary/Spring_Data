FROM ubuntu:18.04
RUN apt-get update
RUN apt-get install openjdk-8-jdk -y
RUN apt-get -y install maven
MAINTAINER BRAJESH KUMAR(bk04031997@gmail.com)
WORKDIR /
# Install MongoDB.
RUN \
  apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 7F0CEB10 && \
  echo 'deb http://downloads-distro.mongodb.org/repo/ubuntu-upstart dist 10gen' > /etc/apt/sources.list.d/mongodb.list && \
  apt-get update && \
  apt-get install -y mongodb-org && \
  rm -rf /var/lib/apt/lists/*