package pers.ljf.spring.debug.tx.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: ljf
 * @date: 2021/4/13 14:29
 * @description:
 * @modified By：
 * @version: $ 1.0
 */
@Service
public class BookService {
	@Autowired
	private BookDao bookDao;

	/**
	 * 那个顾客买了那本书
	 *
	 * @param username：顾客姓名
	 * @param id：书本id
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void checkout(String username, int id) {
		//更新库存
		try {
			bookDao.updateStock(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//更新用户余额
		int price = bookDao.getPrice(id);
		bookDao.updateBalance(username, price);
	}
}
