/*
 * Copyright 2014 ASolyankin.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qantium.uisteps.serenity.browser.pages;

import com.qantium.uisteps.serenity.SerenityUtils;
import java.lang.annotation.Annotation;
import net.thucydides.core.annotations.DefaultUrl;

/**
 *
 * @author ASolyankin
 */
public class UrlFactory extends com.qantium.uisteps.core.browser.pages.UrlFactory {

    public UrlFactory() {
        super(DefaultUrl.class);
    }

    public UrlFactory(String host, Class<? extends Annotation> urlAnnotation) {
        super(host, urlAnnotation);
    }

    @Override
    protected Class<?> getPageClass(Class<?> clazz) {

        if (clazz.getName().contains("$$")) {
            return getPageClass(clazz.getSuperclass());
        } else {
            return clazz;
        }
    }

    @Override
    protected String getBaseUrl() {
        return new SerenityUtils().getBaseUrl();
    }

    @Override
    protected String getPageUrlFrom(Annotation urlAnnotation) {
        return ((DefaultUrl) urlAnnotation).value();
    }
}
