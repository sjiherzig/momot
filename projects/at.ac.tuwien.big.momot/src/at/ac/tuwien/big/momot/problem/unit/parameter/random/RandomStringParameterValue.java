/*******************************************************************************
 * Copyright (c) 2015 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Martin Fleck (Vienna University of Technology) - initial API and implementation
 *
 * Initially developed in the context of ARTIST EU project www.artist-project.eu
 *******************************************************************************/
package at.ac.tuwien.big.momot.problem.unit.parameter.random;

import at.ac.tuwien.big.moea.util.random.RandomString;
import at.ac.tuwien.big.momot.problem.unit.parameter.IParameterValue;

public class RandomStringParameterValue implements IParameterValue<String> {

	private RandomString randomString;
	private String initialValue = null;
	
	public RandomStringParameterValue(Integer lowerBoundLength,
			Integer upperBoundLength) {
		randomString = new RandomString(lowerBoundLength, upperBoundLength);
	}
	
	public RandomStringParameterValue(Integer length) {
		this(length, length);
	}

	public RandomStringParameterValue() {
		this(1);
	}

	@Override
	public String nextValue() {
		String value = randomString.nextRandom();
		if(initialValue == null)
			initialValue = value;
		return value;
	}

	@Override
	public String getInitialValue() {
		return initialValue;
	}	
}