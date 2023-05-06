package com.company.rmi.client;


import com.company.rmi.Hello;
import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        try {
            // Клиент использует только интерфейс Hello для работы. Серверу нужен и интерфейс и реализация этого интерфейса.
            // В следующей строке выполняется поиск службы RMI, которую запустил сервер по адресу localhost
            // и порту 1099. Порт не указан, значит берется стандартный порт для RMI службы - 1099.
            Hello hello = (Hello) Naming.lookup("rmi://localhost/Hello");
            String response = hello.sayHello();     // RPC запрос отправляется по сети на сервер. Там выполняется реализация и обратно по сети возвращается ответ
            System.out.println("Response from RMI server: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e);
            e.printStackTrace();
        }
    }
}