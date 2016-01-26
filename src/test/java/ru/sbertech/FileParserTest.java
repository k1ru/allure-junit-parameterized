package ru.sbertech;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class FileParserTest
        extends TestCase {

    private static FileParser parseDataFromFile = new FileParser();
    private static int firstArg;
    private static int secondArg;
    private static String operation;
    private static int resultFromFile;
    private static int expectedResult;

    public FileParserTest(String arg1, String arg2, String oper, String res) {
        this.firstArg = Integer.parseInt(arg1);
        this.secondArg = Integer.parseInt(arg2);
        this.operation = oper;
        this.resultFromFile = Integer.parseInt(res);
    }

    @Parameterized.Parameters(name = "firstArg:{0} secondArg:{1} operation:{2} result:{3}")
    public static Collection<Object[]> data() {
        Collection<Object[]> result = new ArrayList<Object[]>();
        List<String[]> list = parseDataFromFile.parseFile(new File("dataFile.txt"));
        for (String[] line : list) {
            result.add(line);
        }
        return result;
    }

    @Test
    public void testResultInFile() {
        switch (operation) {
            case "-":
                expectedResult = firstArg - secondArg;
                Assert.assertEquals(resultFromFile, expectedResult, 0.1);
                break;
            case "+":
                expectedResult = firstArg + secondArg;
                Assert.assertEquals(resultFromFile, expectedResult, 0.1);
                break;
            case "/":
                expectedResult = firstArg / secondArg;
                Assert.assertEquals(resultFromFile, expectedResult, 0.1);
                break;
            case "*":
                expectedResult = firstArg * secondArg;
                Assert.assertEquals(resultFromFile, expectedResult, 0.1);
                break;
            default:
                Assert.fail("wrong operation");
                break;
        }
        System.out.println(firstArg + operation + secondArg + "=" + resultFromFile + " \nexpected result: " + expectedResult);
    }
}