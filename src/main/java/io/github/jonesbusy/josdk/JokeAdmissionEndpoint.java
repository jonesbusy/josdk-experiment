package io.github.jonesbusy.josdk;

import io.fabric8.kubernetes.api.model.admission.v1.AdmissionReview;
import io.javaoperatorsdk.webhook.admission.AdmissionController;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/jokes")
public class JokeAdmissionEndpoint {

    @Inject
    @Named(JokeAdmissionController.VALIDATING_CONTROLLER)
    private AdmissionController<Joke> jokeValidationController;

    private static final Logger LOG = LoggerFactory.getLogger(JokeAdmissionController.class);

    @POST
    @Path("validate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unused")
    public AdmissionReview validate(AdmissionReview admissionReview) {
        LOG.info("Received admission review: {}", admissionReview);
        return jokeValidationController.handle(admissionReview);
    }

}


