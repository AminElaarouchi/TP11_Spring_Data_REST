package com.example.banque;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BanqueRestTest {
    @LocalServerPort int port;
    @Autowired TestRestTemplate http;

    @Test void exposesSearchProjectionAndRelations() {
        String base = "http://localhost:" + port + "/api";
        assertThat(http.getForObject(base + "/comptes?page=0&size=2&sort=solde,desc", String.class)).contains("page", "comptes");
        assertThat(http.getForObject(base + "/comptes/search/byType?t=EPARGNE", String.class)).contains("EPARGNE");
        assertThat(http.getForObject(base + "/comptes/1?projection=mobile", String.class)).contains("solde", "type");
        assertThat(http.getForObject(base + "/clients/1/comptes", String.class)).contains("comptes");
    }
}
