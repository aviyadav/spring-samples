package org.sample.spring.data.dao.mysql.repo;

import org.sample.spring.data.dao.mysql.domain.TblMysql;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MysqlMessageRepo extends JpaRepository<TblMysql, Long> {
}
