FROM node:16-alpine3.17

WORKDIR /app

COPY app/package.json /app

RUN npm install

COPY ./app /app

EXPOSE 4401
CMD ["node", "server.js"]