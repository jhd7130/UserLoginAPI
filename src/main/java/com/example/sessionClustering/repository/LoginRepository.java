package com.example.sessionClustering.repository;


import com.example.sessionClustering.entity.LoginEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends CrudRepository<LoginEntity,Long> {

}
