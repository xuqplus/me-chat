FROM centos:7
MAINTAINER xuqplus <445172495@qq.com>

ADD source/get-pip.py /tmp
RUN python /tmp/get-pip.py
RUN pip install supervisor

RUN yum install epel-release -y
RUN yum install mosquitto -y

ADD conf/mosquitto.conf /etc/mosquitto
ADD conf/supervisord.conf /etc

EXPOSE 1883 1884

CMD /usr/bin/python /usr/bin/supervisord -c /etc/supervisord.conf
