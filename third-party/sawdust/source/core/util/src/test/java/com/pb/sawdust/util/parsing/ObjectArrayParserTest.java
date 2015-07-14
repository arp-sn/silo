package com.pb.sawdust.util.parsing;

import org.junit.Test;
import static org.junit.Assert.*;
import com.pb.sawdust.util.test.TestBase;
import static com.pb.sawdust.util.Range.*;

/**
 * @author crf <br/>
 *         Started: Sep 3, 2008 7:54:28 PM
 */
public class ObjectArrayParserTest extends ArrayParserTest<Object[],Object[]> {

    public static void main(String ... args) {
        TestBase.main();
    }
    
    ArrayParser<Object[],Object[]> getArrayParser(int[] widths) {
        return new ObjectArrayParser<Object>(widths);
    }

    ArrayParser<Object[],Object[]> getArrayParser(int[] positions, int length) {
        return new ObjectArrayParser<Object>(positions,length);
    }

    Object[] getSampleInput(int length) {
        return new Object[length];
    }

    @Test
    public void testFormOutputElement() {
        Object[] input = getSampleInput(widths.length);
        assertArrayEquals(input,arrayParser.formOutputElement(input));
    }

    @Test
    public void testParse() {
        testParseTest(true);
    }

    @Test
    public void testParsePositionsSize() {
        testParseTest(false);
    }

    private void testParseTest(boolean useWidths) {
        int[] widths = new int[] {1,2,1};
        int[] positions = new int[widths.length];
        int size = 0;
        for (int i = 0; i < widths.length; i++) {
            positions[i] = size;
            size += widths[i];
        }
        Object[] input = new Object[] {1,"",7.0f,false};
        Object[][] output = new Object[3][];
        output[0] = new Object[] {1};
        output[1] = new Object[] {"",7.0f};
        output[2] = new Object[] {false};

        if (useWidths)
            arrayParser = getArrayParser(widths);
        else
            arrayParser = getArrayParser(positions,size);
        assertArrayEquals(output,arrayParser.parse(input));
    }

    @Test
    public void testOpenParseFinalElement() {
        setOpenParser();
        int finalElementSize = randomGenerator.nextInt(10) + 1;
        Object[] sampleInput = getSampleInput(arrayParser.getMinLength() + finalElementSize);
        for (int i : range(sampleInput.length))
            sampleInput[i] = randomGenerator.nextInt();
        Object[] finalElement = new Object[finalElementSize];
        System.arraycopy(sampleInput,arrayParser.getMinLength(),finalElement,0,finalElementSize);
        assertArrayEquals(finalElement,arrayParser.parse(sampleInput)[widths.length-1]);
    }
}