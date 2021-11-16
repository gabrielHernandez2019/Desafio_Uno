package cl.previred.consultadatos.utilidades;

import cl.previred.consultadatos.exceptions.JsonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UtilJson {
	
	@SuppressWarnings("unchecked")
	public static <T> T getObjectByJson(String json, Class<T> type) throws JsonException {

        try {
            return (T) new ObjectMapper().readValue(json, Class.forName(type.getName()));
        } catch (JsonProcessingException | ClassNotFoundException e) {
            throw new cl.previred.consultadatos.exceptions.JsonException("Ocurrio un error al momento de extraer el Objeto del Json: " + json, e);
        }
    }
}
