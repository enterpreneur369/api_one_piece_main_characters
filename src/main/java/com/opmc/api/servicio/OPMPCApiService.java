package com.opmc.api.servicio;

import com.opmc.api.modelo.OPMCMainCharacter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class OPMPCApiService implements IOPMCApiService{

  private List<OPMCMainCharacter> personajesPrincipales = new ArrayList<OPMCMainCharacter>() {{
    add(new OPMCMainCharacter(1, "Monkey D Luffy", "174cm", 19, 3000000000L, "Capitán", "Fruta Goma-Goma modelo Nika"));
    add(new OPMCMainCharacter(2, "Nami", "174cm", 20, 366000000L, "Navegante", "Ninguna"));
    add(new OPMCMainCharacter(3, "Roronoa Zoro", "181cm", 21, 1111000000L, "Mano derecha", "Ninguna"));
    add(new OPMCMainCharacter(4, "Sanji", "180cm", 21, 1032000000L, "Cocinero", "Ninguna"));
    add(new OPMCMainCharacter(5, "Jinbei", "301cm", 46, 1100000000L, "Timonel", "Ninguna"));
    add(new OPMCMainCharacter(6, "Franky", "240cm", 36, 394000000L, "Carpintero", "Ninguna"));
    add(new OPMCMainCharacter(7, "Brook", "277cm", 90, 383000000L, "Músico", "Fruta Revivir-Revivir"));
    add(new OPMCMainCharacter(8, "Nico Robin", "188cm", 30, 930000000L, "Arqueologa", "Fruta Flor-Flor"));
    add(new OPMCMainCharacter(9, "Tony-Tony Chopper", "90cm", 17, 1000L, "Médico", "Fruta Humano-Humano"));
    add(new OPMCMainCharacter(10, "Usopp", "176cm", 19, 500000000L, "Tirador", "Ninguna"));
  }};

  @Override
  public List<OPMCMainCharacter> getAll() {
    return personajesPrincipales;
  }

  @Override
  public OPMCMainCharacter getByName(String name) {
    return personajesPrincipales.stream()
      .filter(c -> c.getNombre().toLowerCase().contains(name.toLowerCase()))
      .findFirst()
      .orElse(new OPMCMainCharacter());
  }


  @Override
  public OPMCMainCharacter create(OPMCMainCharacter newCharacter) {
    int nuevoIndice = personajesPrincipales.size() + 1;
    newCharacter.setId(nuevoIndice);
    personajesPrincipales.add(newCharacter);
    return newCharacter;
  }

  @Override
  public OPMCMainCharacter update(OPMCMainCharacter characterToUpdate) {
    for (int i = 0; i < personajesPrincipales.size(); i++) {
      OPMCMainCharacter persona = personajesPrincipales.get(i);
      if (persona.getId() == characterToUpdate.getId()) {
        persona.setEdad(characterToUpdate.getEdad());
        persona.setEstatura(characterToUpdate.getEstatura());
        persona.setNombre(characterToUpdate.getNombre());
        persona.setRecompensa(characterToUpdate.getRecompensa());
        persona.setTrabajo(characterToUpdate.getTrabajo());
        persona.setFrutaDelDiablo(characterToUpdate.getFrutaDelDiablo());
        return persona;
      }
    }
    return new OPMCMainCharacter();
  }

  @Override
  public OPMCMainCharacter delete(Integer id) {
    OPMCMainCharacter characterToDelete = personajesPrincipales.stream()
      .filter(c -> c.getId() == id)
      .findFirst()
      .orElse(null);
    if (characterToDelete == null) {
      return new OPMCMainCharacter();
    } else {
      personajesPrincipales.remove(characterToDelete);
      return characterToDelete;
    }
  }
}
