package com.qwantu.api.repositories;


import com.qwantu.api.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;


@RepositoryRestResource
public interface UsersRepository extends JpaRepository<Users, Long> {}