FROM ruby:2.3.1-slim

WORKDIR /app
COPY Gemfile /app/
COPY Gemfile.lock /app/

RUN bundle --path vendor/bundle
