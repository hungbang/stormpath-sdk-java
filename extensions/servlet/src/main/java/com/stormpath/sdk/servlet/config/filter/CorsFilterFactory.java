/*
 * Copyright 2016 Stormpath, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stormpath.sdk.servlet.config.filter;

import com.stormpath.sdk.servlet.config.Config;
import com.stormpath.sdk.servlet.filter.cors.CorsFilter;

import javax.servlet.ServletContext;

/**
 * @since 1.2.0
 */
public class CorsFilterFactory extends FilterFactory<CorsFilter> {

    @Override
    protected CorsFilter createInstance(ServletContext servletContext, Config config) throws Exception {
        CorsFilter filter = new CorsFilter();
        filter.setAllowedOrigins(getConfig().getAllowedCorsOrigins());
        filter.setAllowedHttpHeaders(getConfig().getAllowedCorsHaders());
        filter.setAllowedHttpMethods(getConfig().getAllowedCorsMethods());
        filter.setEnabled(getConfig().isCorsEnabled());

        return filter;
    }
}
