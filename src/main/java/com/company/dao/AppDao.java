package com.company.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.company.vo.AppVo;

@Component
public class AppDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public AppDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<AppVo> listAll() {

		String sql = "SELECT * FROM WISHLIST";

		return jdbcTemplate.query(sql, new ResultSetExtractor<List<AppVo>>() {
			public List<AppVo> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<AppVo> listOfGenericResult = new ArrayList<AppVo>();
				while (rs.next()) {
					AppVo genericResult = new AppVo();
					genericResult.setResult1(rs.getString("ID"));
					genericResult.setResult2(rs.getString("NAME"));
					listOfGenericResult.add(genericResult);
				}
				return listOfGenericResult;
			}
		});
	}

	public boolean save(String wish) {
		String insert = "INSERT INTO WISHLIST (NAME) VALUES (?)";
		jdbcTemplate.update(insert, new Object[] { wish });
		return true;
	}
}