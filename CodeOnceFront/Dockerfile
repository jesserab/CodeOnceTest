#First stage : BUILD 
FROM node:latest AS build 

#Create a virtual directory inside the docker image 
WORKDIR /usr/src/app 

COPY package.json ./

#Copy files from local machine to virtual directory in docker image 
COPY . . 

RUN npm install 

RUN npm run build  

#Second stage : RUN 
#Defining ngnix image to be used 
FROM nginx:latest AS ngi 

COPY --from=build /usr/src/app/dist/code-once-front /usr/share/nginx/html

#the app will be using port 80 while running 
EXPOSE 80 
