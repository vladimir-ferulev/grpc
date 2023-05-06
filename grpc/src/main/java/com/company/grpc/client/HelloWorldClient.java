package com.company.grpc.client;

import com.company.grpc.generated.GreeterGrpc;
import com.company.grpc.generated.HelloReply;
import com.company.grpc.generated.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.Future;

public class HelloWorldClient {
    public static void main(String[] args) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloRequest request = HelloRequest.newBuilder().setName("John Doe").build();

        // 1) блокирующий вызов
        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);
        HelloReply response = stub.sayHello(request);
        System.out.println("Server response: " + response.getMessage());

        // 2) неблокирующий вызов с колбэком
//        GreeterGrpc.GreeterStub stub = GreeterGrpc.newStub(channel);
//        stub.sayHello(request, new StreamObserver<HelloReply>() {
//            @Override
//            public void onNext(HelloReply response) {
//                System.out.println("Server response: " + response.getMessage());
//            }
//            @Override
//            public void onError(Throwable t) {
//                System.out.println("Cannot get response for " + request);
//            }
//            @Override
//            public void onCompleted() {
//                System.out.println("Stream completed");
//            }
//        });

        // 3) неблокирующий вызов с Future
//        GreeterGrpc.GreeterFutureStub stub = GreeterGrpc.newFutureStub(channel);
//        Future<HelloReply> future = stub.sayHello(request);
//        System.out.println("Server response: " + future.get());

        channel.shutdown();
    }
}