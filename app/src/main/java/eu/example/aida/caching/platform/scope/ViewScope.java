package eu.example.aida.caching.platform.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Aida on 1/28/2019.
 */

@Retention(RetentionPolicy.RUNTIME)
@Scope
public @interface ViewScope
{

}
