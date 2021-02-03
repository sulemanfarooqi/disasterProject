FROM openjdk:8
EXPOSE 2020
ADD target/disaster-recovery.jar disaster-recovery.jar
ENTRYPOINT ["java", "-jar","disaster-recovery.jar"] 