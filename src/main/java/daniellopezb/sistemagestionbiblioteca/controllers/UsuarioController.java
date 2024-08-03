package daniellopezb.sistemagestionbiblioteca.controllers;

import daniellopezb.sistemagestionbiblioteca.dto.DeleteResponse;
import daniellopezb.sistemagestionbiblioteca.dto.LibroResponse;
import daniellopezb.sistemagestionbiblioteca.dto.UsuarioResponse;
import daniellopezb.sistemagestionbiblioteca.entities.Libro;
import daniellopezb.sistemagestionbiblioteca.entities.Usuario;
import daniellopezb.sistemagestionbiblioteca.services.LibroService;
import daniellopezb.sistemagestionbiblioteca.services.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/usuarios")
@CrossOrigin("http://localhost:4200")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<UsuarioResponse> getUsuarios() {
        List<Usuario> usuarios = usuarioService.getUsuarios();
        return usuarios.stream().map(usuario -> new UsuarioResponse(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail()
        )). collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public UsuarioResponse getUsuarioById(@PathVariable("id") UUID id) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        return new UsuarioResponse(usuario.getId(), usuario.getNombre(), usuario.getEmail());
    }

    @PostMapping
    public UsuarioResponse createUsuario(@RequestBody Usuario usuario) {
        Usuario createdUsuario = usuarioService.createUsuario(usuario);
        return new UsuarioResponse(createdUsuario.getId(), createdUsuario.getNombre(), createdUsuario.getEmail());
    }

    @PutMapping("{id}")
    public UsuarioResponse updateUsuario(@PathVariable("id") UUID id, @RequestBody Usuario usuario) {
        Usuario updatedUsuario = usuarioService.updateUsuario(id, usuario);
        return new UsuarioResponse(updatedUsuario.getId(), updatedUsuario.getNombre(), updatedUsuario.getEmail());
    }

    @DeleteMapping("{id}")
    public DeleteResponse deleteUsuario(@PathVariable("id") UUID id) {
        usuarioService.deleteUsuario(id);
        return new DeleteResponse("Usuario eliminado correctamente");
    }
}
