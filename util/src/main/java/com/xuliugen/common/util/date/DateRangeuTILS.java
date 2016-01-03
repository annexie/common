package com.xuliugen.common.util.date;

import com.xuliugen.common.util.AssertUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.time.DateUtils;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

/**
 * 日期范围类。包括左右边界值。忽略时间部分。
 */
public class DateRangeUtils implements Serializable {

    private static final long serialVersionUID = -2800351591055572549L;

    private Date from;

    private Date to;

    /**
     * @param from 起始日期
     * @param to   结束日期
     */
    public DateRangeUtils(Date from, Date to) {
        AssertUtils.notNull(from, "From date is null!");
        AssertUtils.notNull(to, "To date is null!");
        this.from = new Date(from.getTime());
        this.to = new Date(to.getTime());
    }

    public Date getFrom() {
        return new Date(from.getTime());
    }

    public Date getTo() {
        return new Date(to.getTime());
    }

    public boolean contains(Date date) {
        return (date.after(from) || DateUtils.isSameDay(date, from))
                && (date.before(to) || DateUtils.isSameDay(date, to));
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DateRangeUtils)) {
            return false;
        }
        DateRangeUtils that = (DateRangeUtils) other;
        return DateUtils.isSameDay(this.from, that.from) && DateUtils.isSameDay(this.to, that.to);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(from).append(to).toHashCode();
    }

    @Override
    public String toString() {
        return "[" + DateFormat.getDateInstance().format(from)
                + " - "
                + DateFormat.getDateInstance().format(to) + "]";
    }
}
