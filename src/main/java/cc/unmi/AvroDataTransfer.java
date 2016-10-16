package cc.unmi;

import cc.unmi.data.User;
import org.apache.avro.io.*;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class AvroDataTransfer {
    public static void main(String[] args) throws IOException {
        User originalUser =  new User("Yanbin", "Chicago");
        User deserializedUser = deserializeUser(serializeUser(originalUser));
        System.out.println(deserializedUser == originalUser);
        System.out.println(deserializedUser);
    }

    private static byte[] serializeUser(User user) throws IOException {
        DatumWriter<User> userDatumWriter = new SpecificDatumWriter<>(User.class);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BinaryEncoder binaryEncoder = EncoderFactory.get().directBinaryEncoder(outputStream, null);
        userDatumWriter.write(user, binaryEncoder);
        return outputStream.toByteArray();
    }

    private static User deserializeUser(byte[] data) throws IOException {
        DatumReader<User> userDatumReader = new SpecificDatumReader<>(User.class);
        BinaryDecoder binaryEncoder = DecoderFactory.get().directBinaryDecoder(new ByteArrayInputStream(data), null);
        return userDatumReader.read(new User(), binaryEncoder);
    }
}
