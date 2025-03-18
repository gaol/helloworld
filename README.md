# Helloworld app for Quarkus

This is a quarkus helloworld app used for the demonstration deploying to the k8s cluster I just setup in my local 2 VMs.

This would be built to native and a Docker image and pushed to github package for the consumption in my k8s cluster.

In this project, it also show the set up of the github action to:

* build the native Docker image on push
* push the Docker image to ghcr.io on success build


This project has a dependency of:

```xml
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-container-image-docker</artifactId>
</dependency>
```

So that when `./mvnw clean package -Pnative` runs, it produces native build first, and call `docker build -f src/main/docker/Dockerfile.native -t lgao/helloworld:1.0.0-SNAPSHOT` under the hook.


## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```
