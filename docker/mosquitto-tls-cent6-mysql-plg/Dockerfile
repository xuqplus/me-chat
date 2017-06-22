FROM centos:6.8
MAINTAINER xuqplus <445172495@qq.com>

ADD source/get-pip.py /tmp
RUN python /tmp/get-pip.py
RUN pip install supervisor

#创建配置文件模板
#RUN echo_supervisord_conf > /etc/supervisord.conf

ADD source/libwebsockets-1.7.5.tar.gz /
ADD source/mosquitto-auth-plug-master-c41fcae2180f8e423c754fbe8766db5922816162.tar.gz /
ADD source/mosquitto-1.4.8.tar.gz /

RUN mv mosquitto-auth-plug-master-c41fcae2180f8e423c754fbe8766db5922816162 mosquitto-auth-plug

RUN yum install -y gcc gcc-c++ openssl-devel c-ares-devel libuuid-devel cmake

RUN mkdir /libwebsockets-1.7.5/build
RUN cd /libwebsockets-1.7.5/build && cmake .. && make && make install
RUN ln -s /usr/local/lib/libwebsockets.so.7 /usr/lib64/

RUN yum install -y libxslt-devel.x86_64 docbook-style-xsl
RUN mkdir -p /usr/share/xml/docbook/stylesheet/docbook-xsl
RUN cp -rf /usr/share/sgml/docbook/xsl-stylesheets-1.75.2/* /usr/share/xml/docbook/stylesheet/docbook-xsl
RUN sed -i '68s/no/yes/' /mosquitto-1.4.8/config.mk
RUN cd /mosquitto-1.4.8 && make && make install
RUN adduser mosquitto

CMD /bin/bash