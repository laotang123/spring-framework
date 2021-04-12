package pers.ljf.spring.debug.tx.xml.service;

import pers.ljf.spring.debug.tx.xml.dao.BookDao;

/**
 * @author: ljf
 * @date: 2021/4/11 15:00
 * @description:
 * @modified By:
 * @version: $ 1.0
 */
public class BookService {

	private BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public BookDao getBookDao() {
		return this.bookDao;
	}

	/**
	 * 结账服务：传入的用户名称和书本id更新库存和用户余额
	 *
	 * @param username：用户名称
	 * @param id：书本id
	 */
	public void checkout(String username, int id) {
		//更新库存
		bookDao.updateStock(id);

		//更新用户余额
		float price = bookDao.getPrice(id);
		bookDao.updateBalance(username, price);
	}
}
