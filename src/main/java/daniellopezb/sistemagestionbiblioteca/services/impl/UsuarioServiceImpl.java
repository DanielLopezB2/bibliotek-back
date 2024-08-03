package daniellopezb.sistemagestionbiblioteca.services.impl;

import daniellopezb.sistemagestionbiblioteca.entities.Usuario;
import daniellopezb.sistemagestionbiblioteca.repositories.LibroRepository;
import daniellopezb.sistemagestionbiblioteca.repositories.UsuarioRepository;
import daniellopezb.sistemagestionbiblioteca.services.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuarioById(UUID id) {
        return usuarioRepository.findById(id).orElseThrow();
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario updateUsuario(UUID id, Usuario usuario) {
        Usuario oldUsuario = this.getUsuarioById(id);
        oldUsuario.setEmail(usuario.getEmail());
        oldUsuario.setNombre(usuario.getNombre());
        return usuarioRepository.save(oldUsuario);
    }

    @Override
    public void deleteUsuario(UUID id) {
        if (usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return;
        }
        throw new RuntimeException();
    }
}
