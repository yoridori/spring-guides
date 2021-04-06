package com.example.springguides;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.springguides.relationaldataaccess.Customer;

@EnableAutoConfiguration
public class RelationalDataAccessApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(RelationalDataAccessApplication.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RelationalDataAccessApplication.class, args);
    }
    
    @Override
    public void run(String... strings) throws Exception {

        log.info("Creating tables");

        // テーブル作成
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE customers(" + "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");
        
        // 半角空白区切りの姓名を定義し、配列入りリストを作成してレコード追加の準備
        List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long")
                .stream()
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        // 名前を1行ずつ表示
        splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));

        // #JdbcTemplate#batchUpdateでリスト内容を使用して繰り返し処理する。
        // (配列の挿入順とプリペアドステートメントの位置に気をつける)
        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES(?,?)", splitUpNames);

        log.info("Querying for customer records where first_name = 'Josh':");
        CustomerRowMapper rowMapper = new CustomerRowMapper();
        jdbcTemplate.query("SELECT id, first_name, last_name FROM customers WHERE first_name = ?", rowMapper, "Josh")
                .forEach(customer -> log.info(customer.toString()));
    }

    public class CustomerRowMapper implements RowMapper<Customer> {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"));

            return customer;
        }
    }
}
