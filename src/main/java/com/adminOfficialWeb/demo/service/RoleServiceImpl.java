package com.adminOfficialWeb.demo.service;

import com.adminOfficialWeb.demo.dto.RoleDTO;
import com.adminOfficialWeb.demo.entity.Role;
import com.adminOfficialWeb.demo.mapper.RoleMapper;
import com.adminOfficialWeb.demo.repository.RoleRepository;
import com.adminOfficialWeb.demo.service.base.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService<RoleDTO, Long> {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleDTO create(RoleDTO dto) {
        Role role = roleMapper.toEntity(dto);
        role = roleRepository.save(role);
        return roleMapper.toDTO(role);
    }

    @Override
    public RoleDTO update(RoleDTO dto) {
        Role role = roleMapper.toEntity(dto);
        role = roleRepository.save(role);
        return roleMapper.toDTO(role);
    }

    @Override
    public RoleDTO findById(Long id) {
        return roleMapper.toDTO(roleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + " numaralı rol bulunamadı !")));
    }

    @Override
    public List<RoleDTO> getByActive() {
        List<Role> users = roleRepository.findByActive(true)
                .orElseThrow(()->new EntityNotFoundException("Rol Bulunamadı."));
        return roleMapper.toDTOList(users);
    }

    @Override
    public boolean deleteById(Long id) {
        roleRepository.deleteById(id);
        return true;
    }

    @Override
    public List<RoleDTO> findAll() {
        return roleMapper.toDTOList(roleRepository.findAll(Sort.by(Sort.Direction.DESC, "updatedAt")));
    }
}
