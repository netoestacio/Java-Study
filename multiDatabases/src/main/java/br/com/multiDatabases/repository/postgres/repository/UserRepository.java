package br.com.multiDatabases.repository.postgres.repository;

import br.com.multiDatabases.repository.postgres.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
