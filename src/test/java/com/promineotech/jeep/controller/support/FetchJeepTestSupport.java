package com.promineotech.jeep.controller.support;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.promineotech.jeep.controller.Jeep;
import com.promineotech.jeep.entity.JeepModel;

public class FetchJeepTestSupport extends BaseTest{
protected List<Jeep> buildExpected() {
		List<Jeep> list = new LinkedList<>();
		
		// @formatter:off
		list.add(Jeep.builder()
				 .modelId(JeepModel.WRANGLER)
				 .trimLevel("Sport")
				 .numDoors(4)
				 .wheelSize(17)
				 .basePrice(new BigDecimal("31975.00"))
				 .build());
		
		list.add(Jeep.builder()
				 .modelId(JeepModel.WRANGLER)
				 .trimLevel("Sport")
				 .numDoors(2)
				 .wheelSize(17)
				 .basePrice(new BigDecimal("28475.00"))
				 .build());
		// @formatter:on
		
		Collections.sort(list);
		return list;
		}
	
/**
 * 
 * @param error
 * @param status
 */
protected void assertErrorMessageValid(Map<String, Object> error,
		HttpStatus status) {
	// @formatter:off
	assertThat(error)
		.containsKey("message")
		.containsEntry("status code", status.value())
		.containsEntry("uri", "/jeeps")
		.containsKey("timestamp")
		.containsEntry("reason", status.getReasonPhrase());
	// @formatter:on
}
}

/*
 * Dr. Rob swaps lists to better test the buildExpected method. Add a sorting capability on the
 * Jeep class. You don't want to rely on the default order out of the database because you won't
 * usually  know the order will come out as. Use comparator for sorting as well.
 */
