package com.example.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import com.example.test.entity.UserEntity;
import lombok.NonNull;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

    @Modifying
    void deleteById(@NonNull Long id);

}
