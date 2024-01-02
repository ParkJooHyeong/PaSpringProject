package com.platform_analysis.pa.repository;
import com.platform_analysis.pa.model.UserDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<UserDataEntity, Long> {
    List<UserDataEntity> findByUsername(String username);
}

