FROM xuqplus/maven:3.5.0
MAINTAINER xuqplus <445172495@qq.com>

ADD source/get-pip.py /tmp
RUN python /tmp/get-pip.py
RUN pip install supervisor==3.2.2

RUN yum install -y git
RUN git clone https://github.com/xuqplus/me-chat.git
RUN mkdir /tmp/build && cp /me-chat/j2ee/pom.xml /tmp/build && cd /tmp/build && mvn dependency:resolve
RUN cp -r /me-chat/j2ee/src /tmp/build && cd /tmp/build && mvn -DskipTests=true package
RUN cp /tmp/build/target/*.jar /app.jar && rm -rf /tmp/build /me-chat

EXPOSE 8080

CMD /usr/sbin/supervisord