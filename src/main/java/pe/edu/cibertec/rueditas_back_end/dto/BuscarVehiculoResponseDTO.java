package pe.edu.cibertec.rueditas_back_end.dto;

public record BuscarVehiculoResponseDTO(String codigo, String mensaje, String marca, String modelo, Integer nroAsientos, Double precio, String color) {
}
