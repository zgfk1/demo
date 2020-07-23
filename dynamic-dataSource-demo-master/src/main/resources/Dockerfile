### 基础镜像，使用alpine操作系统，openjkd使用8u201
FROM openjdk:8u201-jdk-alpine3.9

#作者
MAINTAINER zgf <rabbircat79@gmail.com>

# 配置环境变量 系统编码
ENV LANG="en_US.UTF-8" \
    LANGUAGE="en_US:en"  \
    LC_ALL="en_US.UTF-8"

#声明一个挂载点，容器内此路径会对应宿主机的某个文件夹
VOLUME /tmp

#应用构建成功后的jar文件被复制到镜像内，名字也改成了app.jar
ADD target/dynamic-datasource-0.0.1-SNAPSHOT.jar app.jar

# 修改容器时区为北京时间
#RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.ustc.edu.cn/g' /etc/apk/repositories &&\
#    apk --no-cache add tzdata  && \
#    ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
#    echo "Asia/Shanghai" > /etc/timezone

RUN bash -c 'mkdir /config'
RUN bash -c 'mkdir /log'
#暴露8088端口
EXPOSE 8088 5005



#启动容器时的进程
#ENTRYPOINT ["java","-Dfile.encoding=UTF-8","-Djava.security.egd=file:/dev/./urandom",\
#"-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005","-Dspring.profiles.active=sit","-jar","/app.jar"]

ENTRYPOINT ["java","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005" ,"-jar","/app.jar"]
