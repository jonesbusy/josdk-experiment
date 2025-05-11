package io.github.jonesbusy.josdk;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;

@Group(Joke.GROUP)
@Version(Joke.VERSION)
@JsonInclude(Include.NON_NULL)
public class Joke extends CustomResource<JokeSpec, Void> implements Namespaced {

    public static final String GROUP = "samples.javaoperatorsdk.io";
    public static final String VERSION = "v1alpha1";
    public static final String NAME = "jokes." + GROUP;

    public Joke() {
    }


}