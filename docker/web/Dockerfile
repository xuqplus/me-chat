FROM daocloud.io/library/maven:3.5.0
MAINTAINER xuqplus <445172495@qq.com>

RUN apt update
RUN apt install supervisor -y

RUN git clone https://github.com/xuqplus/me-chat.git
RUN mkdir /tmp/build && cp /me-chat/j2ee/pom.xml /tmp/build && cd /tmp/build && mvn dependency:resolve
RUN cp -r /me-chat/j2ee/src /tmp/build && cd /tmp/build && mvn -DskipTests=true package
RUN cp /tmp/build/target/*.jar /app.jar && rm -rf /tmp/build /me-chat

ADD conf/supervisord.conf /etc/

EXPOSE 8080

CMD /usr/bin/supervisord