package pe.edu.cibertec.rueditas_back_end.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.rueditas_back_end.dto.BuscarVehiculoRequestDTO;
import pe.edu.cibertec.rueditas_back_end.service.BuscarVehiculoService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class BuscarVehiculoImpl implements BuscarVehiculoService {

    // Inyeccion de dependencias
    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] buscarVehiculo(BuscarVehiculoRequestDTO buscarVehiculoRequest) throws IOException {

        String[] datosVehiculo = null;
        Resource resource = resourceLoader.getResource("classpath:vehiculos.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                // Divide la linea de texto en varias partes con ; como delimitador
                String[] datos = linea.split(";");

                if (buscarVehiculoRequest.placa().equals(datos[1])) {

                    datosVehiculo = new String[5];
                    datosVehiculo[0] = datos[2];
                    datosVehiculo[1] = datos[3];
                    datosVehiculo[2] = datos[4];
                    datosVehiculo[3] = datos[5];
                    datosVehiculo[4] = datos[6];
                    break;

                }

            }

        } catch (IOException e) {

            datosVehiculo = null;
            throw new IOException(e);

        }

        return datosVehiculo;

    }

}
