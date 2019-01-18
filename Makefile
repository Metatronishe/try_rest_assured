PROJECT_NAME?=twitter_test_api
COMPOSE_FILE?=./Docker/docker-compose.yml
SERVICE?=

COMPOSE_HTTP_TIMEOUT=86400

build: stop
	docker-compose -p ${PROJECT_NAME} -f ${COMPOSE_FILE} build

run: stop
	@test -f ${COMPOSE_FILE} && docker-compose -p ${PROJECT_NAME} -f ${COMPOSE_FILE} up -d

stop:
	@test -f ${COMPOSE_FILE} && docker-compose -p ${PROJECT_NAME} -f ${COMPOSE_FILE} stop

rm: stop
	@test -f ${COMPOSE_FILE} && docker-compose -p ${PROJECT_NAME} -f ${COMPOSE_FILE} rm -fv

test:
	docker exec -it ${PROJECT_NAME}_java gradle clean test

ssh:
	docker exec -it ${PROJECT_NAME}_java bash

logs:
	@test -f ${COMPOSE_FILE} && docker-compose -p ${PROJECT_NAME} -f ${COMPOSE_FILE} logs -ft ${SERVECE}

report:
	docker exec -it ${PROJECT_NAME}_java gradle allureReport && docker exec -it ${PROJECT_NAME}_java gradle allureServe
