package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.ShowData;
import br.com.alura.screenmatch.service.ConsumerAPI;
import br.com.alura.screenmatch.service.DataConvert;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumerAPI consumerAPI = new ConsumerAPI();
		var json = consumerAPI.getData("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		System.out.println(json);
		DataConvert convert = new DataConvert();
		ShowData data = convert.getData(json, ShowData.class);
		System.out.println(data);
	}
}