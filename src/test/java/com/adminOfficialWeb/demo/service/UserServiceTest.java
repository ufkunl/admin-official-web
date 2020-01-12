package com.adminOfficialWeb.demo.service;

import com.adminOfficialWeb.demo.dto.UserDTO;
import com.adminOfficialWeb.demo.entity.User;
import com.adminOfficialWeb.demo.mapper.UserMapper;
import com.adminOfficialWeb.demo.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    public void createUserTest(){
//        when(userMapper.toDTO(createMockUser().get())).thenReturn(createMockUserDTO().get());
//        when(userMapper.toEntity(createMockUserDTO().get())).thenReturn(createMockUser().get());
//        when(userRepository.save(createMockUser().get())).thenReturn(createMockUser().get());
//        Assert.assertEquals(userService.createUser(createMockUserDTO().get()),userMapper.toDTO(createMockUser().get()));
//    }

    @Test
    public void getUsersByAll() {
        when(userRepository.findAll()).thenReturn(createMockUserList().get());
        when(userMapper.toDTOList(createMockUserList().get())).thenReturn(createMockUseDTOList().get());
        Assert.assertEquals(userService.findAll(),createMockUseDTOList().get());
    }

    @Test
    public void deleteUser() {
        when(userRepository.findByIdAndActive(4L,true)).thenReturn(createMockUser());
        Assert.assertTrue(userService.deleteById(4L));
    }

        @Test
        public void getUsersByActive() {
            when(userRepository.findByActive(true)).thenReturn(Optional.of(createMockUserList().get()));
            when(userMapper.toDTOList(createMockUserList().get())).thenReturn(createMockUseDTOList().get());
            Assert.assertEquals(userService.getByActive(),userMapper.toDTOList(createMockUserList().get()));
            Assert.assertTrue(userService.getByActive().get(0).isActive());
        }

        private Optional<User> createMockUser(){
            User user = new User();
            user.setName("ufuk");
            user.setSurname("ünal");
            user.setEmail("ufuk@unal");
            user.setPassword("1234");
            user.setUserKey("fefefe");
            user.setCvContent("cdfdsfd");
            user.setCvUrl("fkdkfds");
        user.setActive(true);
        return Optional.of(user);
    }

    private Optional<UserDTO> createMockUserDTO(){
        UserDTO userDTO = new UserDTO();
        userDTO.setName("ufuk");
        userDTO.setSurname("ünal");
        userDTO.setEmail("ufuk@unal");
        userDTO.setPassword("1234");
        userDTO.setUserKey("fefefe");
        userDTO.setCvContent("cdfdsfd");
        userDTO.setCvUrl("fkdkfds");
        userDTO.setActive(true);
        return Optional.of(userDTO);
    }


    private Optional<List<User>> createMockUserList(){
        User user = createMockUser().get();
        List<User> users = Collections.singletonList(user);
        return Optional.of(users);
    }

    private Optional<List<UserDTO>> createMockUseDTOList(){
        UserDTO user = createMockUserDTO().get();
        List<UserDTO> userDTOS = Collections.singletonList(user);
        return Optional.of(userDTOS);
    }
}
