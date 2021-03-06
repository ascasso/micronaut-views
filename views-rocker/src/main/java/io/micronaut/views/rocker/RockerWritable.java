/*
 * Copyright 2017-2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.views.rocker;

import com.fizzed.rocker.RockerModel;
import io.micronaut.core.io.Writable;

import java.io.Writer;

/**
 * A {@link Writable} for Rocker templates.
 *
 * @author Sam Adams
 * @since 1.3.2
 */
public class RockerWritable implements Writable {

    private final RockerModel model;

    /**
     * @param model The populated Rocker template model
     */
    public RockerWritable(RockerModel model) {
        this.model = model;
    }

    @Override
    public void writeTo(Writer out) {
        model.render((contentType, charsetName) -> new RockerWriterOutput(out, contentType, charsetName));
    }

}
