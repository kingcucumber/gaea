package com.gaea.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Pageable {
	private int pageSize;
	private int totalRows;
	private int totalPages;
	private static int currentPage;
	private int rowsCount;

	public Pageable(ResultSet rs) {
		try {
			rs.last();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			this.setTotalRows(rs.getRow());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			rs.beforeFirst();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize >= 0) {
			this.pageSize = pageSize;
		} else {
			this.pageSize = 1;
		}
		this.setTotalPages();
	}

	public void gotoPage(int page) {
		switch (page) {
		case -1:
			this.setCurrentPage(1);
			break;
		case -2:
			int t = this.getCurrentPage();
			this.setCurrentPage(t + 1);
			break;
		case -3:
			int n = this.getCurrentPage();
			this.setCurrentPage(n + 1);
			break;
		case -4:
			this.setCurrentPage(this.getTotalPages());
			break;
		default:
			this.setCurrentPage(page);
		}
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages() {
		if (this.getTotalPages() == 0) {
			this.totalPages = 0;
		} else if (this.getPageSize() == 0) {
			this.totalPages = 1;
		} else {
			if (this.getTotalRows() % this.getPageSize() != 0)
				this.totalPages = this.getTotalRows() / this.getPageSize() + 1;
			else
				this.totalPages = this.getTotalRows() / this.getPageSize();
		}
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		if (currentPage <= 0) {
			this.currentPage = 1;
		}
		if (currentPage > this.getTotalPages()) {
			this.currentPage = this.getTotalPages();
		} else {
			this.currentPage = currentPage;
			this.setRowsCount((this.currentPage - 1) * this.getPageSize() + 1);
			System.out.println(this.getRowsCount());
		}
	}

	public int getRowsCount() {
		return rowsCount;
	}

	public void setRowsCount(int rowsCount) {
		this.rowsCount = rowsCount;
	}

	public void pageFirst() throws java.sql.SQLException {
		this.setRowsCount((this.getCurrentPage() - 1) * this.getPageSize() + 1);
	}

	public void pageLast() throws java.sql.SQLException {
		this.setRowsCount((this.getCurrentPage() - 1) * this.getPageSize()
				+ this.getCurrentPageRowsCount());
	}

	public int getCurrentPageRowsCount() {
		if (this.getPageSize() == 0) {
			return this.getTotalRows();
		}
		if (this.getTotalRows() == 0) {
			return 0;
		}
		if (this.getCurrentPage() != this.getTotalPages()) {
			return this.getPageSize();
		}
		return this.getTotalRows() - (this.getTotalPages() - 1)
				* this.getPageSize();
	}
}
