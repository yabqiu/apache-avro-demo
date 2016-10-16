# Apache Avro Demo

This project Demonstrates how to use Apache Avro to serialize/deserialize object.

Execute

```
mvn exec:java -Dexec.mainClass=cc.unmi.AvroDataTranser
```

Generates `cc.unmi.data.User.java` class file, and get the print out

```
Same object? false
Objects equal? true
All fields: {"name": "Yanbin", "address": "Chicago"}
```

That verifies serializing/deserializing is passed.