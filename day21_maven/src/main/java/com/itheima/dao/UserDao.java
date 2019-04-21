package com.itheima.dao;

import com.itheima.domain.User;
import com.itheima.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * UserDao
 *
 * @author Huang
 * @date 2019/2/25 19:41
 */
public class UserDao {
    JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<User> findAll() {
        String sql = "SELECT * FROM user";
        return jt.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }

    public int add(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?)";
        return jt.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
    }
}
