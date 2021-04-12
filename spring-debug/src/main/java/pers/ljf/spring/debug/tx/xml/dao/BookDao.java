package pers.ljf.spring.debug.tx.xml.dao;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author: ljf
 * @date: 2021/4/11 14:50
 * @description:
 * @modified By:
 * @version: $ 1.0
 */
public class BookDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 根据图书的价格更新用户的余额
	 *
	 * @param username：用户名称
	 * @param price：书本价格
	 */
	public void updateBalance(String username, float price) {
		String sql = "update account set balance=balance-? where username=?";

		this.jdbcTemplate.update(sql, price, username);
	}

	public float getPrice(int id) {
		String sql = "select price from book where id=?";
		return this.jdbcTemplate.queryForObject(sql, Float.class, id);
	}

	public void updateStock(int id) {
		String sql = "update book_stock set stock=stock-1 where id=?";
		this.jdbcTemplate.update(sql, id);

		//内部方法抛异常
		for (int i = 1; i >= 0; i--) {
			int j = 3 / i;
		}

	}
}
