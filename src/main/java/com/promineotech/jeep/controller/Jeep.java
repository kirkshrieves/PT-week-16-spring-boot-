package com.promineotech.jeep.controller;

import java.math.BigDecimal;
import java.util.Comparator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.promineotech.jeep.entity.JeepModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // @Data = @Getter, @Setter, @EqualsAndHashCode, @ToString, @NoArgsConstructor
@Builder // @Builder = builder design patter; turns no args constructor into an all args constructor
@NoArgsConstructor // still needed to create more jeep objects in the future
@AllArgsConstructor// needed to unbreak @Builder because it needs an @AllArgsConstructor

public class Jeep implements Comparable<Jeep>{
	
	private Long modelPK;
	private JeepModel modelId;
	private String trimLevel;
	private int numDoors;
	private int wheelSize;
	private BigDecimal basePrice;

	@JsonIgnore
	public Long getModelPK() {
		 return modelPK;
	 }

	@Override
	public int compareTo(Jeep that) {
		// @formatter:off
		return Comparator
				.comparing(Jeep::getModelId)//something about this acting as a lambda?
				.thenComparing(Jeep::getTrimLevel)
				.thenComparing(Jeep::getNumDoors)
				.compare(this,that);
		// @formatter:on
	}
}

/*
* Coming from the FetchJeepTest class, we are changing the Jeep class. 
* The getModelPK method won't return decimal points or previous selections if a hacker tries to
* hack. Jackson serializing the object into json it will leave out or ignore the primary key
*
*/
