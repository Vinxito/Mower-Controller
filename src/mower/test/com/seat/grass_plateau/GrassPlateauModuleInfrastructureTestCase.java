package com.seat.grass_plateau;

import com.seat.apps.mower.MowerBackendApplication;
//import com.seat.shared.infrastructure.InfrastructureTestCase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = MowerBackendApplication.class)
@SpringBootTest
public abstract class GrassPlateauModuleInfrastructureTestCase {
//        extends InfrastructureTestCase {
//
//    @Autowired
//    private ElasticsearchEnvironmentArranger elasticsearchEnvironmentArranger;
//
//    protected void clearElasticsearch() throws IOException {
//        elasticsearchEnvironmentArranger.arrange("mower", "moweres");
//    }
}
