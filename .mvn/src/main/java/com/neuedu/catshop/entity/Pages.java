package com.neuedu.catshop.entity;

import java.util.List;

/**
 * 
 * @author netboy
 *
 * @param <T> 搜索条件使用泛型进行定义，类或方法调用是需要传递具体的类型
 */
public class Pages<T> {

	// 页码,当前页
	private Integer page = 1;
	// 分页大小
	private Integer size = 5;

	// 查询搜索条件,使用了泛型编程
	private T condition;

	// 在分页类中返回总记录数,easyui获取数据使用total作为key,这里必须叫total
	private Integer total = 0;

	// 在分页类中返回数据集合 ，easyui获取数据使用rows作为key,这里必须叫rows
	private List<T> rows;

	public Pages() {
		super();
	}

	public Pages(Integer page, Integer size) {
		super();
		setPage(page);
		setSize(size);
	}

	public Pages(T condition) {
		super();
		this.condition = condition;
	}

	public Pages(Integer total) {
		super();
		setTotal(total);
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		// 页码不能小于1
		if (page != null && page >= 1) {
			this.page = page;
		}
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		// 分页大小必须大于等于5
		if (size != null && size >= 5) {
			this.size = size;
		}
	}

	public T getCondition() {
		return condition;
	}

	public void setCondition(T condition) {
		this.condition = condition;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		// 总记录数不能小于0
		if (total != null && total >= 0) {
			this.total = total;
		}
	}

	// 获取总页数
	public Integer getPages() {
		int pages = 0;
		if (size >= 0) {
			// 计算总页数：需要判断能否分层整页，不能分成整页需要加多1页
			pages = total % size == 0 ? total / size : total / size + 1;
		}
		return pages;
	}

	// 计算上一页是第几页
	public Integer getPrePage() {
		if (page > 0) {
			int prepage = page - 1 <= 0 ? 1 : page - 1;
			return prepage;
		}
		// 上一页为0时，表示没有任何数据
		return 0;
	}

	// 计算下一页是第几页
	public Integer getNextPage() {
		int pages = getPages();
		if (pages > 0) {
			int nextpage = page + 1 <= pages ? page + 1 : pages;
			return nextpage;
		}
		// 当没有数据时，下一页就是0页
		return 0;
	}

	// 计算分页查询参数-从数据库的第几行数据开始查询
	public Integer getStart() {
		if (page >= 1) {
			return (page - 1) * size;
		}
		// 没有分页查询或没有数据,返回0
		return 0;
	}

	// 计算分页查询参数-查询到数据库的第几行数据
	public Integer getEnd() {
		if (page >= 1) {
			return page * size;
		}
		// 没有分页查询或没有数据,返回0
		return 0;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}
