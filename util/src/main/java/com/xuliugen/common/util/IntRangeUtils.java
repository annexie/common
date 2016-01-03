package com.xuliugen.common.util;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * 整数范围类。包括左右边界值。
 */
public class IntRangeUtils implements Serializable {

    private static final long serialVersionUID = 8864945948923971061L;

    private int min;

    private int max;

    /**
     * @param min 下限
     * @param max 上限
     */
    public IntRangeUtils(int min, int max) {
        super();
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public boolean contains(int number) {
        return number >= min && number <= max;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(min).append(max).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IntRangeUtils)) {
            return false;
        }
        IntRangeUtils that = (IntRangeUtils) other;
        return new EqualsBuilder().append(this.getMin(), that.getMin())
                .append(this.getMax(), that.getMax())
                .isEquals();
    }

    @Override
    public String toString() {
        return "[" + min + " - " + max + "]";
    }

}
