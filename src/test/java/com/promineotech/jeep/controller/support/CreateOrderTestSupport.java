package com.promineotech.jeep.controller.support;

public class CreateOrderTestSupport extends BaseTest{
	/**
	 * 
	 * @return
	 */
	protected String createOrderBody() {
//		// @formatter:off
//		return 
//				{
//				"customer_id":"ATTAWAY_HECKTOR",
//				"model_id":"WRANGLER",
//				"trim_level":"Sport",
//				"num_doors":2,
//				"color_id":"EXT_DIAMOND_BLACK",
//				"engine_id":"3_6_GAS",
//				"tire_id":"265_MICHELIN",
//				"option_id":[
//				"DOOR_QUAD_4"
//				"EXT_AEV_LIFT"
//				"EXT_WARN_WINCH"
//				"EXT_WARN_BUMPER_FRONT"
//				"EXT_WARN_BUMPER_REAR"
//				"EXT_ARB_COMPRESSOR"
//				  ]
//		}
//		// @formatter:on

				// @formatter:off
		return "{\n"
				+ "  \"customer\":\"MORISON_LINA\",\n"
				+ "  \"model\":\"WRANGLER\",\n"
				+ "  \"trim\":\"Sport Altitude\",\n"
				+ "  \"doors\":\"4\",\n"
				+ "  \"color\":\"EXT_NACHO\",\n"
				+ "  \"engine\":\"2_0_TURBO\",\n"
				+ "  \"tire\":\"35_TOYO\",\n"
				+ "  \"options\":[\n"
				+ "    \"DOOR_QUAD_4\",\n"
				+ "    \"EXT_AEV_LIFT\",\n"
				+ "    \"EXT_WARN_WINCH\",\n"
				+ "    \"EXT_WARN_BUMPER_FRONT\",\n"
				+ "    \"EXT_WARN_BUMPER_REAR\",\n"
				+ "    \"EXT_ARB_COMPRESSOR\"\n"
				+ "  ]\n"
				+ "}";
		// @formatter:on
	}
}

