## gRPC

This module contains articles about gRPC

### Relevant Articles:

- [Introduction to gRPC](https://www.baeldung.com/grpc-introduction)
- [Streaming with gRPC in Java](https://www.baeldung.com/java-grpc-streaming)
- [Error Handling in gRPC](https://www.baeldung.com/grpcs-error-handling)


В этом проекте не нужно генерировать файлы вручную, чтобы запустить приложение. Даже устанавливать на систему не надо
protoc и плагин protoc-gen-grpc-java.
Генерация файлов выполняется с помощью maven плагина - protobuf-maven-plugin, который подключается и настраивается в pom.xml.

Тем не менее можно сгенерировать файлы вручную с помощью следующих команд, находясь в директории main:
> protoc --plugin=protoc-gen-grpc-java=/usr/local/bin/protoc-gen-grpc-java --java_out=java --grpc-java_out=java proto/HelloService.proto

> protoc --plugin=protoc-gen-grpc-java=/usr/local/bin/protoc-gen-grpc-java --proto_path=proto --java_out=java --grpc-java_out=java proto/commodity_price.proto

> protoc --plugin=protoc-gen-grpc-java=/usr/local/bin/protoc-gen-grpc-java --proto_path=proto --java_out=java --grpc-java_out=java proto/stock_quote.proto

--plugin=protoc-gen-grpc-java=/usr/local/bin/protoc-gen-grpc-java - здесь нужно указать правильный путь к плагину на вашем компьютере