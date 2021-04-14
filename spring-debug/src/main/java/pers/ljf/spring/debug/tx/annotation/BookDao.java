package pers.ljf.spring.debug.tx.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: ljf
 * @date: 2021/4/13 14:30
 * @description:
 * @modified By：
 * @version: $ 1.0
 */
public class BookDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void updateStock(int id) {
		String sql = "update book_stock set stock=stock-1 where id=?";
		jdbcTemplate.update(sql, id);

		for (int i = 2; i >= 0; i--) {
			int j = 2 / i;
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public int getPrice(int id) {
		String sql = "select price from book where id=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void updateBalance(String username, int price) {
		String sql = "update account set balance=balance-? where username=?";
		jdbcTemplate.update(sql, price, username);
	}
}
