#!/bin/bash

if [ $web_xuqplus_space ]
then
    echo -e $web_xuqplus_space '\tweb.xuqplus.space' >> /etc/hosts
else
    echo Please set env use -e web_xuqplus_space=x.x.x.x
    exit
fi

if [ $message_xuqplus_space ]
then
    echo -e $message_xuqplus_space '\tmessage.xuqplus.space' >> /etc/hosts
else
    echo Please set env use -e message_xuqplus_space=x.x.x.x
    exit
fi

cd / && ./sunny clientid 8b0db2876a17ae9b,d331ecdad35ea6bc

#tcp://server.ngrok.cc:61884 -> message.xuqplus.space:1884
#http://xuqplus.ngrok.cc -> web.xuqplus.space:8080

#/etc/hosts
#$web_xuqplus_space web.xuqplus.space
#$message_xuqplus_space essage.xuqplus.space