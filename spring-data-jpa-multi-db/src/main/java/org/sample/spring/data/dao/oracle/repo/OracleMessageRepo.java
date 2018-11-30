package org.sample.spring.data.dao.oracle.repo;

import org.sample.spring.data.dao.oracle.domain.TblOracle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OracleMessageRepo extends JpaRepository<TblOracle, Long> {
}
