FROM centos:6.8
MAINTAINER xuqplus <445172495@qq.com>

ADD source/get-pip.py /tmp
RUN python /tmp/get-pip.py

#创建配置文件模板
#RUN echo_supervisord_conf > /etc/supervisord.conf

CMD /bin/bash