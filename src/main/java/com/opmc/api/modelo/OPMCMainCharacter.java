package com.opmc.api.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OPMCMainCharacter {
    private Integer id;
    private String nombre;
    private String estatura;
    private Integer edad;
    private Long recompensa;
    private String trabajo;
    private String frutaDelDiablo;

}
