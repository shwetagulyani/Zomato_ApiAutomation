package util;

import org.testng.Assert;

import java.util.List;

public class ApiAsserts {

    public static void assertTrue(boolean condition, String failureMsg) {
        Assert.assertTrue(condition, failureMsg);
    }

    public static void assertFalse(boolean condition, String failureMsg) {
        Assert.assertFalse(condition, failureMsg);
    }

    public static void assertEquals(Object value, Object expectedValue, String failureMsg) {
        Assert.assertEquals(value, expectedValue, failureMsg);
    }

    public static void assertNull(Object object, String failureMsg) {
        Assert.assertNull(object, failureMsg);
    }

    public static void assertNotNull(Object object, String failureMsg) {
        Assert.assertNotNull(object, failureMsg);
    }

    public static void assertEmpty(List<?> object, String failureMsg) {
        Assert.assertTrue(object.isEmpty(), failureMsg);
    }

    public static void assertEmpty(String object, String failureMsg) {
        Assert.assertTrue(object.isEmpty(), failureMsg);
    }

    public static void assertNotEmpty(List<?> object, String failureMsg) {
        Assert.assertFalse(object.isEmpty(), failureMsg);
    }

    public static void assertNotEmpty(String object, String failureMsg) {
        Assert.assertFalse(object.isEmpty(), failureMsg);
    }

    public static void fail(String failureMsg) {
        Assert.fail(failureMsg);
    }

    public static void fail(String failureMsg, Throwable throwable) {
        Assert.fail(failureMsg, throwable);
    }

}
