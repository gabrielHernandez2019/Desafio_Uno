package cl.previred.consultadatos.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cl.previred.consultadatos.exceptions.JsonException;
import cl.previred.consultadatos.model.DatosVO;

import static cl.previred.consultadatos.utilidades.UtilJson.getObjectByJson;

@Service
public class ConsultaPeriodoServices extends ClienteRest {

	 	@Value("${api.periodos.endpoint}")
	    private String endPointPeriodoService;

	    public DatosVO obtenerPeriodos() throws JsonException {

	    	DatosVO datos;

	        String body = getRequest(endPointPeriodoService);
	        datos = getObjectByJson(body, DatosVO.class);

	       return datos;
	    }
}
