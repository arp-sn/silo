package com.pb.sawdust.calculator.tensor.la.mm;

import com.pb.sawdust.tensor.factory.TensorFactory;
import com.pb.sawdust.util.test.TestBase;

/**
 * The {@code DefaultMatrixMultiplicationTest} ...
 *
 * @author crf <br/>
 *         Started Dec 13, 2010 8:51:44 AM
 */
public class DefaultMatrixMultiplicationTest extends AbstractMatrixMultiplicationTest {

    public static void main(String ... args) {
        TestBase.main();
    }

    @Override
    protected AbstractMatrixMultiplication getAbstractMatrixMultiplication(TensorFactory factory) {
        return new DefaultMatrixMultiplication(factory);
    }
}