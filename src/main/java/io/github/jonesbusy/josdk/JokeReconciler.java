package io.github.jonesbusy.josdk;

import static io.javaoperatorsdk.operator.api.reconciler.Constants.WATCH_CURRENT_NAMESPACE;

import io.javaoperatorsdk.operator.api.config.informer.Informer;
import io.javaoperatorsdk.operator.api.reconciler.Cleaner;
import io.javaoperatorsdk.operator.api.reconciler.Context;
import io.javaoperatorsdk.operator.api.reconciler.ControllerConfiguration;
import io.javaoperatorsdk.operator.api.reconciler.DeleteControl;
import io.javaoperatorsdk.operator.api.reconciler.Reconciler;
import io.javaoperatorsdk.operator.api.reconciler.UpdateControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerConfiguration(informer = @Informer(namespaces = WATCH_CURRENT_NAMESPACE))
@SuppressWarnings("unused")
public class JokeReconciler implements Reconciler<Joke>, Cleaner<Joke> {

    private static final Logger LOG = LoggerFactory.getLogger(JokeReconciler.class);

    @Override
    public UpdateControl<Joke> reconcile(Joke joke, Context<Joke> context) {
        String name = joke.getSpec().getName();
        LOG.info("Reconcile called for joke: {}", name);
        return UpdateControl.noUpdate();
    }

    public DeleteControl cleanup(Joke joke, Context<Joke> context) {
        String name = joke.getSpec().getName();
        LOG.info("Cleanup called for joke: {}", name);
        return DeleteControl.defaultDelete();
    }
}