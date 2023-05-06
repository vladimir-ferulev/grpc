package com.company.grpc.server;

import io.grpc.*;

public class MyServerInterceptor implements ServerInterceptor {
    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
            ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {

        // Здесь вы можете перехватить и обработать входящий запрос.
        // Например, выведите информацию о запросе:
        System.out.println("Запрос получен: " + call.getMethodDescriptor().getFullMethodName());

        // Вызовите следующий обработчик в цепочке, передавая ServerCall и Metadata.
        // Верните результат, чтобы продолжить обработку запроса.
        return next.startCall(call, headers);
    }
}