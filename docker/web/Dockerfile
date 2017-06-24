FROM daocloud.io/library/maven:3.5.0
MAINTAINER xuqplus <445172495@qq.com>

RUN apt update
RUN apt install supervisor -y

ADD /j2ee/ /tmp/build/
ADD /j2ee/pom.xml /
RUN cd /tmp/build/ && mvn dependency:resolve
RUN cd /tmp/build/ mvn -DskipTests=true package
RUN cp /tmp/build/src/target/*.jar /app.jar && rm -rf /tmp/build/

ADD /docker/web/conf/supervisord.conf /etc/

EXPOSE 8080

CMD /usr/bin/supervisord