package com.developermobile.demo_park_api.web.dto.mapper;

import com.developermobile.demo_park_api.entity.Usuario;
import com.developermobile.demo_park_api.web.dto.UsuarioCreateDTO;
import com.developermobile.demo_park_api.web.dto.UsuarioResponseDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UsuarioMapper {

    public static Usuario toUsuario(UsuarioCreateDTO dto) {
        return new ModelMapper().map(dto, Usuario.class);
    }

    public static UsuarioResponseDTO toDTO(Usuario usuario) {
        String role = usuario.getRole().name().substring("ROLE_".length());
        ModelMapper mapperMain = new ModelMapper();
        TypeMap<Usuario, UsuarioResponseDTO> propertyMapper = mapperMain.createTypeMap(Usuario.class, UsuarioResponseDTO.class);
        propertyMapper.addMappings(
                mapper -> mapper.map((src) -> role, UsuarioResponseDTO::setRole)
        );
        return mapperMain.map(usuario, UsuarioResponseDTO.class);
    }

    public static List<UsuarioResponseDTO> toListDTO(List<Usuario> usuarios) {
        return usuarios.stream().map(UsuarioMapper::toDTO).collect(Collectors.toList());
    }
}
