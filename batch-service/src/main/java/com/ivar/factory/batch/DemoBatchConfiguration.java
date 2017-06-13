package com.ivar.factory.batch;

import com.ivar.factory.batch.domains.Airport;
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

	@Bean
	DataSource dataSource() {

		try {
			OracleDataSource dataSource = new OracleDataSource();
			dataSource.setUser("test_app");
			dataSource.setPassword("test_app");
			dataSource.setURL("jdbc:oracle:thin:@localhost:1521:XE");
			dataSource.setImplicitCachingEnabled(true);
			dataSource.setFastConnectionFailoverEnabled(true);
			return dataSource;
		}catch(SQLException e){

		}
		return null;
	}

	@Bean
	public FlatFileItemReader<Airport> reader() {
		FlatFileItemReader<Airport> reader = new FlatFileItemReader<Airport>();
		reader.setResource(new ClassPathResource("airports.csv"));
		reader.setLineMapper(new DefaultLineMapper<Airport>() {{
			setLineTokenizer(new DelimitedLineTokenizer() {{
				setNames(new String[] {"id",
				"ident",
				"type",
				"name",
				"latitudeDeg",
				"longitudeDeg",
				"elevationFt",
				"continent",
				"isoCountry",
				"isoRegion",
				"municipality",
				"scheduledService",
				"gpsCode",
				"iataCode",
				"localCode",
				"homeLink",
				"wikipediaLink",
				"keywords"});
			}});
			setFieldSetMapper(new BeanWrapperFieldSetMapper<Airport>() {{
				setTargetType(Airport.class);
			}});
		}});
		return reader;
	}

	@Bean
	public JdbcBatchItemWriter<Airport> writer() {
		JdbcBatchItemWriter<Airport> writer = new JdbcBatchItemWriter<Airport>();
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Airport>());
		writer.setSql("INSERT INTO AIRPORT (id,ident,type,name,latitude_deg ,longitude_deg ,elevation_ft ,continent,iso_country,iso_region,municipality,scheduled_service,gps_code,iata_code,local_code,home_link,wikipedia_link, key_words) VALUES (:id, :ident, :type, :name, :latitudeDeg, :longitudeDeg, :elevationFt, :continent, :isoCountry, :isoRegion, :municipality, :scheduledService, :gpsCode, :iataCode, :localCode, :homeLink, :wikipediaLink, :keywords)");
		writer.setDataSource(dataSource());
		return writer;
	}
	// end::readerwriterprocessor[]

	// tag::jobstep[]
	@Bean
	public Job importUserJob(JobCompletionNotificationListener listener) {
		return jobBuilderFactory.get("importUserJob")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(step1())
				.end()
				.build();
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1")
				.<Airport, Airport> chunk(10)
				.reader(reader())
				.processor(airportItemProcessor)
				.writer(writer())
				.build();
	}
}
