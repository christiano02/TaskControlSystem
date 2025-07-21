package com.example.task_control_system.service;

import com.example.task_control_system.dto.UserDTO;
import com.example.task_control_system.entity.User;
import com.example.task_control_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Objects;

/**
 * Classe responsável por conter as regras de negócio relacionadas ao gerenciamento de usuários.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Encoder de senhas,  usado para criptografar senhas antes de salvar no banco.
    private PasswordEncoder passwordEncoder;

    /**
     * Busca um usuário pelo ID e retorna um DTO correspondente.
     * @param id Identificador único do usuário.
     * @return UserDTO com os dados do usuário.
     */
    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return new UserDTO(user);
    }

    /**
     * Cria um novo usuário com base nos dados fornecidos pelo DTO.
     * Caso o nome de usuário já exista, lança uma exceção.
     * @param dto Objeto com os dados do usuário.
     * @return Objeto User criado.
     */
    @Transactional // @Transactional (sem readOnly) para permitir escrita.
    public User createUser(UserDTO dto) {
        // Verifica se já existe um usuário com o mesmo username
        User userExisting = userRepository.findByUserName(dto.getUserName());
        if (Objects.nonNull(userExisting)) {
            throw new RuntimeException("Existing User");
        }

        // Criação e preenchimento do novo objeto User
        User userCreated = new User();
        userCreated.setId(dto.getId());
        userCreated.setName(dto.getName());
        userCreated.setEmail(dto.getEmail());
        userCreated.setUserName(dto.getUserName());
        userCreated.setPassword(passwordEncoder.encode(dto.getPassword())); // Ideal: codificar a senha usando passwordEncoder
        userCreated.setProfile(dto.getProfile());

        //salva um novo user no banco de dados
        userRepository.save(userCreated);
        // Retorna uma nova instância de User (não salva no banco!)
        return new User(userCreated.getId(), userCreated.getName(), userCreated.getEmail(), userCreated.getUserName(), userCreated.getPassword(), userCreated.getProfile());
    }

    /**
     * Atualiza os dados de um usuário existente com base no ID e DTO fornecidos.
     * Se o usuário não existir, retorna null.
     * @param id ID do usuário a ser atualizado.
     * @param dto Novos dados do usuário.
     * @return Objeto User atualizado ou null se não encontrado.
     */
    @Transactional
    public User updateUser(Long id, UserDTO dto) {
        User userUpdate = userRepository.findById(id).orElse(null);

        if (Objects.nonNull(userUpdate)) {
            userUpdate.setId(dto.getId());
            userUpdate.setName(dto.getName());
            userUpdate.setEmail(dto.getEmail());
            userUpdate.setUserName(dto.getUserName());
            userUpdate.setPassword(passwordEncoder.encode(dto.getPassword()));
            userUpdate.setProfile(dto.getProfile());

            return userRepository.save(userUpdate);
        }

        return null;
    }

    /**
     * Exclui um usuário com base no ID fornecido.
     * Lança exceção caso o usuário não exista.
     * @param id ID do usuário a ser deletado.
     */
    @Transactional  //permite a exclusão
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        } else {
            userRepository.deleteById(id);
        }
    }
}
