// ============================================================================
//
// Copyright (C) 2006-2015 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.daikon.properties.error;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.talend.daikon.exception.error.ErrorCode;

/**
 * Error codes for the Component service
 */
public enum PropertiesErrorCode implements ErrorCode {

                                                      MISSING_I18N_TRANSLATOR(
                                                                              HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                                                                              "key", //$NON-NLS-1$
                                                                              "baseName"), //$NON-NLS-1$
                                                      PROPERTIES_HAS_UNITIALIZED_PROPS(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "name", "field");

    /** The http status to use. */
    private int httpStatus;

    /** Expected entries to be in the context. */
    private List<String> expectedContextEntries;

    PropertiesErrorCode(int httpStatus) {
        this.httpStatus = httpStatus;
        this.expectedContextEntries = Collections.emptyList();
    }

    PropertiesErrorCode(int httpStatus, String... contextEntries) {
        this.httpStatus = httpStatus;
        this.expectedContextEntries = Arrays.asList(contextEntries);
    }

    /**
     * @return the product. Default value is Talend.
     */
    @Override
    public String getProduct() {
        return "Talend"; //$NON-NLS-1$
    }

    /**
     * @return the group. Default Value is ALL
     */
    @Override
    public String getGroup() {
        return "ALL"; //$NON-NLS-1$
    }

    /**
     * @return the http status.
     */
    @Override
    public int getHttpStatus() {
        return httpStatus;
    }

    /**
     * @return the expected context entries.
     */
    @Override
    public Collection<String> getExpectedContextEntries() {
        return expectedContextEntries;
    }

    @Override
    public String getCode() {
        return this.toString();
    }
}
