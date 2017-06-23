FROM daocloud.io/library/centos:6.8
MAINTAINER xuqplus <445172495@qq.com>

RUN apt update
RUN apt install supervisor -y

RUN git clone https://github.com/xuqplus/me-chat.git
RUN mkdir /tmp/build && cp /me-chat/j2ee/pom.xml /tmp/build && cd /tmp/build && mvn dependency:resolve
RUN cp -r /me-chat/j2ee/src /tmp/build && cd /tmp/build && mvn -DskipTests=true package
RUN cp /tmp/build/target/*.jar /app.jar && rm -rf /tmp/build /me-chat

EXPOSE 80 8080

CMD java -Djava.security.egd=file:/dev/./urandom -jar /app.jar