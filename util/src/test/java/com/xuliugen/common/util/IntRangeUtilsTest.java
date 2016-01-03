package com.xuliugen.common.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntRangeUtilsTest {

    private IntRangeUtils range;

    @Before
    public void setUp() throws Exception {
        range = new IntRangeUtils(1, 10);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testContains() {
        assertTrue(range.contains(7));
        assertTrue(range.contains(1));
        assertTrue(range.contains(10));
        assertFalse(range.contains(0));
        assertFalse(range.contains(-1));
        assertFalse(range.contains(11));
    }

    @Test
    public void testEqualsObject() {
        IntRangeUtils range1 = new IntRangeUtils(1, 10);
        assertEquals(range1, range);
        range1 = new IntRangeUtils(1, 11);
        assertFalse(range1.equals(range));
        range1 = new IntRangeUtils(2, 10);
        assertFalse(range1.equals(range));
    }

    @Test
    public void testToString() {
        assertEquals("[1 - 10]", range.toString());
    }

}
