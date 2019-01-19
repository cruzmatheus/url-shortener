#!/bin/bash
echo "Building url-shortener image..."
./gradlew clean build docker -x test

echo "Building url-shortener container: port 8080"
docker run -p 8080:8080 -d url-shortener
