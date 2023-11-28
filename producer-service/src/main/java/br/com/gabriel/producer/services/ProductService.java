package br.com.gabriel.producer.services;

import br.com.gabriel.producer.dtos.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static br.com.gabriel.producer.configs.RabbitMqConfig.EXG_NAME_MARKETPLACE;
import static br.com.gabriel.producer.configs.RabbitMqConfig.RK_PRODUCT_LOG;

@Log4j2
@Service
@RequiredArgsConstructor
public class ProductService {

    private final RabbitTemplate rabbitTemplate;

    public void createProduct(ProductDTO dto) {
        log.info("Sending message to exchange: {}", dto);
        rabbitTemplate.convertAndSend(EXG_NAME_MARKETPLACE, RK_PRODUCT_LOG, dto);
    }
}
