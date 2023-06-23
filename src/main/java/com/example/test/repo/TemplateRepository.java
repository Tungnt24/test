package com.example.test.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.test.entity.TemplateMailEntity;

@Repository
public interface TemplateRepository extends JpaRepository<TemplateMailEntity, Long> {

    Optional<TemplateMailEntity> findByCode(String code);
}
