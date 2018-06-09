package com.test.jsonShit;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonValidator;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ProcessingException
    {
        final ObjectMapper mapper = new ObjectMapper();

        //generate a schema for the house Class
        final JsonNode schema = JsonLoader.fromString( mapper.generateJsonSchema(House.class).toString());

        //create some nodes to check against the schema we have just generated
        final JsonNode node = JsonLoader.fromString( mapper.writeValueAsString(new House(10,10)));
        final JsonNode node2 = JsonLoader.fromString( mapper.writeValueAsString(new Cat("Mr Whiskers")));


        final JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        JsonValidator validator = factory.getValidator();

        //This should print out success
        System.out.println(validator.validate(schema,node));

        //This should print out failure
        System.out.println(validator.validate(schema,node2));
    }
}


