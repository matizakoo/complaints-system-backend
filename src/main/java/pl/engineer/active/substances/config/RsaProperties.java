package pl.engineer.active.substances.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jwt")
public class RsaProperties {
    @Value("${spring.jwt.private-key}")
    private String privateKey;
    @Value("${spring.jwt.public-key}")
    private String publicKey;

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public RsaProperties setPublicKey(String publicKey) {
        this.publicKey = publicKey;
        return this;
    }
}