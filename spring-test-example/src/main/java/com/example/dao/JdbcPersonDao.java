package com.example.dao;

import com.example.model.Person;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcPersonDao implements PersonDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Person findById(Long id) {
        return jdbcTemplate.queryForObject("select first_name, last_name from t_person where id = ?", new RowMapper<Person>() {

            @Override
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                Person person = new Person();
                person.setId(id);
                person.setFirstName(rs.getString("first_name"));
                person.setLastName(rs.getString("last_name"));
                return person;
            }
        }, id);
    }

    @Override
    public void create(Person person) {
        jdbcTemplate.update("insert into t_person(id,first_name,last_name) values(t_person_sequence.nextval,?,?)", person.getFirstName(), person.getLastName());
    }

    @Override
    public void update(Person person) {
        jdbcTemplate.update("update t_person set first_name = ?, last_name = ? where id = ?", person.getFirstName(), person.getLastName(), person.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("delete from t_person where id = ?", id);
    }

}
