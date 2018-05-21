package cn.edu.njust.base.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

public interface BaseDao {
	public <T> T selectOne(String statement) throws Exception;

	public <T> T selectOne(String statement, Object parameter) throws Exception;

	public <K, V> Map<K, V> selectMap(String statement, String mapKey) throws Exception;

	public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey) throws Exception;

	public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey, RowBounds rowBounds) throws Exception;

	public <E> List<E> selectList(String statement, Object parameter) throws Exception;

	public <E> List<E> selectList(String statement) throws Exception;

	public <E> List<E> selectList(String statement, Object parameter, RowBounds rowBounds) throws Exception;

	public int update(String statement) throws Exception;

	public int update(String statement, Object parameter) throws Exception;

	public int delete(String statement) throws Exception;

	public int delete(String statement, Object parameter) throws Exception;

	public int insert(String statement) throws Exception;

	public int insert(String statement, Object parameter) throws Exception;
}
