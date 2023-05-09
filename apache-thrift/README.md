## Apache Thrift

This module contains articles about Apache Thrift

### Relevant articles:

- [Working with Apache Thrift](https://www.baeldung.com/apache-thrift)


  В этом проекте нет необходимости вручную генерировать Java классы. Это делает maven плагин.
  Но все равно нужно установить компилятор thrift на компьютер. 

  Чтобы вручную сгенерировать Java классы нужно находясь в корне модуля apache-thrift выполнить команду:
> thrift -r -out generated --gen java src/main/resources/service.thrift