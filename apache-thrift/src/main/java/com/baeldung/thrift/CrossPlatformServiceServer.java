package com.baeldung.thrift;

import com.baeldung.thrift.impl.CrossPlatformService;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

public class CrossPlatformServiceServer {

    private TServer server;

    public void start() throws TTransportException {
        TServerTransport serverTransport = new TServerSocket(9090);
        server = new TSimpleServer(makeServerSettings(serverTransport));

        System.out.print("Starting the server... ");

        server.serve();

        System.out.println("done.");
    }

    public void stop() {
        if (server != null && server.isServing()) {
            System.out.print("Stopping the server... ");

            server.stop();

            System.out.println("done.");
        }
    }

    private static TServer.Args makeServerSettings(TServerTransport serverTransport) {
        return new TServer.Args(serverTransport)
                .processor(new CrossPlatformService.Processor<>(new CrossPlatformServiceImpl()));
    }
}
