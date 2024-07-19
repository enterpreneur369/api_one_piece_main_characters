package com.opmc.api.controlador;

import com.opmc.api.modelo.OPMCMainCharacter;
import com.opmc.api.servicio.IOPMCApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/opmc/api")
public class OPMCApi {
    private final IOPMCApiService service;
  @GetMapping
  public List<OPMCMainCharacter> obtenerTodosLosPersonajes() {
    return service.getAll();
  }

  @GetMapping("/{name}")
  public OPMCMainCharacter obtenerPorNombre(@PathVariable("name") String name) {
    return service.getByName(name);
  }

  @PostMapping("/create")
  public OPMCMainCharacter crear(@RequestBody OPMCMainCharacter newCharacter) {
    return service.create(newCharacter);
  }

  @PutMapping("/update")
  public OPMCMainCharacter actualizar(@RequestBody OPMCMainCharacter characterToUpdate) {
    return service.update(characterToUpdate);
  }

  @DeleteMapping("/delete/{id}")
  public OPMCMainCharacter borrar(@PathVariable("id") Integer id) {
    return service.delete(id);
  }
}
