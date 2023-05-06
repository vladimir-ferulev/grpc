package com.company.grpc.server;

import com.company.grpc.generated.GreeterGrpc;
import com.company.grpc.generated.HelloReply;
import com.company.grpc.generated.HelloRequest;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class HelloWorldServer {
    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(8080)
                .addService(new GreeterImpl())
                .intercept(new MyServerInterceptor())
                .build()
                .start();

        System.out.println("Server started, listening on 8080");
        server.awaitTermination();
    }

    static class GreeterImpl extends GreeterGrpc.GreeterImplBase {
        @Override
        public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
            String name = req.getName();
            String message = "Hello, " + name + "!";
            HelloReply reply = HelloReply.newBuilder().setMessage(message).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }
}