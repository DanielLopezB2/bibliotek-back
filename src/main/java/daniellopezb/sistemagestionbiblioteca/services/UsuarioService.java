package daniellopezb.sistemagestionbiblioteca.services;
import daniellopezb.sistemagestionbiblioteca.entities.Usuario;

import java.util.List;
import java.util.UUID;

public interface UsuarioService {

    List<Usuario> getUsuarios();
    Usuario getUsuarioById(UUID id);
    Usuario createUsuario(Usuario usuario);
    Usuario updateUsuario(UUID id, Usuario libro);
    void deleteUsuario(UUID id);
}
