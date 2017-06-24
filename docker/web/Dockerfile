FROM daocloud.io/library/maven:3.5.0
MAINTAINER xuqplus <445172495@qq.com>

RUN apt update
RUN apt install supervisor -y

ADD j2ee/src /
ADD j2ee/pom.xml /
RUN cd / && mvn dependency:resolve && mvn -DskipTests=true package
RUN cp /src/target/*.jar /app.jar && rm -rf /src /pom.xml

ADD docker/web/conf/supervisord.conf /etc/

EXPOSE 8080

CMD /usr/bin/supervisord