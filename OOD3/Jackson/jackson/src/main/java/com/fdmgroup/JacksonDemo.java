package com.fdmgroup;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonDemo {
    public static void main(String[] args) {
        Trainee trainee = new Trainee(1, "Dillon", "Coleman", AcademyStream.JAVA);
        ObjectMapper mapper = new ObjectMapper();
        File destination = new File(
                "C:/Users/Pendragon/OneDrive/Documents/Save/Programming/Project Explorer/Java Projects/OOD3/Jackson/jackson/target/trainee.json");
        try {
            mapper.writeValue(destination, trainee);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            mapper.readValue(destination, Trainee.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
