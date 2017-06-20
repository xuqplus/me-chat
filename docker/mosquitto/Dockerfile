FROM centos:7
MAINTAINER xuqplus <445172495@qq.com>

RUN yum install -y epel-release mosquitto

ADD certs /etc/mosquitto
ADD conf/mosquitto.conf /etc/mosquitto

CMD /usr/bin/python /usr/bin/supervisord