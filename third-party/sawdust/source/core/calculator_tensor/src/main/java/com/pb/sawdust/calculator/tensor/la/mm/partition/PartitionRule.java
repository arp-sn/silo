package com.pb.sawdust.calculator.tensor.la.mm.partition;

/**
* The {@code PartitionRule} ...
*
* @author crf <br/>
*         Started 1/11/11 10:10 AM
*/
public interface PartitionRule {
    int nextPartitionLength(int start);
    boolean partitionFirstIndex();
}