FROM centos:6.8
MAINTAINER xuqplus <445172495@qq.com>

ADD source/get-pip.py /tmp
RUN python /tmp/get-pip.py

ADD source/maven.repo /etc/yum.repos.d
RUN yum install -y java apache-maven

CMD /bin/bash