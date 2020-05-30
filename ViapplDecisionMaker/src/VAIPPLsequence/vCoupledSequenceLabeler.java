/*******************************************************************************
 * Copyright (c) 2020 KC Igwe
 ******************************************************************************
 */
package VAIPPLsequence;

import java.io.Serializable;

public interface vCoupledSequenceLabeler<T> extends Serializable {
	/**
	 * Predicts the sequence labels.
	 * @param x a sequence. At each position, it may be the original symbol or
	 * a feature set about the symbol, its neighborhood, and/or other information.
	 * @return the predicted sequence labels.
	 */
	int[][][] predict(T[] x);
}
