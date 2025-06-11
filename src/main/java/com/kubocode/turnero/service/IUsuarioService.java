package com.kubocode.turnero.service;

import com.kubocode.turnero.model.Usuario;

public interface IUsuarioService {
    Usuario verificarUsuario(String username, String password);
}
