package com.ivar.factory.batch.domains;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by ONC50886 on 6/13/2017.
 */
@Component
public class Airport {
	public String id;
	public String ident;
	public String type;
	public String name;
	public String latitudeDeg;
	public String longitudeDeg;
	public String elevationFt;
	public String continent;
	public String isoCountry;
	public String isoRegion;
	public String municipality;
	public String scheduledService;
	public String gpsCode;
	public String iataCode;
	public String localCode;
	public String homeLink;
	public String wikipediaLink;
	public String keywords;

}
