package com.ivar.factory.batch;

import com.ivar.factory.batch.domains.Airport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by ONC50886 on 6/13/2017.
 */
@Component
public class AirportItemProcessor implements ItemProcessor<Airport,Airport> {
	private static final Logger log = LoggerFactory.getLogger(AirportItemProcessor.class);

	public Airport process(Airport airport) throws Exception {
		log.info(">>>Processing airport:"+airport.iataCode);
		return airport;
	}
}
