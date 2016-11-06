# rest-custom-injection

### Run and build
Step-1 : 
./gradlew clean build

Step-2 :
java -jar build/libs/sample-0.0.1-SNAPSHOT.jar

### Test
non context inject approach
Run curl http://localhost:{your_server_port}/api/custom-context
context inject approach
Run curl http://localhost:{your_server_port}/api/custom-context-inject

### Implementation details
Following the documentation https://jersey.java.net/documentation/latest/ioc.html to setup custom context injection.
1) defining a new custom context injection annotation
ContextInject.java
2) implement our own injection provider
ContextInjectResolver.java
3) register the injection resolver in ApplicationConfig