package org.mars;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;



public final class SpringDb {
	public static final void run() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        //dataSource.setDriverClass(org.h2.Driver.class);
        dataSource.setUsername("sa");
        dataSource.setUrl("jdbc:h2:mem");
        dataSource.setPassword("");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

//        System.out.println("Creating tables");
//        jdbcTemplate.execute("drop table customers if exists");
//        jdbcTemplate.execute("create table customers(" +
//                "id serial, first_name varchar(255), last_name varchar(255))");
//
//        String[] names = "John Woo;Jeff Dean;Josh Bloch;Josh Long".split(";");
//        for (String fullname : names) {
//            String[] name = fullname.split(" ");
//            System.out.printf("Inserting customer record for %s %s\n", name[0], name[1]);
//            jdbcTemplate.update(
//                    "INSERT INTO customers(first_name,last_name) values(?,?)",
//                    name[0], name[1]);
//        }

        System.out.println("Querying for r_users records");
        List<User> results = jdbcTemplate.query(
                "select * from r_users where u_id = ?", new Object[] { 1 },
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new User(rs.getInt("u_id"), rs.getString("u_name"),
                                rs.getString("password"));
                    }
                });

        for (User u : results) {
            System.out.println(u);
        }
	}
}
