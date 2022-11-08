package com.example.WorkOut.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.WorkOut.model.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(String name);
}
