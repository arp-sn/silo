package com.pb.sawdust.calculator.tensor.la.mm.partition;

import com.pb.sawdust.calculator.tensor.la.mm.AbstractMatrixMultiplication;
import com.pb.sawdust.util.JavaType;

/**
 * The {@code ShadowMatrixMultiplicationResource} ...
 *
 * @author crf <br/>
 *         Started 1/11/11 10:14 AM
 */
public class ShadowMatrixMultiplicationResource implements MatrixMultiplicationResource {
    private final MatrixMultiplicationResource parent;
    private final MatrixMultiplicationResource mmr;

    public ShadowMatrixMultiplicationResource(MatrixMultiplicationResource parent, MatrixMultiplicationResource mmr) {
        this.parent = parent;
        this.mmr = mmr;
    }

    @Override
    public AbstractMatrixMultiplication getMatrixMultiplication() {
        return mmr.getMatrixMultiplication();
    }

    @Override
    public int getMaxCellCount(JavaType type) {
        return parent.getMaxCellCount(type);
    }

    @Override
    public boolean isAvailable() {
        return mmr.isAvailable();
    }

    @Override
    public PartitionRule getPartitionRule(JavaType type, int[] m1Dim, int[] m2Dim, boolean transpose1, boolean transpose2) {
        return parent.getPartitionRule(type,m1Dim,m2Dim,transpose1,transpose2);
    }
}