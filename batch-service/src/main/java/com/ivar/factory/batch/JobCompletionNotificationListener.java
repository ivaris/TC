package com.ivar.factory.batch;

/**
 * Created by ONC50886 on 6/13/2017.
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ivar.factory.batch.domains.Airport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("!!! JOB FINISHED! Time to verify the results");

			List<String> results = jdbcTemplate.query("SELECT iata_code FROM AIRPORT", new RowMapper<String>() {
				@Override
				public String mapRow(ResultSet rs, int row) throws SQLException {

					return rs.getString(1);
				}
			});

			for (String aataCode : results) {
				log.info("Found <" + aataCode + "> in the database.");
			}

		}
	}
}
