package com.adminOfficialWeb.demo.service;

import com.adminOfficialWeb.demo.dto.UserDTO;
import com.adminOfficialWeb.demo.entity.User;
import com.adminOfficialWeb.demo.mapper.UserMapper;
import com.adminOfficialWeb.demo.repository.UserRepository;
import com.adminOfficialWeb.demo.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService<UserDTO,Long> {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private  UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDTO create(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO update(UserDTO dto) {
        User user = userMapper.toEntity(dto);
        User finalUser = user;
        User userFromDb = userRepository.findById(user.getId())
                .orElseThrow(() -> new EntityNotFoundException(finalUser.getId()+ " numaralı kullanıcı bulunamadı !"));
        user.setPassword(userFromDb.getPassword());
        user = userRepository.save(user);
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO findById(Long aLong) {
        return null;
    }

    @Override
    public List<UserDTO> getByActive() {
        List<User> users = userRepository.findByActive(true)
                .orElseThrow(()->new EntityNotFoundException("Kullanıcı bulunamadı."));
        return userMapper.toDTOList(users);
    }

    @Override
    public boolean deleteById(Long aLong) {
        User user = userRepository.findByIdAndActive(aLong,true)
                .orElseThrow(()-> new EntityNotFoundException("User not found"));
        user.setActive(false);
        return true;
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        return userMapper.toDTOList(users);
    }
}
