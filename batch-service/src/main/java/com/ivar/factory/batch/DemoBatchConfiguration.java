package com.ivar.factory.batch;

import com.ivar.factory.batch.domains.Airport;
import com.mongodb.Mongo;
import com.mongodb.client.jndi.MongoClientFactory;
import oracle.jdbc.pool.OracleDataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by ONC50886 on 6/13/2017.
 */
@Configuration
@EnableBatchProcessing
public class DemoBatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public AirportItemProcessor airportItemProcessor;

	@Autowired
	public MongoRepository<Airport,Airport> mongoRepository;


	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1")
				.<Airport, Airport> chunk(100)
				.reader()
				.processor(airportItemProcessor)
				.writer()
				.build();
	}
}
