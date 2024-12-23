package org.example.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Unicorn {
    private String name;
    private String tailColor;
    //@SerializedName("_id")
    @JsonProperty("_id")  // Парсит указанное поле из Json  в переменную ниже
    private String id;


   /* @Override
    public String toString() {
        return "{\n" +
                "  \"name\":\"" + name + "\",\n" +
                "  \"tailColor\":" + tailColor + "\"\n" +
                "}";
    }

   /* public String toJSON(){
        return "{\n" +
                "  \"name\":\"" + name + "\",\n" +
                "  \"tailColor\":\"" + tailColor + "\"\n" +
                "}";
    }*/  //Тутова мы сериализуем объект в JSON
}
