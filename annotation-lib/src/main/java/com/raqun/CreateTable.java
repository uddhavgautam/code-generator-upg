package com.raqun;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author gaute
 */

@Retention(value = RetentionPolicy.CLASS)
@Target(value = ElementType.METHOD)
public @interface CreateTable {

    /**
     * The list of fields included in the table.
     *
     * @return The list of fields in the table.
     */
    String[] fieldsClientstatsCpusampleEntity();

}
