package com.opmc.api.servicio;

import com.opmc.api.modelo.OPMCMainCharacter;

import java.util.List;

public interface IOPMCApiService {
  List<OPMCMainCharacter> getAll();
  OPMCMainCharacter getByName(String name);
  OPMCMainCharacter create(OPMCMainCharacter newCharacter);
  OPMCMainCharacter update(OPMCMainCharacter newCharacter);

  OPMCMainCharacter delete(Integer id);
}
