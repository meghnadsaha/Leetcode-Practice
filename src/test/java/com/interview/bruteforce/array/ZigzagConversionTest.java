package com.interview.bruteforce.array;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class ZigzagConversionTest  {

    ZigzagConversion zigzagConversion = new ZigzagConversion();

    @Test
    public void testConvert(){
        String output = zigzagConversion.convert("PAYPALISHIRING",3);
        String expectedOutput ="PAHNAPLSIIGYIR";
        Assert.assertEquals(expectedOutput,output);
    }


    @Test
    public void testConvertTwo(){
        String output = zigzagConversion.convert("PAYPALISHIRING",4);
        String expectedOutput ="PINALSIGYAHRPI";
        Assert.assertEquals(expectedOutput,output);
    }
}