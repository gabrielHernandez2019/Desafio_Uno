package cl.previred.consultadatos.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({ "id", "fechaCreacion", "fechaFin", "fechas", "fechasFaltantes" })
public class DatosVO{
	
	@JsonProperty("id")
    private int id;

    @JsonProperty("fechaCreacion")
    private String startDate;

    @JsonProperty("fechaFin")
    private String endDate;

    @JsonProperty("fechas")
    private List<String> fechasEntrada;

    @JsonProperty("fechasFaltantes")
    private List<String> FechasSalida;

	
}