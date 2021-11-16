package cl.previred.consultadatos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.previred.consultadatos.model.DatosVO;
import cl.previred.consultadatos.services.DatosFaltantesService;

@RequestMapping("v1/datos/consulta")
@RestController
public class ConsultaDatosController {
	
	private DatosFaltantesService datosFaltantesService;
	
	public ConsultaDatosController(DatosFaltantesService datosFaltantesService) {
		this.datosFaltantesService = datosFaltantesService;
	}
	
	@GetMapping("/periodos")
	public ResponseEntity<DatosVO> consultarFechasFaltantes() {
		DatosVO respuesta = new DatosVO();
		
		try {
			respuesta = datosFaltantesService.obtenerDatosFaltantes();
			 
			if (null==respuesta) {
				return new ResponseEntity<>(respuesta,HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(respuesta,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}

}
