package com.xuliugen.common.domain;

import com.xuliugen.common.repository.IEntityRepositoryMybatis;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * 使用Mybatis来实现仓储的实体基类
 * Created by Albert.Liu on 15/10/1.
 */
@Named
public class EntityInMybatis extends Entity {

    @Inject
    private IEntityRepositoryMybatis entityRepositoryMybatis;

}
