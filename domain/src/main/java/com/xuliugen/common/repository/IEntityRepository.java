package com.xuliugen.common.repository;

import com.xuliugen.common.domain.Entity;

public interface IEntityRepository {

    int deleteByPrimaryKey(Long id);

    <T extends Entity> int insert(T entity);

    <T extends Entity> int insertSelective(T entity);

    <T extends Entity> T selectByPrimaryKey(Long id);

    <T extends Entity> int updateByPrimaryKeySelective(T entity);

    <T extends Entity> int updateByPrimaryKey(T entity);
}
