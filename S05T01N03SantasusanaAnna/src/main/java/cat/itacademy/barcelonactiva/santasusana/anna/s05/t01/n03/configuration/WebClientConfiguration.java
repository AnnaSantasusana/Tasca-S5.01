package cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n03.configuration;

import io.netty.channel.ChannelOption;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import java.time.Duration;

@Configuration
public class WebClientConfiguration {

    @Bean
    public WebClient webClient() {

        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000)
                .responseTimeout(Duration.ofSeconds(10));

        return WebClient.builder()
                .baseUrl("http://localhost:9001/flowers") // La URL de l'API del nivell 2
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

    }

    /**
     * línea: .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000)
     * Tiempo máximo en milisegundos que el cliente HTTP esperará para establecer una conexión con el servidor
     * antes de lanzar una excepción TimeoutException.
     *
     * línea: .responseTimeout(Duration.ofSeconds(10))
     * Tiempo máximo de espera para recibir la respuesta del servidor después de que se ha enviado la solicitud.
     */


}

