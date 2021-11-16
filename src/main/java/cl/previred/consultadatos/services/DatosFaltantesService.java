package cl.previred.consultadatos.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.previred.consultadatos.exceptions.JsonException;
import cl.previred.consultadatos.model.DatosVO;

@Service
public class DatosFaltantesService {

	private ConsultaPeriodoServices periodoService;

	@Autowired
	public DatosFaltantesService(ConsultaPeriodoServices periodoService) {
		this.periodoService = periodoService;
	}

	public DatosVO obtenerDatosFaltantes() throws JsonException {

		DatosVO datos = periodoService.obtenerPeriodos();
		String startDate = datos.getStartDate();
		String endDate = datos.getEndDate();

		long monthsBetween = ChronoUnit.MONTHS.between(LocalDate.parse(startDate).withDayOfMonth(1),
				LocalDate.parse(endDate).withDayOfMonth(1));

		int startDay = LocalDate.parse(startDate).getDayOfMonth();
		int startMonth = LocalDate.parse(startDate).getMonthValue();
		int startYear = LocalDate.parse(startDate).getYear();

		List<String> fechas = new ArrayList<>();

		for (int i = 0; i < monthsBetween; i++, startMonth++) {
			if (startMonth > 12) {
				startMonth = 1;
				startYear++;
			}

			fechas.add(startYear + "-" + completarFecha(String.valueOf(startMonth)) + "-"
					+ completarFecha(String.valueOf(startDay)));

		}

		for (String date : datos.getFechasEntrada()) {
			fechas.remove(date);
		}

		datos.setFechasSalida(fechas);

		return datos;
	}

	private static String completarFecha(String date) {

		StringBuilder stringBuilderDate = new StringBuilder();
		stringBuilderDate.append(date.length() == 1 ? "0" : "").append(date);
		return stringBuilderDate.toString();
	}

}
