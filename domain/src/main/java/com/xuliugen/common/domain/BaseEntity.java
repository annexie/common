package com.xuliugen.common.domain;

import org.apache.commons.collections.CollectionUtils;

import java.util.*;

public class BaseEntity extends CommonEntity {

    /**
     * 实体Id
     */
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Set<Long> getIdSetBySelfCollection(Collection<? extends BaseEntity> baseEntityCollection) {
        Set<Long> idSet = new HashSet<Long>();
        if (CollectionUtils.isNotEmpty(baseEntityCollection)) {
            for (BaseEntity baseEntity : baseEntityCollection) {
                idSet.add(baseEntity.getId());
            }
        }
        return idSet;
    }

    public Map<Long, ? extends BaseEntity> getIdAndSelfMapBySelfCollection(Collection<? extends BaseEntity> baseEntityCollection) {
        Map<Long, BaseEntity> idAndSelfMap = new HashMap<Long, BaseEntity>();
        if (CollectionUtils.isNotEmpty(baseEntityCollection)) {
            for (BaseEntity baseEntity : baseEntityCollection) {
                idAndSelfMap.put(baseEntity.getId(), baseEntity);
            }
        }
        return idAndSelfMap;
    }

}
