# docker rm -f webapp | true
# docker rm -f daggerok/spark-kotlin-micro | true
# docker rmi -f daggerok/spark-kotlin-micro:latest | true
# docker build --rm -t daggerok/spark-kotlin-micro -f $PWD/docker/src/main/docker/Dockerfile $PWD
# docker tag daggerok/spark-kotlin-micro daggerok/spark-kotlin-micro:latest
# docker push daggerok/spark-kotlin-micro:latest
# docker run -d -p 80:8080 --name webapp daggerok/spark-kotlin-micro:latest
# docker run -d -p 80:8080 --name webapp -v $PWD/server/build/libs:/opt daggerok/spark-kotlin-micro:latest
FROM frolvlad/alpine-oraclejdk8:slim
COPY ./build/libs /opt
EXPOSE 8080
VOLUME "/opt"
ENTRYPOINT java -jar /opt/*.jar
