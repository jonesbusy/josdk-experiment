package io.github.jonesbusy.josdk;

import io.javaoperatorsdk.webhook.admission.AdmissionController;
import io.javaoperatorsdk.webhook.admission.NotAllowedException;
import io.javaoperatorsdk.webhook.admission.Operation;
import io.javaoperatorsdk.webhook.admission.validation.Validator;

/**
 * Admission controllers for the Joke resource.
 */
public class AdmisionControllers {

    /**
     * Validating admission controller for the Joke resource.
     * @return a validating admission controller for the Joke resource
     */
    public static AdmissionController<Joke> jokeValidatingController() {
        return new AdmissionController<>(new JokeValidator());
    }

    /**
     * Validator for the Joke resource.
     */
    private static class JokeValidator implements Validator<Joke> {
        @Override
        public void validate(Joke resource, Operation operation) throws NotAllowedException {
            if (resource.getSpec().getName() == null) {
                throw new NotAllowedException("Name is required");
            }
        }
    }

}
