package com.xc.jetty;

import com.xc.jetty.regex.DomainUtils;
import edu.emory.mathcs.backport.java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2015/7/20.
 */
@RunWith(value = Parameterized.class)
public class JunitTest7 {
    private String domain;
    private boolean expected;

    public JunitTest7(String domain, boolean expected) {
        this.domain = domain;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}:isValid({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"google.com", true},
                {"mkyong.com", true},
                {"-mkyong.com", false},
                {"mkyong-.com", false},
                {"3423kjk", false},
                {"mk#$kdo.com", false}
        });
    }

    @Test
    public void test_validDomains() {
        assertEquals(expected, DomainUtils.isValidDomainName(domain));
    }
}
