package io.github.jonesbusy.josdk;

import io.javaoperatorsdk.webhook.admission.AdmissionController;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JokeAdmissionController {

    public static final String VALIDATING_CONTROLLER = "jokeValidatingController";

    private static final Logger LOG = LoggerFactory.getLogger(JokeAdmissionController.class);

    @Singleton
    @Named(VALIDATING_CONTROLLER)
    public AdmissionController<Joke> validatingController() {
        LOG.info("Creating validating controller");
        return AdmisionControllers.jokeValidatingController();
    }

}
