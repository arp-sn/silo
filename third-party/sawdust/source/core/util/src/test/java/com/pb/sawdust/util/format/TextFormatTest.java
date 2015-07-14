package com.pb.sawdust.util.format;

import static com.pb.sawdust.util.format.TextFormat.Conversion;
import static com.pb.sawdust.util.format.TextFormat.FormatFlag;
import static com.pb.sawdust.util.format.TextFormat.DateTimeConversion;
import com.pb.sawdust.util.test.TestBase;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Random;

/**
 * @author crf <br/>
 *         Started: Sep 6, 2008 3:36:54 PM
 */
public class TextFormatTest  extends TestBase {
    private Random randomGenerator = new Random();

    public static void main(String ... args) {
        TestBase.main();
    }

    @Test
    public void testTextFormat1() {
        int width = randomGenerator.nextInt(20)+1;
        int precision = randomGenerator.nextInt(8)+1;
        TextFormat tf = new TextFormat(Conversion.FLOATING_POINT,width,precision);
        assertEquals("%" + width + "." + precision + "f",tf.getFormat());
    }

    @Test
    public void testTextFormat2() {
        int width = randomGenerator.nextInt(20)+1;
        int precision = randomGenerator.nextInt(8)+1;
        TextFormat tf = new TextFormat(Conversion.FLOATING_POINT,width,precision, FormatFlag.CONVERSION_DEPENDANT);
        assertEquals("%#" + width + "." + precision + "f",tf.getFormat());
    }

    @Test
    public void testTextFormat3() {
        int width = randomGenerator.nextInt(20)+1;
        int precision = randomGenerator.nextInt(8)+1;
        TextFormat tf = new TextFormat(Conversion.FLOATING_POINT,width,precision, FormatFlag.CONVERSION_DEPENDANT, FormatFlag.LEFT_JUSTIFIED);
        assertEquals("%-#" + width + "." + precision + "f",tf.getFormat());
    }

    @Test
    public void testTextFormat4() {
        int width = randomGenerator.nextInt(20)+1;
        TextFormat tf = new TextFormat(Conversion.FLOATING_POINT,width);
        assertEquals("%" + width + "f",tf.getFormat());
    }

    @Test
    public void testTextFormat5() {
        int width = randomGenerator.nextInt(20)+1;
        TextFormat tf = new TextFormat(Conversion.FLOATING_POINT,width, FormatFlag.CONVERSION_DEPENDANT);
        assertEquals("%#" + width + "f",tf.getFormat());
    }

    @Test
    public void testTextFormat6() {
        int width = randomGenerator.nextInt(20)+1;
        TextFormat tf = new TextFormat(Conversion.FLOATING_POINT,width, FormatFlag.CONVERSION_DEPENDANT, FormatFlag.LEFT_JUSTIFIED);
        assertEquals("%-#" + width + "f",tf.getFormat());
    }

    @Test
    public void testTextFormat7() {
        TextFormat tf = new TextFormat(Conversion.FLOATING_POINT);
        assertEquals("%f",tf.getFormat());
    }

    @Test
    public void testTextFormat8() {
        TextFormat tf = new TextFormat(Conversion.FLOATING_POINT, FormatFlag.CONVERSION_DEPENDANT);
        assertEquals("%#f",tf.getFormat());
    }

    @Test
    public void testTextFormat9() {
        TextFormat tf = new TextFormat(Conversion.FLOATING_POINT, FormatFlag.CONVERSION_DEPENDANT, FormatFlag.LEFT_JUSTIFIED);
        assertEquals("%-#f",tf.getFormat());
    }

    @Test
    public void testTextFormat10() {
        int width = randomGenerator.nextInt(20)+1;
        TextFormat tf = new TextFormat(Conversion.DATE_TIME, DateTimeConversion.AM_PM,width, FormatFlag.LEFT_JUSTIFIED);
        assertEquals("%-" + width + "tp",tf.getFormat());
    }

    @Test
    public void testTextFormat11() {
        int width = randomGenerator.nextInt(20)+1;
        TextFormat tf = new TextFormat(Conversion.DATE_TIME, DateTimeConversion.AM_PM,width);
        assertEquals("%" + width + "tp",tf.getFormat());
    }

    @Test
    public void testTextFormat12() {
        TextFormat tf = new TextFormat(Conversion.DATE_TIME, DateTimeConversion.AM_PM, FormatFlag.LEFT_JUSTIFIED);
        assertEquals("%-tp",tf.getFormat());
    }

    @Test
    public void testTextFormat13() {
        TextFormat tf = new TextFormat(Conversion.DATE_TIME, DateTimeConversion.AM_PM);
        assertEquals("%tp",tf.getFormat());
    }

    @Test
    public void testTextFormat14() {
        int width = randomGenerator.nextInt(20)+1;
        TextFormat tf = new TextFormat(DateTimeConversion.AM_PM,width, FormatFlag.LEFT_JUSTIFIED);
        assertEquals("%-" + width + "tp",tf.getFormat());
    }

    @Test
    public void testTextFormat15() {
        int width = randomGenerator.nextInt(20)+1;
        TextFormat tf = new TextFormat(DateTimeConversion.AM_PM,width);
        assertEquals("%" + width + "tp",tf.getFormat());
    }

    @Test
    public void testTextFormat16() {
        TextFormat tf = new TextFormat(DateTimeConversion.AM_PM, FormatFlag.LEFT_JUSTIFIED);
        assertEquals("%-tp",tf.getFormat());
    }

    @Test
    public void testTextFormat17() {
        TextFormat tf = new TextFormat(DateTimeConversion.AM_PM);
        assertEquals("%tp",tf.getFormat());
    }

    @Test
    public void testTextFormatToString() {
        TextFormat tf = new TextFormat(DateTimeConversion.AM_PM);
        assertEquals("%tp",tf.toString());
    }

    @Test
    public void testTextFormatArgumentNumber() {
        int argument = randomGenerator.nextInt(20)+1;
        TextFormat tf = new TextFormat(DateTimeConversion.AM_PM);
        assertEquals("%" + argument + "$tp",tf.getFormat(argument));
    }

    @Test
    public void testTextFormatRelativeArgument() {
        TextFormat tf = new TextFormat(DateTimeConversion.AM_PM);
        assertEquals("%<tp",tf.getFormatRelative());
    }

    @Test
    public void testGetMinimumWidthFormatReplace() {
        int width = randomGenerator.nextInt(20)+1;
        TextFormat tf = new TextFormat(Conversion.FLOATING_POINT,width+1);
        assertEquals("%" + width + "f", TextFormat.getMinimumWidthFormat(tf,width).getFormat());
    }

    @Test
    public void testGetMinimumWidthFormatNew() {
        int width = randomGenerator.nextInt(20)+1;
        TextFormat tf = new TextFormat(Conversion.FLOATING_POINT);
        assertEquals("%" + width + "f", TextFormat.getMinimumWidthFormat(tf,width).getFormat());
    }

    @Test
    public void testGetPrecisionFormatReplace() {
        int width = randomGenerator.nextInt(20)+1;
        int precision = randomGenerator.nextInt(8)+1;
        TextFormat tf = new TextFormat(Conversion.FLOATING_POINT,width,precision+1, FormatFlag.CONVERSION_DEPENDANT, FormatFlag.LEFT_JUSTIFIED);
        assertEquals("%-#" + width + "." + precision + "f", TextFormat.getPrecisionFormat(tf,precision).getFormat());
    }

    @Test
    public void testGetPrecisionFormatNew() {
        int width = randomGenerator.nextInt(20)+1;
        int precision = randomGenerator.nextInt(8)+1;
        TextFormat tf = new TextFormat(Conversion.FLOATING_POINT,width,FormatFlag.CONVERSION_DEPENDANT, FormatFlag.LEFT_JUSTIFIED);
        assertEquals("%-#" + width + "." + precision + "f", TextFormat.getPrecisionFormat(tf,precision).getFormat());
    }

    @Test
    public void testGetPrecisionFormat1() {
        int precision = randomGenerator.nextInt(8)+1;
        TextFormat tf = TextFormat.getPrecisionFormat(Conversion.FLOATING_POINT,precision,FormatFlag.CONVERSION_DEPENDANT, FormatFlag.LEFT_JUSTIFIED);
        assertEquals("%-#." + precision + "f", tf.getFormat());
    }

    @Test
    public void testGetPrecisionFormat2() {
        int precision = randomGenerator.nextInt(8)+1;
        TextFormat tf = TextFormat.getPrecisionFormat(Conversion.FLOATING_POINT,precision);
        assertEquals("%." + precision + "f", tf.getFormat());
    }

    @Test
    public void testGetFlaggedFormatReplace() {
        int width = randomGenerator.nextInt(20)+1;
        int precision = randomGenerator.nextInt(8)+1;
        TextFormat tf = new TextFormat(Conversion.FLOATING_POINT,width,precision, FormatFlag.CONVERSION_DEPENDANT);
        assertEquals("%-#" + width + "." + precision + "f", TextFormat.getFlaggedFormat(tf,FormatFlag.CONVERSION_DEPENDANT, FormatFlag.LEFT_JUSTIFIED).getFormat());
    }

    @Test
    public void testGetFlaggedFormatNew() {
        int width = randomGenerator.nextInt(20)+1;
        TextFormat tf = new TextFormat(Conversion.FLOATING_POINT,width,FormatFlag.CONVERSION_DEPENDANT);
        assertEquals("%-#" + width + "f", TextFormat.getFlaggedFormat(tf,FormatFlag.LEFT_JUSTIFIED).getFormat());
    }

    @Test
    public void testGetNoMinimumWidthFormat() {
        int width = randomGenerator.nextInt(20)+1;
        TextFormat tf = new TextFormat(Conversion.FLOATING_POINT,width);
        assertEquals("%f", TextFormat.noMinimumWidthFormat(tf).getFormat());
    }

    @Test
    public void testNoPrecisionFormat() {
        int width = randomGenerator.nextInt(20)+1;
        int precision = randomGenerator.nextInt(8)+1;
        TextFormat tf = new TextFormat(Conversion.FLOATING_POINT,width,precision, FormatFlag.CONVERSION_DEPENDANT, FormatFlag.LEFT_JUSTIFIED);
        assertEquals("%-#" + width + "f", TextFormat.noPrecisionFormat(tf).getFormat());
    }

    @Test
    public void testNoFlaggedFormat() {
        int width = randomGenerator.nextInt(20)+1;
        int precision = randomGenerator.nextInt(8)+1;
        TextFormat tf = new TextFormat(Conversion.FLOATING_POINT,width,precision, FormatFlag.CONVERSION_DEPENDANT, FormatFlag.LEFT_JUSTIFIED);
        assertEquals("%" + width + "." + precision + "f", TextFormat.noFlagFormat(tf).getFormat());
    }


    @Test
     public void testValidArgument1() {
        assertTrue(Conversion.BOOLEAN.isValidArgument("y"));
    }

    @Test
     public void testValidArgument2() {
        assertTrue(Conversion.BOOLEAN_UPPER_CASE.isValidArgument("y"));
    }

    @Test
     public void testValidArgument3() {
        assertTrue(Conversion.CHARACTER.isValidArgument('y'));
    }

    @Test
     public void testValidArgument4() {
        assertFalse(Conversion.CHARACTER.isValidArgument(-8));
    }

    @Test
     public void testValidArgument5() {
        assertTrue(Conversion.CHARACTER_UPPER_CASE.isValidArgument('y'));
    }

    @Test
     public void testValidArgument6() {
        assertFalse(Conversion.CHARACTER_UPPER_CASE.isValidArgument(-8));
    }

    @Test
     public void testValidArgument7() {
        assertTrue(Conversion.DATE_TIME.isValidArgument(6767L));
    }

    @Test
     public void testValidArgument8() {
        assertFalse(Conversion.DATE_TIME.isValidArgument(9));
    }

    @Test
     public void testValidArgument9() {
        assertTrue(Conversion.DATE_TIME_UPPER_CASE.isValidArgument(6767L));
    }

    @Test
     public void testValidArgument10() {
        assertFalse(Conversion.DATE_TIME_UPPER_CASE.isValidArgument(9));
    }

    @Test
     public void testValidArgument11() {
        assertTrue(Conversion.FLOATING_POINT.isValidArgument(7.9));
    }

    @Test
     public void testValidArgument12() {
        assertFalse(Conversion.FLOATING_POINT.isValidArgument(9));
    }

    @Test
     public void testValidArgument13() {
        assertTrue(Conversion.FLOATING_POINT_HEXADECIMAL.isValidArgument(7.9));
    }

    @Test
     public void testValidArgument14() {
        assertFalse(Conversion.FLOATING_POINT_HEXADECIMAL.isValidArgument(9));
    }

    @Test
     public void testValidArgument15() {
        assertTrue(Conversion.FLOATING_POINT_HEXADECIMAL_UPPER_CASE.isValidArgument(7.9));
    }

    @Test
     public void testValidArgument16() {
        assertFalse(Conversion.FLOATING_POINT_HEXADECIMAL_UPPER_CASE.isValidArgument(9));
    }

    @Test
     public void testValidArgument17() {
        assertTrue(Conversion.FLOATING_POINT_OR_SCIENTIFIC.isValidArgument(7.9));
    }

    @Test
     public void testValidArgument18() {
        assertFalse(Conversion.FLOATING_POINT_OR_SCIENTIFIC.isValidArgument(9));
    }

    @Test
     public void testValidArgument19() {
        assertTrue(Conversion.FLOATING_POINT_OR_SCIENTIFIC_UPPER_CASE.isValidArgument(7.9));
    }

    @Test
     public void testValidArgument20() {
        assertFalse(Conversion.FLOATING_POINT_OR_SCIENTIFIC_UPPER_CASE.isValidArgument(9));
    }

    @Test
     public void testValidArgument21() {
        assertTrue(Conversion.HASH_CODE.isValidArgument("k"));
    }

    @Test
     public void testValidArgument22() {
        assertTrue(Conversion.HASH_CODE_UPPER_CASE.isValidArgument("k"));
    }

    @Test
     public void testValidArgument23() {
        assertTrue(Conversion.INTEGER.isValidArgument(5));
    }

    @Test
     public void testValidArgument24() {
        assertFalse(Conversion.INTEGER.isValidArgument(5.9));
    }

    @Test
     public void testValidArgument25() {
        assertTrue(Conversion.INTEGER_HEXADECIMAL.isValidArgument(5));
    }

    @Test
     public void testValidArgument26() {
        assertFalse(Conversion.INTEGER_HEXADECIMAL.isValidArgument(5.9));
    }

    @Test
     public void testValidArgument27() {
        assertTrue(Conversion.INTEGER_HEXADECIMAL_UPPER_CASE.isValidArgument(5));
    }

    @Test
     public void testValidArgument28() {
        assertFalse(Conversion.INTEGER_HEXADECIMAL_UPPER_CASE.isValidArgument(5.9));
    }

    @Test
     public void testValidArgument29() {
        assertTrue(Conversion.INTEGER_OCTAL.isValidArgument(5));
    }

    @Test
     public void testValidArgument30() {
        assertFalse(Conversion.INTEGER_OCTAL.isValidArgument(5.9));
    }

    @Test
     public void testValidArgument31() {
        assertFalse(Conversion.NEW_LINE.isValidArgument(5));
    }

    @Test
     public void testValidArgument32() {
        assertFalse(Conversion.PERCENT.isValidArgument(5));
    }

    @Test
     public void testValidArgument33() {
        assertTrue(Conversion.SCIENTIFIC.isValidArgument(5.9));
    }

    @Test
     public void testValidArgument34() {
        assertFalse(Conversion.SCIENTIFIC.isValidArgument(5));
    }

    @Test
     public void testValidArgument35() {
        assertTrue(Conversion.SCIENTIFIC_UPPER_CASE.isValidArgument(5.9));
    }

    @Test
     public void testValidArgument36() {
        assertFalse(Conversion.SCIENTIFIC_UPPER_CASE.isValidArgument(5));
    }

    @Test
     public void testValidArgument37() {
        assertTrue(Conversion.STRING.isValidArgument("jh"));
    }

    @Test
     public void testValidArgument38() {
        assertTrue(Conversion.STRING_UPPER_CASE.isValidArgument("jh"));
    }

    @Test(expected= IllegalArgumentException.class)
    public void testTextFormatFailure1() {
        int width = randomGenerator.nextInt(20)+1;
        int precision = randomGenerator.nextInt(8)+1;
        new TextFormat(Conversion.CHARACTER,width,precision);
    }

    @Test(expected= IllegalArgumentException.class)
    public void testTextFormatFailure2() {
        int precision = randomGenerator.nextInt(8)+1;
        new TextFormat(Conversion.FLOATING_POINT,-1,precision);
    }

    @Test(expected= IllegalArgumentException.class)
    public void testTextFormatFailure3() {
        int width = randomGenerator.nextInt(20)+1;
        new TextFormat(Conversion.FLOATING_POINT,width,-1);
    }

    @Test(expected= IllegalArgumentException.class)
    public void testTextFormatFailure4() {
        new TextFormat(Conversion.FLOATING_POINT,-1);
    }

    @Test(expected= IllegalArgumentException.class)
    public void testTextFormatFailure5() {
        new TextFormat(Conversion.STRING,FormatFlag.INCLUDE_SIGN);
    }

    @Test(expected= IllegalArgumentException.class)
    public void testTextFormatFailure6() {
        new TextFormat(Conversion.STRING, DateTimeConversion.AM_PM);
    }

    @Test(expected= IllegalArgumentException.class)
    public void testTextFormatFailure7() {
        new TextFormat(Conversion.DATE_TIME);
    }

    @Test(expected= IllegalArgumentException.class)
    public void testTextFormatFailure8() {
        new TextFormat(Conversion.DATE_TIME, DateTimeConversion.AM_PM,-1);
    }

    @Test(expected= IllegalArgumentException.class)
    public void testTextFormatFailure9() {
        new TextFormat(Conversion.DATE_TIME, DateTimeConversion.AM_PM,1, FormatFlag.INCLUDE_SIGN);
    }

    @Test(expected= IllegalArgumentException.class)
    public void testTextFormatFailure10() {
        new TextFormat(Conversion.DATE_TIME, DateTimeConversion.AM_PM,FormatFlag.INCLUDE_SIGN);
    }

    @Test(expected= IllegalArgumentException.class)
    public void testTextFormatBadArgumentNumber() {  
        TextFormat tf = new TextFormat(DateTimeConversion.AM_PM);
        tf.getFormat(0);
    }

    @Test
    public void testFormat() {
        String d = "ghjf";
        int width = 20;
        TextFormat tf = new TextFormat(Conversion.STRING, width, FormatFlag.LEFT_JUSTIFIED);
        assertEquals(String.format(tf.getFormat(),d),tf.format(d));
    }

    @Test(expected= IllegalArgumentException.class)
    public void testFormatFailure() {
        String d = "ghjf";
        int width = 20;
        TextFormat tf = new TextFormat(Conversion.INTEGER, width, FormatFlag.LEFT_JUSTIFIED);
        tf.format(d);
    }

}