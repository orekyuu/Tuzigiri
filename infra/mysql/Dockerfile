FROM mysql:5.7

ENV LANG C.UTF-8
ENV TZ Asia/Tokyo

ARG MYSQL_ROOT_PASSWORD=password
ENV MYSQL_ROOT_PASSWORD $MYSQL_ROOT_PASSWORD

ARG APP_USER_PASSWORD=password
ENV APP_USER_PASSWORD $APP_USER_PASSWORD

ARG MIGRATOR_PASSWORD=password
ENV MIGRATOR_PASSWORD $MIGRATOR_PASSWORD

ADD ./docker-entrypoint-initdb.d /docker-entrypoint-initdb.d

RUN  /usr/bin/mysql_tzinfo_to_sql /usr/share/zoneinfo > /docker-entrypoint-initdb.d/timezone.sql


ADD ./timezone.cnf /etc/mysql/mysql.conf.d/

RUN set -x &&\
  sed -e "s/###APP_USER_PASSWORD###/$APP_USER_PASSWORD/g" \
      -e "s/###MIGRATOR_PASSWORD###/$MIGRATOR_PASSWORD/g" \
      /docker-entrypoint-initdb.d/20_CREATE_USER.sql.template > /docker-entrypoint-initdb.d/20_CREATE_USER.sql

RUN rm /docker-entrypoint-initdb.d/*.template

EXPOSE 3306
