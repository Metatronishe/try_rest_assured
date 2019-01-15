FROM openjdk:8-slim
COPY . /code
WORKDIR /code
RUN apt-get update \
    && apt-get install software-properties-common -y \
    && apt-add-repository ppa:qameta/allure -y \
    && apt-get update \
    && apt-get install allure \
    && gradle build