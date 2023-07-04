package com.example.contentcalendar;

import com.example.contentcalendar.model.Content;
import com.example.contentcalendar.model.Status;
import com.example.contentcalendar.model.Type;
import com.example.contentcalendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class ContentCalendarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentCalendarApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ContentRepository repository) {
		return args -> {
			// Insert some data into the database
			Content content = new Content(
					null,
					"Hello!",
					"Hello!",
					Status.IDEA,
					Type.VIDEO,
					LocalDateTime.now(),
					null,
					""
			);
			repository.save(content);
		};
	}

}
