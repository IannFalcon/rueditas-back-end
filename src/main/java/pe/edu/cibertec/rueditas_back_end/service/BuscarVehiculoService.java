package pe.edu.cibertec.rueditas_back_end.service;

import pe.edu.cibertec.rueditas_back_end.dto.BuscarVehiculoRequestDTO;

import java.io.IOException;

public interface BuscarVehiculoService {

    String [] buscarVehiculo(BuscarVehiculoRequestDTO buscarVehiculoRequest) throws IOException;

}
