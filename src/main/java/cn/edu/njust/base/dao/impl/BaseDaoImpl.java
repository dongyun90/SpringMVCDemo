package cn.edu.njust.base.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import cn.edu.njust.base.dao.BaseDao;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;


public class BaseDaoImpl extends SqlSessionDaoSupport implements BaseDao {
    @Resource
    private SqlSessionFactory sqlSessionFactory;

    @PostConstruct
    public void initSqlMapClient() {
        setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public <T> T selectOne(String statement) throws Exception {
        return getSqlSession().selectOne(statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) throws Exception {
        return getSqlSession().selectOne(statement, parameter);
    }

    @Override
    public <K, V> Map<K, V> selectMap(String statement, String mapKey) throws Exception {
        return getSqlSession().selectMap(statement, mapKey);
    }

    @Override
    public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey) throws Exception {
        return getSqlSession().selectMap(statement, parameter, mapKey);
    }

    @Override
    public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey, RowBounds rowBounds) throws Exception {
        return getSqlSession().selectMap(statement, parameter, mapKey, rowBounds);
    }

    @Override
    public <E> List<E> selectList(String statement, Object parameter) throws Exception {
        return getSqlSession().selectList(statement, parameter);
    }

    @Override
    public <E> List<E> selectList(String statement) throws Exception {
        return getSqlSession().selectList(statement);
    }

    @Override
    public <E> List<E> selectList(String statement, Object parameter, RowBounds rowBounds) throws Exception {
        return getSqlSession().selectList(statement, parameter, rowBounds);
    }

    @Override
    public int update(String statement) throws Exception {
        return getSqlSession().update(statement);
    }

    @Override
    public int update(String statement, Object parameter) throws Exception {
        return getSqlSession().update(statement, parameter);
    }

    @Deprecated
    @Override
    public int delete(String statement) throws Exception {
        return 0;
    }

    @Deprecated
    @Override
    public int delete(String statement, Object parameter) throws Exception {
        return 0;
    }

    @Override
    public int insert(String statement) throws Exception {
        return getSqlSession().insert(statement);
    }

    @Override
    public int insert(String statement, Object parameter) throws Exception {
        return getSqlSession().insert(statement, parameter);
    }
}
