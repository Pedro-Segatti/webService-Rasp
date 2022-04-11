/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Segatti
 */
public class JsonUtil {

    private static final Gson gson = new Gson();
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V201909);

    public static boolean validaEstruturaJson(String jsonValidar) {
        try {
            gson.fromJson(jsonValidar, Object.class);
            return true;
        } catch (JsonSyntaxException ex) {
            return false;
        }
    }

    public static boolean validaEstruturaJson(String jsonSchema, String jsonValidar) {
        try {
            JsonNode json = objectMapper.readTree(jsonValidar);
            JsonSchema schema = schemaFactory.getSchema(jsonSchema);

            Set<ValidationMessage> validationResult = schema.validate(json);

            if (validationResult.isEmpty()) {
                return true;
            } else {
                validationResult.forEach(vm -> System.err.println(vm.getMessage()));
                return false;
            }
        } catch (JsonProcessingException ex) {
            Logger.getLogger(JsonUtil.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
