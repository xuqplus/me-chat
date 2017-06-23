FROM daocloud.io/library/centos:6.8
MAINTAINER xuqplus <445172495@qq.com>

RUN yum install -y java-1.8.0-openjdk.x86_64 java-1.8.0-openjdk-devel.x86_64

ADD source/apache-maven-3.5.0-bin.tar.gz /usr/share
ENV PATH /usr/share/apache-maven-3.5.0/bin:$PATH

CMD /bin/bash