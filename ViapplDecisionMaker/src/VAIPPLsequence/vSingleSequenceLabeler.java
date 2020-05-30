/*******************************************************************************
 * Copyright (c) 2020 KC Igwe
 * copyright license to be inserted
 ******************************************************************************
 */

package VAIPPLsequence;

import java.io.Serializable;

/**
 * A sequence labeler assigns a class label to each position of the sequence.
 *
 * @author KC Igwe
 */
public interface vSingleSequenceLabeler<T> extends Serializable {
    /**
     * Predicts the sequence labels.
     * @param x a sequence. At each position, it may be the original symbol or
     * a feature set about the symbol, its neighborhood, and/or other information.
     * @return the predicted sequence labels.
     */
    int[] predict(T[] x);
}
