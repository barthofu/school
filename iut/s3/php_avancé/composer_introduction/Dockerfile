FROM php:7.4-apache

WORKDIR /var/www/html/

COPY --from=composer:latest /usr/bin/composer /usr/local/bin/composer

CMD "composer" "install" "--prefer-dist"