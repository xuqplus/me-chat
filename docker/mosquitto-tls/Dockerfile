FROM centos:7
MAINTAINER xuqplus <445172495@qq.com>

RUN yum install -y epel-release mosquitto certbot

#创建ssl证书
#sudo certbot certonly --standalone --standalone-supported-challenges http-01 -d mqtt.xuqplus.space

ADD source/certs /etc/mosquitto
ADD conf/mosquitto.conf /etc/mosquitto

CMD /usr/bin/python /usr/bin/supervisord