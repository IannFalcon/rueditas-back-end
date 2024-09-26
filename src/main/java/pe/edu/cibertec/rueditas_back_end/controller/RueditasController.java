package pe.edu.cibertec.rueditas_back_end.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.rueditas_back_end.dto.BuscarVehiculoRequestDTO;
import pe.edu.cibertec.rueditas_back_end.dto.BuscarVehiculoResponseDTO;
import pe.edu.cibertec.rueditas_back_end.service.BuscarVehiculoService;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

@RestController
@RequestMapping("/rueditas")
public class RueditasController {

    @Autowired
    BuscarVehiculoService buscarVehiculoService;

    @PostMapping("/buscar")
    public BuscarVehiculoResponseDTO buscarVehiculo (@RequestBody BuscarVehiculoRequestDTO buscarVehiculoRequestDTO) {

        try {

            // Se pausa la ejecución del hilo actual durante 60 segundos
            Thread.sleep(Duration.ofSeconds(60));

            // Se procede con la busqueda del vehiculo
            String[] datosVehiculo = buscarVehiculoService.buscarVehiculo(buscarVehiculoRequestDTO);

            // Si no se encontro al vehiculo
            if (datosVehiculo == null) {

                // Imprimimos un mensaje
                System.out.println("No se encontro ningún vehiculo con placa: " + buscarVehiculoRequestDTO.placa());

                // Retornamos el codigo 99 y un mensaje
                return new BuscarVehiculoResponseDTO(
                    "99",
                    "No se encontro al vehiculo con placa" + buscarVehiculoRequestDTO.placa(),
                    "",
                    "",
                    0,
                    0.0,
                    ""
                );

            }

            // Si el vehiculo fue encontrado

            // Imprimimos un mensaje
            System.out.println("Vehiculo encontrado: " + Arrays.toString(datosVehiculo));

            // Retornamos los datos del vehiculo
            return new BuscarVehiculoResponseDTO(
                "00",
                "",
                datosVehiculo[0],
                datosVehiculo[1],
                Integer.parseInt(datosVehiculo[2]),
                Double.parseDouble(datosVehiculo[3]),
                datosVehiculo[4]
            );

        } catch (Exception e) {

            // Si ocurrio una excepcion retornamos un mensaje de error
            return new BuscarVehiculoResponseDTO(
                "99",
                "Error: Ocurrió un error durante la busqueda del vehiculo",
                "",
                "",
                0,
                0.0,
                ""
            );

        }

    }

}
