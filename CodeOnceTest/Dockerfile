#Using jdk 11 image
FROM azul/zulu-openjdk-alpine:11
#Create a virtual directory inside the docker image
WORKDIR /app

#Copy maven executable to the image
COPY .mvn/ .mvn

#Copy the pom.xml file
COPY mvnw pom.xml ./

#Build all the dependencies in preparation to go offline
RUN ./mvnw dependency:go-offline

#Copy the project source
COPY src ./src

#the app will be using port 8080
EXPOSE 8080
CMD ["./mvnw", "spring-boot:run"]