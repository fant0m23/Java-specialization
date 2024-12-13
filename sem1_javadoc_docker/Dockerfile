FROM bellsoft/liberica-openjdk-alpine:11.0.16.1-1
WORKDIR /usr/
COPY . .
RUN ["javac", "-sourcepath", "./src", "-d", "./out", "./src/gb/javacore/main/Main.java"]
